package com.nutrition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class NutritionServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutritionServicesApplication.class, args);
    }
}
