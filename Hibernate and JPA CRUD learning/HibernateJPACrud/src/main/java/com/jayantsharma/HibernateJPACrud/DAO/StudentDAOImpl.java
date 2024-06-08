package com.jayantsharma.HibernateJPACrud.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jayantsharma.HibernateJPACrud.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

// @Repository Annotations
// 1. Specialized annotation for repositories
// 2. Supports component scanning
// 3. Translates JDBC exceptions
@Repository
public class StudentDAOImpl implements StudentDAO{

    //declare the entity manager field
    private EntityManager entityManager;

    // creating a constructor to initialize the object
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
        
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        
        // creating the query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
       
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData",Student.class);
        theQuery.setParameter("theData", lastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
       entityManager.merge(student);
    }
    
    
}
