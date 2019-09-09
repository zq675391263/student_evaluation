package com.cqgcxy.evaluation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity   //开启security
public class StudentEvaluationApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentEvaluationApplication.class, args);
    }

}
