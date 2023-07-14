package com.kishore.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kishore.cruddemo.dao.studentDAO;
import com.kishore.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner commandLineRunner(studentDAO studentDAO)
    {
    	
		return runner ->{
			createStudent(studentDAO);
		};
    }
	private void createStudent(studentDAO studentDAO) {
		
		System.out.println("creating new obecct");
		
		Student tempStudent = new Student("jaggu","gangisetty","gaggisetty@gamil.com");
		
		System.out.println("saving student");
		
		
		studentDAO.save(tempStudent);
		
		System.out.println("id="+tempStudent.getId());
	}
}
