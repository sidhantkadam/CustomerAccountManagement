package com.sid.project.SpringBoot_CustomerAccount;

import com.sid.project.SpringBoot_CustomerAccount.DTO.AccountContactInfoDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(AccountContactInfoDto.class)
@OpenAPIDefinition(info = @Info(
		title = "Account Microservice REST API Documentation",
		description = "NSK Bank Account Microservice REST API Documentation",
		version = "v1",
		contact = @Contact(
				name = "Sid K",
				email = "siddhantkadam044@gmail.com")
		))
public class SpringBootCustomerAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCustomerAccountApplication.class, args);
	}

}
