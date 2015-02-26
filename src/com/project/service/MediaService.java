package com.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.project.entity.Media;
import com.project.entity.ProjectDetails;
import com.project.entity.Student;

public class MediaService {

	private EntityManager manager;

	public MediaService(EntityManager manager) {
		this.manager = manager;
	}

	public List<Media> readMedia(String projectId) {

		List<Media> result = new ArrayList<Media>();
		try {

			TypedQuery<ProjectDetails> query1 = manager
					.createQuery(
							"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
							ProjectDetails.class);
			query1.setParameter("projectId", projectId);
			ProjectDetails result1 = query1.getSingleResult();

			result = result1.getMediaList();

			// System.out.println(result);
			return result;
		} catch (javax.persistence.NoResultException exp) {

			System.out.println("No projects found");

		}
		return result;
	}

	public void addMedia(String projectId, ArrayList<String> listMediaName,

	ArrayList<String> listMediaPath) {

		List<Media> mediaList = new ArrayList<Media>();

		EntityTransaction et = manager.getTransaction();

		ProjectDetails pd = new ProjectDetails();

		TypedQuery<ProjectDetails> query1 = manager.createQuery(

		"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",

		ProjectDetails.class);

		query1.setParameter("projectId", projectId);

		pd = query1.getSingleResult();

		Media media;

		for (int i = 0; i < listMediaName.size(); i++)

		{

			media = new Media();

			media.setPath(listMediaPath.get(i));

			media.setName(listMediaName.get(i));

			mediaList.add(media);

			media.setProjectId(pd);

		}

		pd.setMediaList(mediaList);

		if(!et.isActive())
		et.begin();

		manager.persist(pd);
		
		if(et.isActive())
		et.commit();

	}

}
