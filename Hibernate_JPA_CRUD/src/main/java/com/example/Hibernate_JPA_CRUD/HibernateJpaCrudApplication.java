package com.example.Hibernate_JPA_CRUD;

import com.example.Hibernate_JPA_CRUD.dao.StudentDAO;
import com.example.Hibernate_JPA_CRUD.entity.Student;
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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            createMultipleStudent(studentDAO);

        };
    }

    private void createMultipleStudent(StudentDAO studentDAO)
    {
        System.out.println("Creating new student objects ...");

        Student tempStudent1 = new Student("Mayur", "Kumbhar", "mayur.kumbhar@tcs.com");
        Student tempStudent2 = new Student("Surbhi", "Marathe", "surbhi.marathe@forvia.com");
        Student tempStudent3 = new Student("Tejas", "Ghate", "tejas.ghate@hsbc.com");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
        System.out.println(tempStudent1.getFirst_name()+" "+
                           tempStudent2.getFirst_name()+" "+
                           tempStudent3.getFirst_name()+" "+"Saved student objects ...");


    }

    private void createStudent(StudentDAO studentDAO)
    {
        System.out.println("Creating new student object ...");

        Student tempStudent = new Student("Puja", "", "puja-borse@db.com");
        studentDAO.save(tempStudent);

        System.out.println(tempStudent.getFirst_name() + " : Student object saved ...");
    }
}

