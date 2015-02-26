package com.project.tablemodel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.project.entity.Student;
import com.project.service.AdvisorServices;
import com.project.service.StudentServices;


public class StudentListModel {

	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;
	  private Student student;
	  private StudentServices studentsServices;
	  
	  
	  public StudentListModel() {
		  factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		  manager = factory.createEntityManager();
		 // students = new Student();
		 // studentsServices = new StudentServices(manager);
	}
	  
	  public Student getValidStudent(String studentId){
		  student = new Student();
		  studentsServices = new StudentServices(manager);
		  student = studentsServices.readStudent(studentId); 
		  return student;
	  }
	
}
