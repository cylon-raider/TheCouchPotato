package com.gcu.cst452;

// Importing necessary libraries for Swagger Configuration
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Configuration class for Swagger API documentation.
 * <p>
 * This class is responsible for configuring the Swagger API documentation settings for the application.
 * It defines a Docket bean which is used by the Swagger to generate API documentation.
 *
 * @author Chris Markel
 * @version 1.0
 */
@Configuration // Annotation to indicate that this is a configuration class
public class SwaggerConfig {

    /**
     * Bean for Docket to configure Swagger 2.
     *
     * @return a configured Docket instance
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) // Specifying the use of Swagger 2
                .select() // Initiating a builder for API selection
                .apis(RequestHandlerSelectors.any()) // Allowing any API to be documented
                .paths(PathSelectors.any()) // Allowing any path to be documented
                .build(); // Building the Docket instance
    }
}
