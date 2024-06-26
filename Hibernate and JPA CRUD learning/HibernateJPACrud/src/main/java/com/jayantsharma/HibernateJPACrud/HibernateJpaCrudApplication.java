package com.jayantsharma.HibernateJPACrud;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jayantsharma.HibernateJPACrud.DAO.StudentDAO;
import com.jayantsharma.HibernateJPACrud.Entity.Student;

@SpringBootApplication
public class HibernateJpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaCrudApplication.class, args);
	}
	// CommandLineRunner is from the springboot interface
	// This tool is provided by the Spring framework for quickly developing and testing Spring Boot applications from the command prompt.
	// The code is executed after the Spring Beans have loaded.
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner -> {
			//createStudent(studentDAO);

			//readStudent(studentDAO);

			//getAllStudents(studentDAO);

			// getAllStudentByLastName(studentDAO);

			// updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}
	private void deleteAllStudents(StudentDAO studentDAO) {
	
		System.out.println("Deleting all students");
		studentDAO.deleteAll();
		System.out.println("Deleted all");
	}
	private void deleteStudent(StudentDAO studentDAO) {
		
		int studentId = 2;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}
	private void updateStudent(StudentDAO studentDAO) {

		// Get the student based on the primary key
		Student student = studentDAO.findById(1);
		// change the first name to "Karan"
		student.setFirstName("Karan");
		// Update the student
		studentDAO.update(student);
		// display the updated student record.
		System.out.println(studentDAO.findById(1));
	}
	private void getAllStudentByLastName(StudentDAO studentDAO) {
		
		// Get the list of students by last name
		List<Student> studentList = studentDAO.findByLastName("Sharma");

		for(Student students:studentList)
		{
			System.out.println(students);
		}
	}
	private void getAllStudents(StudentDAO studentDAO) {
		
		// Get All student list
		List<Student> studentList = studentDAO.findAll();

		// print the list of all student.
		for(int i=0;i<studentList.size();i++)
		System.out.println(studentList.get(i));
	}
	private void createStudent(StudentDAO studentDAO) {
		
		// create a student object and initialize

		System.out.println("Creating new Student object .....");
		Student tempStudent = new Student("Jayant","Sharma","jayant@gmail.com");

		// saving the student object
		System.out.println("Saving Student object .....");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved Student. Generated id: " + tempStudent.getId());
	}
	
	private void readStudent(StudentDAO studentDAO) {
		
		// create a student object and initialize

		System.out.println("Creating new Student object .....");
		Student tempStudent = new Student("Priya","Rani","Prani@gmail.com");

		// saving the student object
		System.out.println("Saving Student object .....");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Generated id : " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display the student
		System.out.println("Saved Student. Generated id: " + myStudent);
	}

}
