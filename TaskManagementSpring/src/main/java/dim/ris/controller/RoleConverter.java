package dim.ris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import dim.ris.model.Role;
import dim.ris.repository.RoleRepository;

public class RoleConverter implements Converter<String, Role> {
   
	@Autowired
	RoleRepository rr;
	@Override
	public Role convert(String source) {
		return rr.getOne(Integer.parseInt(source));
	}

}
