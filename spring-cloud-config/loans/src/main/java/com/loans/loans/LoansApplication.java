package com.loans.loans;

import com.loans.loans.dto.LoansContactInfoDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {LoansContactInfoDTO.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Cards microservices REST API Documentation",
				description = "SevenStack Cards microservices REST API Documentation",
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
				description = "SevenStack Cards microservices REST API Documentation",
				url = "https:///www.sevenstack.com/swagger-ui.html"
		)

)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
