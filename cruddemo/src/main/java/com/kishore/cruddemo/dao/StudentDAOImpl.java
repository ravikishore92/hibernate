package com.kishore.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishore.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class StudentDAOImpl implements StudentDao{
     @Autowired
	private EntityManager entityManager;
	
	
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		
		entityManager.persist(theStudent);
	}
	
	@Override
	public Student findById(Integer id)
	{
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> queryToSelectStudent(String lastname) {
		
		TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
		
		theQuery.setParameter("theData",lastname);
		
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void updateLastName(Student student) {
		
		entityManager.merge(student);
	}

	@Override
	@Transactional
	public void deleteStudentById(Integer id) {
		
		Student s = findById(id);
		
		entityManager.remove(s);
	}

	@Override
	@Transactional
	public int deleteAllStudent() {
		
		int x=entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return x;
	}
	
	

}
