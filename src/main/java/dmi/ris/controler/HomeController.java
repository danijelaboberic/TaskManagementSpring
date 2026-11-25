package dmi.ris.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import dmi.ris.exception.ResourceNotFoundException;


@Controller
@ControllerAdvice
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/language/set")
	public String getLanguage(@RequestParam("lang") String lang) {
		return "home";

	}
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e) throws Exception {
		// izuzeci anotirani sa @ResponseStatus (npr. ResourceNotFoundException)
		// prepustaju se Spring-u, koji postavlja zadati HTTP status
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
			throw e;
		}
		log.error("Neobradjena greska", e);
		return "error";
	}
	
	

}
