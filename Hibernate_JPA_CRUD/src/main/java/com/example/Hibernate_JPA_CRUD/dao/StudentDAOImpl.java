package com.example.Hibernate_JPA_CRUD.dao;

import com.example.Hibernate_JPA_CRUD.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO
{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent)
    {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int theId) {
        return entityManager.find(Student.class, theId);
    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
        List<Student> studentResult = theQuery.getResultList();
        return studentResult;

    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        TypedQuery<Student> theQuery = entityManager.createQuery("from Student where last_name = :lname order by first_name", Student.class);
        theQuery.setParameter("lname",theLastName);
        List<Student> studentResult = theQuery.getResultList();
        return studentResult;
    }

    @Override
    @Transactional
    public void update(Student theStudent)
    {
        entityManager.merge(theStudent); //merge for update


    }
}
