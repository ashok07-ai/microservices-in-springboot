package com.stack.cards;

import com.stack.cards.dto.CardsContactInfoDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = {CardsContactInfoDTO.class})
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
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
