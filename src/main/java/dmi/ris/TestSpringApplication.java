package dmi.ris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dmi.ris")
public class TestSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringApplication.class, args);
	}

}
