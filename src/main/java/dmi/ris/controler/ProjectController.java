package dmi.ris.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dim.ris.model.Project;
import dim.ris.model.User;
import dmi.ris.repository.ProjectRepository;
import dmi.ris.repository.UserRepository;
import dmi.ris.service.EmailService;
import dmi.ris.service.ProjectService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
@RequestMapping("projects")
public class ProjectController {
	
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProjectService projectService;
	
	@ModelAttribute("leaders")
	public List<User> getLeaders(){
		List<User> users = userRepository.findAll();
		return users;
		
	}
	
	@GetMapping("/all")
	public String getAllProjects(Model m) {
		List<Project> projects = projectService.searchProject("");
		m.addAttribute("projects", projects);
		return "projects";
	}
	
	@GetMapping("/admin/add")
	public String addProject(@ModelAttribute Project project, Model m) {
		return "addProject";
	}
	
	@PostMapping("/admin/save")
	public String saveProject(@Valid Project p, BindingResult e, @RequestParam("file") MultipartFile file) {
		if (e.hasErrors()) {
			return "addProject";
		}else {
			projectService.saveProject(p,file);
			return "redirect:/projects/all";	
		}

	}
	
	@GetMapping("/manager/contactLeader")
	public String contactLeader(@RequestParam("email") String email) {
		String text = "Dobar dan, zelim da saradjujem sa vama. Molim vas da me kontaktirate!";
		emailService.sendEmail(email, "user@ris.pmf","Contact leader", text);
		return "redirect:/projects/all";	
	}
	
	@GetMapping(value = "show/{projectID}")
	public void getPicture(@PathVariable("projectID") Integer projectID, HttpServletResponse response) {
		Project p = projectService.getProject(projectID);
        if (p != null) {
        	byte[] slika = p.getPictures().iterator().next().getPicture();
    		if (slika != null) {
    			try {
    				response.setContentType("image/jpg");
    				response.getOutputStream().write(slika);
    			} catch (Exception e) {
    			
    				e.printStackTrace();
    			}
    		}
        }
		
	
	}

}
