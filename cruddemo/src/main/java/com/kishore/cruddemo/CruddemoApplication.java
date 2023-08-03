package com.kishore.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.kishore.cruddemo.dao.StudentDao;
import com.kishore.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		ApplicationContext c = SpringApplication.run(CruddemoApplication.class, args);
	     StudentDao dao = c.getBean(StudentDao.class);
		//createStudent(dao);
		//readStudent(dao);
		//readAll(dao,"Reddy");
	    // update(dao,"Pochana");
	     //delete(dao,8);
	     deleteAll(dao);
	}
	
	private static void deleteAll(StudentDao dao) {
		
		int n=dao.deleteAllStudent();
		System.out.println("Total no of students deleted ="+n);
		
	}

	private static void delete(StudentDao dao, int i) {
		
		dao.deleteStudentById(i);
		
	}

	private static void update(StudentDao dao, String string) {
		
		Student s = dao.findById(2);
		
		s.setLastName(string);
		dao.updateLastName(s);
		
	}

	private static void readAll(StudentDao dao, String string) {
		
		List<Student> arr =dao.queryToSelectStudent(string);
		
		for(Student p:arr)
			System.out.println(p);
	}

	@Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDAO)
    {
    	
		return runner ->{
			
		};
    }
	private static void createStudent(StudentDao studentDAO) {
		
		System.out.println("creating new obecct");
		
		Student tempStudent = new Student("Narap","vasudeva","vasudev@gamil.com");
		
		System.out.println("saving student");
		
		
		studentDAO.save(tempStudent);
		System.out.println("id="+tempStudent.getId());
	}
	
	private static void readStudent(StudentDao studentDAO)
	{
		Student s = studentDAO.findById(2);
		System.out.println(s);
		
	}
	
}
