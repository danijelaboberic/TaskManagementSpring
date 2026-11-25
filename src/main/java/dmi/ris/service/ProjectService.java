package dmi.ris.service;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dim.ris.model.Picture;
import dim.ris.model.Project;
import dmi.ris.exception.ResourceNotFoundException;
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
		if (file != null && !file.isEmpty()) {
			try {
				Picture picture = new Picture();
				picture.setPicture(file.getBytes());
				picture.setProject(p);
				p.getPictures().add(picture);
			} catch (IOException e) {
				throw new UncheckedIOException("Greska pri citanju uploadovane slike", e);
			}
		}
		projectRepository.save(p);
	}
	
	public Project getProject(Integer id) {
		return projectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Projekat sa id=" + id + " ne postoji"));
	}

}
