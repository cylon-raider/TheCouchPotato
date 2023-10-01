package com.gcu.cst452;
// Importing necessary libraries for Spring Boot and Swagger
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main class for the CST-452 application.
 * <p>
 * This class is responsible for starting the Spring Boot application.
 * It also enables the Swagger2 tool for API documentation.
 *
 * @author Chris Markel
 * @version 1.0
 */
@EnableSwagger2 // Annotation to Enable Swagger2 for API documentation
@SpringBootApplication // Annotation to mark this as a Spring Boot application
public class Cst452Application {

    /**
     * The entry point of the Spring Boot application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Starting the Spring Boot application
        SpringApplication.run(Cst452Application.class, args);
    }

}
