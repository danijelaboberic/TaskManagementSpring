package dmi.ris.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import dim.ris.model.User;
import dmi.ris.repository.UserRepository;

/**
 * Sopstveni Spring validator: proverava pravila koja Bean Validation anotacije
 * ne mogu da izraze, jer zahtevaju pristup bazi (jedinstveno korisnicko ime).
 * Registruje se u kontroleru preko @InitBinder i izvrsava se zajedno sa @Valid.
 */
@Component
public class UserValidator implements Validator {

	private final UserRepository userRepository;

	public UserValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		String username = user.getUsername();
		if (username != null && !username.isBlank() && userRepository.findByUsername(username) != null) {
			errors.rejectValue("username", "user.username.exists");
		}
	}
}
