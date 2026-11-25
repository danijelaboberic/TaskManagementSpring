package dmi.ris.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dmi.ris.converter.StringToRoleConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final StringToRoleConverter stringToRoleConverter;

	public WebConfig(StringToRoleConverter stringToRoleConverter) {
		this.stringToRoleConverter = stringToRoleConverter;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(stringToRoleConverter);
	}
}
