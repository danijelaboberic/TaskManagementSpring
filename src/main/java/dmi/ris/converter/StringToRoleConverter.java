package dmi.ris.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import dim.ris.model.Role;
import dmi.ris.repository.RoleRepository;

/**
 * Pretvara String vrednost iz zahteva (id uloge iz padajuce liste)
 * u objekat Role iz baze. Registruje se u WebConfig.addFormatters.
 */
@Component
public class StringToRoleConverter implements Converter<String, Role> {

	private final RoleRepository roleRepository;

	public StringToRoleConverter(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Role convert(String source) {
		if (source == null || source.isBlank()) {
			return null;
		}
		return roleRepository.findById(Integer.valueOf(source.trim())).orElse(null);
	}
}
