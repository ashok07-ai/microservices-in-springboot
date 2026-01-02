package com.stack.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*
* @ComponentScans({ @ComponentScan("com.sevenstack.accounts.controller")})
* @EnableJpaRepositories("com.sevenstack.accounts.repository")
* @EntityScan("com.sevenstack.accounts.repository")
* */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservices REST API Documentation",
				description = "SevenStack Accounts microservices REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Seven stack",
						email = "tutor@sevenstack.com",
						url = "https://www.sevenstack.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.sevenstack.com"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "SevenStack Accounts microservices REST API Documentation",
				url = "https:///www.sevenstack.com/swagger-ui.html"
		)

)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
