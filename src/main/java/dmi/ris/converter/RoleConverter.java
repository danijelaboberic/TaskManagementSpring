package dmi.ris.converter;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import dim.ris.model.Role;
import dmi.ris.dto.RoleDTO;
import dmi.ris.repository.RoleRepository;

@Component
public class RoleConverter implements Converter<Integer, Role> {

    @Autowired
    RoleRepository roleRepository;

   @Override
    public Role convert(Integer source) {
        if (source == null) {
            return null;
        }  
            return roleRepository.findById(source).get();   
    }
}

