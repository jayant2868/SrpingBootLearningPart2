package com.jayantsharma.HibernateJPACrud;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaCrudApplication.class, args);
	}
	// CommandLineRunner is from the springboot interface
	// This tool is provided by the Spring framework for quickly developing and testing Spring Boot applications from the command prompt.
	// The code is executed after the Spring Beans have loaded.
	@Bean
	public CommandLineRunner commandLineRunner(String[] args)
	{
		return runner -> {
			System.out.println("Hello World");
		};
	}

}
