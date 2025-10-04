package com.example.Hibernate_JPA_CRUD;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateJpaCrudApplication.class, args);
    }

    // CommandLineRunner is a special interface in Spring Boot that allows you to run code automatically
    // right after the application starts (after the Spring context is loaded).

    @Bean
    public CommandLineRunner commandLineRunner(String[] args) {
        return runner -> {
            System.out.println("Hello, Hibernate JPA CRUD Application!");
        };
    }

}

