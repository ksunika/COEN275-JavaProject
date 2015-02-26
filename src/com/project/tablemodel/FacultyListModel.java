package com.project.tablemodel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.project.entity.Faculty;
import com.project.entity.Student;
import com.project.service.AdvisorServices;
import com.project.service.StudentServices;

public class FacultyListModel {

	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;
	  private Faculty advisor;
	  private AdvisorServices advisorsServices;
	  
	  
	  public FacultyListModel() {
		  factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		  manager = factory.createEntityManager();
		 // students = new Student();
		 // studentsServices = new StudentServices(manager);
	}
	  
	  

	public Faculty getValidAdvisor(String adviserId) {
		 advisor = new Faculty();
		  advisorsServices = new AdvisorServices(manager);
		  advisor = advisorsServices.readStudent(adviserId); 
		  return advisor;
	}
	
}
