package dmi.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import dim.ris.model.Project;

@Service
public class TimerService {
	@Autowired
	ProjectService projectService;
	
	@Scheduled(cron = "0 0 13 * * ?")
	public void repeatSomething() {
		System.out.println("Tajmer je trigerovan u 13:00...");
		//TODO implementacija neke poslovne logike
	
	
	}

}
