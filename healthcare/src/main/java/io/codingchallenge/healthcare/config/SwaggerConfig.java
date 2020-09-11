/**
 * 
 */
package io.codingchallenge.healthcare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

/**
 * @author v.huggila
 *
 */
@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI enrollOpenApiSpec() {

		return new OpenAPI().info(new Info().title("This service is used to enrolling")
				.description(
						"This service has operations to ADD, UPDATE and DELETE enroller and/or Dependants information")
				.version("").contact(new Contact().email("").name("").url("")));

	}

}
