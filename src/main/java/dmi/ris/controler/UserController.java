package dmi.ris.controler;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dim.ris.model.Role;
import dim.ris.model.User;
import dmi.ris.repository.RoleRepository;
import dmi.ris.repository.UserRepository;
import dmi.ris.validation.UserValidator;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserValidator userValidator;
	
	@InitBinder("user")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}
	
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
	public String save(@Valid @ModelAttribute("user") User user, BindingResult result, Model m) {
		if (result.hasErrors()) {
			return "register";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		m.addAttribute("korisnik", user.getName());

		return "register";
		
	}
	
}
