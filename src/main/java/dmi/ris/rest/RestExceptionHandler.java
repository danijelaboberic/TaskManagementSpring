package dmi.ris.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dmi.ris.exception.ResourceNotFoundException;

/**
 * Obrada gresaka za REST servise: vraca JSON i odgovarajuci HTTP status
 * umesto HTML stranice "error" (koju vraca HomeController za obicne stranice).
 */
@RestControllerAdvice(basePackages = "dmi.ris.rest")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleException(Exception e) {
		log.error("Greska u REST servisu", e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(Map.of("error", "Doslo je do greske na serveru"));
	}
}
