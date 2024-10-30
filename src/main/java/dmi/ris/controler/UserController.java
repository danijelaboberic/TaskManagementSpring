package dmi.ris.controler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dmi.ris.dto.RoleDTO;
import dmi.ris.dto.UserDTO;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@ModelAttribute("roleList") 
	private List<RoleDTO> initRoles(){
		//TODO povuci iz baze spisak uloga
		List<RoleDTO> roles = new ArrayList();
		RoleDTO r1 = new RoleDTO("1","ADMIN");
		RoleDTO r2 = new RoleDTO("2","RADNIK");
		RoleDTO r3 = new RoleDTO("3","DIREKTOR");

		roles.add(r1);
		roles.add(r2);
		roles.add(r3);
		return roles;
	}
	
	@ModelAttribute("user")
	public UserDTO initUser(){
		UserDTO u = new UserDTO();
		return u;
	}
	
	@GetMapping("/register")
	public String showRegisterJSP(@ModelAttribute("user") UserDTO user) {	
		return "register";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("user") UserDTO user, Model m) {
		//TODO sacuvaj korisnika u bazu
		System.out.println("Uloga korisnika: "+user.getUloga().getValue());
		m.addAttribute("poruka", "Uspesno sacuvan korisnik");
		m.addAttribute("korisnik", user.getName());

		return "register";
		
	}
	
}
