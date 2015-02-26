package com.project.service;

import javax.persistence.EntityManager;

import com.project.entity.Faculty;

public class AdvisorServices {

	private EntityManager manager;
	
	public AdvisorServices(EntityManager manager) {
		this.manager = manager;
	}
	
	//method to read a record
	public Faculty readStudent(String facultyId){
		Faculty validFaculty = manager.find(Faculty.class, facultyId);
		return validFaculty;
	}
}
