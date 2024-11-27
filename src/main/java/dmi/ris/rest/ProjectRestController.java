package dmi.ris.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dim.ris.model.Project;
import dmi.ris.service.ProjectService;

@RestController
@RequestMapping("rest/projects")
public class ProjectRestController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping(value = "/get/{keyword}")
	public ResponseEntity<List<Project>> getAllProjects(@PathVariable("keyword") String keyword){
		List<Project> result = projectService.searchProject(keyword);
		if (result !=null && !result.isEmpty()) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
