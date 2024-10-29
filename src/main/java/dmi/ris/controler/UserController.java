package dmi.ris.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/register")
	public String showRegisterJSP() {
		return "register";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("ime") String ime, Model m) {
		//TODO sacuvaj korisnika u bazu
		System.out.println("ime korisnika: "+ime);
		m.addAttribute("poruka", "Uspesno sacuvan korisnik");
		m.addAttribute("korisnik", ime);

		return "register";
		
	}

}
