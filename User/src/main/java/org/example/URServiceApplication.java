package org.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@SpringBootApplication
@OpenAPIDefinition
public class URServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(URServiceApplication.class, args);
    }

}