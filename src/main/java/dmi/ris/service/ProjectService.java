package dmi.ris.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dim.ris.model.Picture;
import dim.ris.model.Project;
import dmi.ris.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	//@Cacheable("projects")
	public List<Project> searchProject(String query){
		if(query == null || query.isBlank()) {
			return projectRepository.findAll();
		}else {
			return projectRepository.findByDescriptionContaining(query);
		}
	}
	
	public void saveProject(Project p, MultipartFile file) {
		try {
			Picture picture = new Picture();
			picture.setPicture(file.getBytes());
			picture.setProject(p);
			p.getPictures().add(picture);
			projectRepository.save(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public Project getProject(Integer id) {
		Optional<Project> pro = projectRepository.findById(id);
		if (pro.isPresent()) {
			return pro.get();
		}else {
			return null;
		}
	}

}
