package dmi.ris.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Controller

public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/language/set")
	public String getLanguage(@RequestParam("lang") String lang, HttpServletRequest m) {
		return "home";
	}
	
	

}
