package dmi.ris.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/language/set")
	public String getLanguage(@RequestParam("lang") String lang) {
		return "home";
	}
	
	

}
