package com.jtc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwer")
public class ENotesRest2Application {

	public static void main(String[] args) {
		SpringApplication.run(ENotesRest2Application.class, args);
	}

}
