package dmi.ris.converter;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.util.HashMap;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import dmi.ris.dto.RoleDTO;

@Component
public class RoleConverter implements Converter<String, RoleDTO> {

   private HashMap<String, RoleDTO> roleService = new HashMap();
    
   public RoleConverter(){
     this.roleService.put("1", new RoleDTO("1","ADMIN"));
     this.roleService.put("2", new RoleDTO("2","RADNIK"));
     this.roleService.put("3", new RoleDTO("3","DIREKTOR"));


   }
   @Override
    public RoleDTO convert(String source) {
        if (source == null) {
            return null;
        }  
            return roleService.get(source);   
    }
}

