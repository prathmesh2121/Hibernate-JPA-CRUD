package com.example.Hibernate_JPA_CRUD;

import com.example.Hibernate_JPA_CRUD.dao.StudentDAO;
import com.example.Hibernate_JPA_CRUD.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
            //createMultipleStudent(studentDAO);
            // readStudent(studentDAO);
            //readAllStudent(studentDAO);
            //readByLastName(studentDAO);
            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO)
    {
        System.out.println("Updating student object ...");
        int theId = 4;

        Student theStudent =  studentDAO.findById(theId);
        System.out.println("Before update : "+theStudent);

        theStudent.setLast_name("Pawar");
        studentDAO.update(theStudent);
        System.out.println("After update : "+theStudent);
    }


    private void readByLastName(StudentDAO studentDAO){
        System.out.println("Reading student object by last name ...");

        List<Student> theStudents = studentDAO.findByLastName("Patil");
        System.out.println("Total result found : "+theStudents.size());

        for(Student tempStudent : theStudents)
        {
            System.out.println(tempStudent);
        }
    }


    private void readAllStudent(StudentDAO studentDAO)
    {
        System.out.println("Reading all student object ...");

        List<Student> theStudents = studentDAO.findAll();
        for(Student tempStudent : theStudents)
        {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO)
    {
        System.out.println("Reading student object ...");
        int theId = 1;

        Student tempStudent = studentDAO.findById(theId);
        System.out.println("Student found : "+tempStudent);
    }


    private void createMultipleStudent(StudentDAO studentDAO)
    {
        System.out.println("Creating new student objects ...");

        Student tempStudent1 = new Student("Hemant", "Patil", "hemant.patil@infosys.com");
        Student tempStudent2 = new Student("Akshay", "Patil", "akshay.patil@tox.com");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        System.out.println(tempStudent1.getFirst_name()+" "+
                           tempStudent2.getFirst_name()+" "+"Saved student objects ...");


    }

    private void createStudent(StudentDAO studentDAO)
    {
        System.out.println("Creating new student object ...");

        Student tempStudent = new Student("Puja", "", "puja-borse@db.com");
        studentDAO.save(tempStudent);

        System.out.println(tempStudent.getFirst_name() + " : Student object saved ...");
    }
}

