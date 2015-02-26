package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.project.entity.Faculty;
import com.project.entity.ProjectDetails;
import com.project.entity.Student;

public class AdvisorProjectService {

	private EntityManager manager;

	public AdvisorProjectService(EntityManager manager) {
		this.manager = manager;
	}

	public List<Faculty> readFaculty(String projectId) {
		
		
		List<Faculty> result = new ArrayList<Faculty>();
		try{
		TypedQuery<ProjectDetails> query1 = manager.createQuery(
				"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
				ProjectDetails.class);
		query1.setParameter("projectId", projectId);
		ProjectDetails result1 = query1.getSingleResult();

		result = result1.getFacultyList();

		return result;
		}
		catch (javax.persistence.NoResultException exp){
			
			System.out.println("No projects found");
			
		}
		return result;
	}

	public void addStudent(String projectId, ArrayList<String> listAdvisorId,
			ArrayList<String> listAdvisorName) {
		try
		{
		EntityTransaction et = manager.getTransaction();
		
		ProjectDetails pd = new ProjectDetails();
		TypedQuery<ProjectDetails> query1 = manager.createQuery(
				"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
				ProjectDetails.class);
		query1.setParameter("projectId", projectId);
		pd = query1.getSingleResult();
		List<Faculty> faculties = new ArrayList<Faculty>();
		Faculty faculty;
		for(int i = 0;i<listAdvisorId.size();i++)
		{
			faculty = new Faculty();
			faculty.setFacultyId(listAdvisorId.get(i));
			faculty.setName(listAdvisorName.get(i));
			faculties.add(faculty);		
		}
		pd.setFacultyList(faculties);
		et.begin();
		manager.persist(pd);
		et.commit();
		}
		catch(Exception e)
		{
			
		}
		
	}



}
