package dmi.ris.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/rest/holidays")
public class RestHolidayController {
	
@Autowired
RestTemplate restTemplate;

@SuppressWarnings("rawtypes")
@GetMapping("/get/{year}")
@Operation(summary = "Servis koji vraca sve praznike u Srbiji")
public ResponseEntity<List> getAllHolidays(@PathVariable("year") int year){
	return restTemplate.getForEntity("https://date.nager.at/api/v3/publicholidays/"+year+"/RS"
			+ "", List.class);

}



}
