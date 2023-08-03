package com.kishore.cruddemo.dao;

import java.util.List;

import com.kishore.cruddemo.entity.Student;

public interface StudentDao {

	
	public void save(Student theStudent);
	
	public Student findById(Integer id);
	
	public List<Student> queryToSelectStudent(String lastName);
	
	public void updateLastName(Student s);
	
	public void deleteStudentById(Integer id);
	
	public int deleteAllStudent();
}

