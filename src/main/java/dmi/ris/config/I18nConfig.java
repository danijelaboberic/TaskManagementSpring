package dmi.ris.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class I18nConfig implements WebMvcConfigurer{

	    @Bean
	    LocaleResolver localeResolver() {
	        SessionLocaleResolver slr = new SessionLocaleResolver();
	        return slr;
	    }

	    @Bean
	    LocaleChangeInterceptor localeChangeInterceptor() {
	        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	        lci.setParamName("lang");
	        return lci;
	    }

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(localeChangeInterceptor());
	    }
	}
