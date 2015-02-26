package com.project.service;

import javax.persistence.EntityManager;

import com.project.entity.Student;

/**
 * Contains all the CRUD methods ; requires entity manager to do it
 * @author gyanpatra
 *
 */
public class StudentServices {

	private EntityManager manager;
	
	public StudentServices(EntityManager manager) {
		this.manager = manager;
	}
	
	//method to read a record
	public Student readStudent(String studentId){
		System.out.println("Method To Read REcord");
		Student validStudent = null;
		try {
			 validStudent = manager.find(Student.class, studentId);
		} catch (NullPointerException e) {
			System.out.println("No valid Student");
		}
		
		//System.out.println(validStudent);
		return validStudent;
	}
}
