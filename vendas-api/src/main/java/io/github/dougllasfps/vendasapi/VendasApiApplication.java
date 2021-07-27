package io.github.dougllasfps.vendasapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VendasApiApplication {
	
	@Autowired
	private Environment env;
	
	@GetMapping("/env")
	public String getProperties() {
		String ambiente = env.getActiveProfiles()[0];
		String appName = env.getProperty("spring.application.name");
		return String.format("Ambiente: %s | Nome da App: %s", ambiente, appName);
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasApiApplication.class, args);
	}

}
