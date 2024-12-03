package dmi.ris.controler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dim.ris.model.Role;
import dim.ris.model.User;
import dmi.ris.repository.RoleRepository;
import dmi.ris.repository.UserRepository;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@ModelAttribute("roleList")
	private List<Role> initRoles(){
		List<Role> roles = roleRepository.findAll();	
		return roles;
	}
	
	@ModelAttribute("user")
	public User initUser(){
		User u = new User();
		return u;
	}
	
	@GetMapping("/register")
	public String showRegisterJSP(@ModelAttribute("user") User user) {	
		return "register";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("user") User user, Model m) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		m.addAttribute("poruka", "Uspesno sacuvan korisnik");
		m.addAttribute("korisnik", user.getName());

		return "register";
		
	}
	
}
