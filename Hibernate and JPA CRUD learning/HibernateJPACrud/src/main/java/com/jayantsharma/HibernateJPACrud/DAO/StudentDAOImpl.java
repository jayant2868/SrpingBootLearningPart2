package com.jayantsharma.HibernateJPACrud.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jayantsharma.HibernateJPACrud.Entity.Student;

import jakarta.persistence.EntityManager;

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

}
