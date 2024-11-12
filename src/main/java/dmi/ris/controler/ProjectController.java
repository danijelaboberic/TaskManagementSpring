package dmi.ris.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dim.ris.model.Project;
import dim.ris.model.User;
import dmi.ris.repository.ProjectRepository;
import dmi.ris.repository.UserRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@ModelAttribute("leaders")
	public List<User> getLeaders(){
		List<User> users = userRepository.findAll();
		return users;
		
	}
	
	@GetMapping("/all")
	public String getAllProjects(Model m) {
		List<Project> projects = projectRepository.findAll();
		m.addAttribute("projects", projects);
		return "projects";
	}
	
	@GetMapping("/add")
	public String addProject(@ModelAttribute Project project, Model m) {
		return "addProject";
	}
	
	@PostMapping("/save")
	public String saveProject(@Valid Project p, BindingResult e) {
		if (e.hasErrors()) {
			return "addProject";
		}else {
			projectRepository.save(p);
			return "redirect:/projects/all";	
		}

	}

}
