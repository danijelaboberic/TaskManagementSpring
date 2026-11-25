package dmi.ris.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import dim.ris.model.Role;
import dim.ris.model.User;
import dmi.ris.converter.StringToRoleConverter;
import dmi.ris.repository.RoleRepository;
import dmi.ris.repository.UserRepository;

class UserValidationTest {

	private User validUser() {
		User u = new User();
		u.setName("Pera Peric");
		u.setUsername("pera@uns.ac.rs");
		u.setPassword("123456");
		u.setRole(new Role());
		return u;
	}

	private Errors validateWithBeanValidation(User u, Locale locale) {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasename("message");
		ms.setDefaultEncoding("UTF-8");
		ms.setFallbackToSystemLocale(false);
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(ms);
		validator.afterPropertiesSet();

		LocaleContextHolder.setLocale(locale);
		Errors errors = new BeanPropertyBindingResult(u, "user");
		validator.validate(u, errors);
		LocaleContextHolder.resetLocaleContext();
		return errors;
	}

	@Test
	void ispravanKorisnikNemaGresaka() {
		assertFalse(validateWithBeanValidation(validUser(), Locale.ENGLISH).hasErrors());
	}

	@Test
	void beanValidationPorukeSuLokalizovane() {
		User u = validUser();
		u.setUsername("nije-email");
		u.setPassword("123");
		u.setRole(null);

		Errors en = validateWithBeanValidation(u, Locale.ENGLISH);
		assertEquals("Username must be a valid email address", en.getFieldError("username").getDefaultMessage());
		assertEquals("Password must be at least 6 characters long", en.getFieldError("password").getDefaultMessage());
		assertEquals("Role is required", en.getFieldError("role").getDefaultMessage());

		Errors sr = validateWithBeanValidation(u, new Locale("sr"));
		assertEquals("Lozinka mora imati najmanje 6 karaktera", sr.getFieldError("password").getDefaultMessage());
	}

	@Test
	void userValidatorOdbijaPostojeceKorisnickoIme() {
		UserRepository repo = mock(UserRepository.class);
		when(repo.findByUsername("pera@uns.ac.rs")).thenReturn(new User());
		User u = validUser();
		Errors errors = new BeanPropertyBindingResult(u, "user");

		new UserValidator(repo).validate(u, errors);

		assertEquals("user.username.exists", errors.getFieldError("username").getCode());
	}

	@Test
	void konverterPretvaraIdUUlogu() {
		RoleRepository repo = mock(RoleRepository.class);
		Role admin = new Role();
		when(repo.findById(1)).thenReturn(Optional.of(admin));
		StringToRoleConverter converter = new StringToRoleConverter(repo);

		assertEquals(admin, converter.convert("1"));
		assertNull(converter.convert(""));
	}
}
