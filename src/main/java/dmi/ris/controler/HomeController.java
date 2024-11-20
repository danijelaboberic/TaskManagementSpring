package dmi.ris.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmi.ris.exception.ResourceNotFoundException;


@Controller
@ControllerAdvice
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		//throw new RuntimeException();
		return "home";
	}
	
	@GetMapping("/language/set")
	public String getLanguage(@RequestParam("lang") String lang) {
		return "home";

	}
	
	@ExceptionHandler(value=Exception.class)
	public String handleException() {
		return "error";
	}
	
	

}
