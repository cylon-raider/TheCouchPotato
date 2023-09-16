package com.gcu.cst452;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Cst452Application {

    public static void main(String[] args) {
        SpringApplication.run(Cst452Application.class, args);
    }

}
