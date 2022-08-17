package com.ty.student.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.student.dto.Course;
import com.ty.student.dto.Student;

public class StudentDao {

	void saveStudent() {
		EntityManagerFactory factory  = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student = new Student();
		student.setName("shan");
		student.setAge(18);
		
		Student student1 = new Student();
		student1.setName("raj");
		student1.setAge(21);
		
		Student student2 = new Student();
		student2.setName("chotu");
		student2.setAge(19);
		
		Course course = new Course();
		course.setName("commerce");
		course.setCost(10000);
		
		List<Student> ls = new ArrayList<Student>();
		ls.add(student);
		ls.add(student1);
		ls.add(student2);
		
		course.setStudent(ls);
		
		entityTransaction.begin();
		entityManager.persist(course);
		entityManager.persist(student);
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityTransaction.commit();
	}
}
