package com.racetolife.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.racetolife")
@SpringBootApplication
public class RaceToLifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaceToLifeApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RaceToLifeApplication.class);
	}

}