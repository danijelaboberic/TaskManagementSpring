package dmi.ris.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class RoleDTO implements  Serializable{
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String value;
	
    public RoleDTO() {
    	
    }
    
	public RoleDTO(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	

}
