package com.project.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.project.entity.Hyperlink;
import com.project.entity.Hyperlinktype;
import com.project.entity.Partner;
import com.project.entity.ProjectDetails;

public class HyperlinkService {

	private EntityManager manager;

	public HyperlinkService(EntityManager manager) {
		this.manager = manager;
	}

	public List<Hyperlink> readHyperlink(String projectId, String type) {
		List<Hyperlink> result = new ArrayList<Hyperlink>();
		try {

			TypedQuery<ProjectDetails> query1 = manager
					.createQuery(
							"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
							ProjectDetails.class);
			query1.setParameter("projectId", projectId);
			ProjectDetails result1 = query1.getSingleResult();

			result = result1.getHyperlinkList();
			for (Iterator<Hyperlink> itr = result.iterator(); itr.hasNext();) {
				Hyperlink element = itr.next();
				if (!element.getId().getType().equals(type)) // "direct"
				{
					itr.remove();
				}
			}
			return result;
		} catch (javax.persistence.NoResultException exp) {

			System.out.println("No projects found");

		}
		return result;
	}

	public Hyperlink findHyperlink(String hyperlink) {
		Hyperlink result = new Hyperlink();
		try {

			TypedQuery<Hyperlink> query1 = manager.createQuery(
					"SELECT p FROM Hyperlink p WHERE p.hyperlink = :hyperlink",
					Hyperlink.class);
			query1.setParameter("hyperlink", hyperlink);
			result = query1.getSingleResult();

			return result;
		} catch (javax.persistence.NoResultException exp) {

			System.out.println("No projects found");

		}
		return result;
	}

	public Hyperlink createHyperlink(String path, String projectId, String type) {
		ProjectDetails project = null;
		Hyperlinktype hyperlinktype = null;
		try {

			TypedQuery<ProjectDetails> query1 = manager
					.createQuery(
							"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
							ProjectDetails.class);
			query1.setParameter("projectId", projectId);
			project = query1.getSingleResult();
		} catch (javax.persistence.NoResultException exp) {

			System.out.println("No result found in partner service");

		}
		try {

			TypedQuery<Hyperlinktype> query2 = manager.createQuery(
					"SELECT p FROM Hyperlinktype p WHERE p.type = :type",
					Hyperlinktype.class);
			query2.setParameter("type", type);
			hyperlinktype = query2.getSingleResult();
		} catch (javax.persistence.NoResultException exp) {

			System.out.println("No result found in partner service");

		}

		Hyperlink hyperlink = new Hyperlink();

		hyperlink.setHyperlink(path);
		hyperlink.setProjectId(project);
		hyperlink.setId(hyperlinktype);
		List<Hyperlink> hyperlinksold = project.getHyperlinkList();
		if(hyperlinksold!=null)
		{
			hyperlinksold.add(hyperlink);
		}
		else
		{
			hyperlinksold = new ArrayList<Hyperlink>();
			hyperlinksold.add(hyperlink);
		}
		EntityTransaction et = manager.getTransaction();
		if(!et.isActive())
			et.begin();
		project.setHyperlinkList(hyperlinksold);
		manager.persist(hyperlink);
		
		if(et.isActive())
			et.commit();
		

		return hyperlink;
	}

	public void deleteHyperlink(String path) {
		Hyperlink hyperlink = manager.find(Hyperlink.class, path);
		if (path != null) {
			manager.remove(hyperlink);
		}

	}

}
