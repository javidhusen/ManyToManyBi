package com.ty.teacher.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.teacher.dto.Subject;
import com.ty.teacher.dto.Teacher;

public class TeacherDao {

	void saveTeacher() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Teacher teacher = new Teacher();
		teacher.setName("Bhavya");
		teacher.setAge(23);
		
		Subject subject = new Subject();
		subject.setName("CS");
		subject.setDays(45);
		
		Subject subject1 = new Subject();
		subject1.setName("Physics");
		subject1.setDays(60);
		
		List<Subject> ls = new ArrayList<Subject>();
		ls.add(subject);
		ls.add(subject1);
		
		teacher.setSubject(ls);
		
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityManager.persist(subject);
		entityManager.persist(subject1);
		entityTransaction.commit();
		
		
		
	}
}
