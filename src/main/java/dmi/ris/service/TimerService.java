package dmi.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import dim.ris.model.Project;

@Service
public class TimerService {
	@Autowired
	ProjectService projectService;
	
	@Scheduled(fixedRate = 20000)
	public void repeatSomething() {
		System.out.println("Tajmer je trigerovan...");
		//TODO implementacija neke poslovne logike
	
	
	}

}
