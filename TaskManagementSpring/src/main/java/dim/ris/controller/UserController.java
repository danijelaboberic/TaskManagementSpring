package dim.ris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dim.ris.model.Role;
import dim.ris.model.User;
import dim.ris.repository.RoleRepository;
import dim.ris.repository.UserRepository;

@Controller

public class UserController {

	@Autowired
	UserRepository ur;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping ("/users/getAll")
	public String getAll(Model m){
		m.addAttribute("users", ur.findAll());
		return "registerUser";
	}
	
	@PostMapping ("/admin/add")
	public String addUser(User u) {
     	u.setPassword(passwordEncoder.encode(u.getPassword()));
		ur.save(u);
		return "redirect:/users/getAll";
	}
	
    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable("id") int id) {
    	ur.deleteById(id);
    	return "redirect:/users/getAll";
    	
    }

}
