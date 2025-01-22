package com.sid.project.SpringBoot_Loans;

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
				title = "Loan microservice REST API Documentation",
				description = "NSK Bank Loan microservice REST API Documentation",
				version = "v2",
				contact = @Contact(
						name = "Sid K",
						email = "siddhantkadam044@gmail.com"
				)
		)
)
public class SpringBootCustomerLoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCustomerLoansApplication.class, args);
	}

}
