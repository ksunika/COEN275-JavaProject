package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.project.entity.ProjectDetails;
import com.project.entity.Student;

public class StudentProjectService {

	private EntityManager manager;

	public StudentProjectService(EntityManager manager) {
		this.manager = manager;
	}

	public List<Student> readStudent(String projectId) {
		
		
		List<Student> result = new ArrayList<Student>();
		try{
		TypedQuery<ProjectDetails> query1 = manager.createQuery(
				"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
				ProjectDetails.class);
		query1.setParameter("projectId", projectId);
		ProjectDetails result1 = query1.getSingleResult();
	
		result = result1.getStudentList();

		return result;
		}
		catch (javax.persistence.NoResultException exp){
			
			System.out.println("No projects found");
			
		}
		return result;
	}

	public void addStudent(String projectId, ArrayList<String> listStudentId, ArrayList<String> listStudentName) {
		// TODO Auto-generated method stub
		try
		{
		EntityTransaction et = manager.getTransaction();
		
		ProjectDetails pd = new ProjectDetails();
		TypedQuery<ProjectDetails> query1 = manager.createQuery(
				"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
				ProjectDetails.class);
		query1.setParameter("projectId", projectId);
		pd = query1.getSingleResult();
		List<Student> students = new ArrayList<Student>();
		Student student;
		for(int i = 0;i<listStudentId.size();i++)
		{
			student = new Student();
			student.setStudentId(listStudentId.get(i));
			student.setName(listStudentName.get(i));
			students.add(student);		
		}
		pd.setStudentList(students);
		et.begin();
		manager.persist(pd);
		et.commit();
		}
		catch(Exception e)
		{
			
		}
	}



}
