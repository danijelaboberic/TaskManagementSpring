package dmi.ris.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dim.ris.model.Project;
import dmi.ris.repository.ProjectRepository;

@Controller
@RequestMapping("projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@GetMapping("/all")
	public String getAllProjects(Model m) {
		List<Project> projects = projectRepository.findAll();
		m.addAttribute("projects", projects);
		return "projects";
	}

}
