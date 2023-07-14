package com.kishore.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishore.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@Repository
public class StudentDAOImpl implements studentDAO{

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager)
	{
		this.entityManager=entityManager;
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		
		entityManager.persist(theStudent);
	}
	
	

}
