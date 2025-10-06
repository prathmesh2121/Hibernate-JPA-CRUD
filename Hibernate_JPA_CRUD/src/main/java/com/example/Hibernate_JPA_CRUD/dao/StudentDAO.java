package com.example.Hibernate_JPA_CRUD.dao;

import com.example.Hibernate_JPA_CRUD.entity.Student;

import java.util.List;

public interface StudentDAO
{
    void save(Student theStudent);
    Student findById(int theId);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);
    void update(Student theStudent);
}
