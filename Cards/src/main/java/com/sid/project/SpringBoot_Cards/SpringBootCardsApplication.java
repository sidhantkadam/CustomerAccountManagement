package com.sid.project.SpringBoot_Cards;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservice REST API Documentation",
				description = "NSK Bank Cards microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Sid K",
						email = "siddhantkadam044@gmail.com"
				)
		)
)
public class SpringBootCardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCardsApplication.class, args);
	}

}
