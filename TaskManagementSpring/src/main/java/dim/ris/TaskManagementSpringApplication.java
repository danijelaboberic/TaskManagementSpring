package dim.ris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication
public class TaskManagementSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskManagementSpringApplication.class, args);
	}

}
