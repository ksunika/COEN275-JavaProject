package com.project.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.project.entity.Faculty;
import com.project.entity.Hyperlink;
import com.project.entity.Partner;
import com.project.entity.ProjectDetails;

public class PartnerService {

	private EntityManager manager;

	public PartnerService(EntityManager manager) {
		this.manager = manager;
	}

	public List<Partner> readPartner(String projectId) {

		List<Partner> result = new ArrayList<Partner>();
		try {

			TypedQuery<ProjectDetails> query1 = manager
					.createQuery(
							"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
							ProjectDetails.class);
			query1.setParameter("projectId", projectId);
			ProjectDetails result1 = query1.getSingleResult();

			System.out.println("Project: "+result1);
			
			result = result1.getPartnerList();
			System.out.println("partners: "+result);
			return result;
		} catch (javax.persistence.NoResultException exp) {

			System.out.println("No projects found in partner service read partner");

		}
		return result;
	}
	
	public Partner findPartner(String partnerId) {

		Partner result = new Partner();
		try {

			TypedQuery<Partner> query1 = manager
					.createQuery(
							"SELECT p FROM Partner p WHERE p.partnerId = :partnerId",
							Partner.class);
			query1.setParameter("partnerId", partnerId);
			result = query1.getSingleResult();


		} catch (javax.persistence.NoResultException exp) {

			System.out.println("No partners found in partner service find partner");

		}
		return result;
	}

	public Partner createPartner(String id, String name, String projectId) {
		ProjectDetails project = null;
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

		Partner partner = new Partner();
//		partner.setPartnerId(id);
		partner.setPartnerName(name);
		partner.setProjectId(project);

		System.out.println(partner.getPartnerName()+" "+partner.getProjectId());
		
		manager.persist(partner);

		return partner;

	}

	public void deletePartner(String id) {
		Partner partner = manager.find(Partner.class, id);
   	 if (id != null) {
   	        manager.remove(partner);
   	 }

	}

	public void addPartner(String projectId, ArrayList<String> listPartnerName) {
		try
		{
		List<Partner> partnerList = new ArrayList<Partner>();
			EntityTransaction et = manager.getTransaction();
					
					ProjectDetails pd = new ProjectDetails();
					TypedQuery<ProjectDetails> query1 = manager.createQuery(
							"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
							ProjectDetails.class);
					//System.out.println("Project ID:"+projectId);
					query1.setParameter("projectId", projectId);
					pd = query1.getSingleResult();
					
					Partner partner;
					for(int i = 0;i<listPartnerName.size();i++)
					{
						partner = new Partner();
						partner.setPartnerName(listPartnerName.get(i));
						partnerList.add(partner);
						partner.setProjectId(pd);
					}
					pd.setPartnerList(partnerList);
					et.begin();
					manager.persist(pd);
					et.commit();
		}
		catch(Exception e)
		{
			
		}
					
		
	}
	
	/*public void addPartners(String projectId,ArrayList<String> listPartnerName){
		List<Partner> partnerList = new ArrayList<Partner>();
		try {
			TypedQuery<ProjectDetails> query1 = manager
					.createQuery(
							"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
							ProjectDetails.class);
			query1.setParameter("projectId", projectId);
			ProjectDetails result1 = query1.getSingleResult();
			Partner partner;

			partnerList = result1.getPartnerList();
			for(int i = 0;i<listPartnerName.size();i++)
			{
				partner = new Partner();
				partner.setPartnerName(listPartnerName.get(i));
				partnerList.add(partner);		
			}
			result1.setPartnerList(partnerList);
			et.begin();
			manager.persist(result1);
			et.commit();
			//return partnerList;
		} catch (javax.persistence.NoResultException exp) {

			System.out.println("No projects found");

		}
	}*/

}
