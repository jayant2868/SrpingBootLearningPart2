package com.jayantsharma.HibernateJPACrud.DAO;

import java.util.List;

import com.jayantsharma.HibernateJPACrud.Entity.Student;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);
    
    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
