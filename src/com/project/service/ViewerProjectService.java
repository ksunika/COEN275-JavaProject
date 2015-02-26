package com.project.service;

import javax.persistence.*;

import com.project.entity.Faculty;
import com.project.entity.Hyperlink;
import com.project.entity.Media;
import com.project.entity.Partner;
import com.project.entity.ProjectDetails;
import com.project.entity.Student;

import java.util.*;

public class ViewerProjectService {

	private static EntityManager manager;

	public ViewerProjectService(EntityManager manager) {
		this.manager = manager;
	}

	
	//Updated
		public List<ProjectDetails> readProject(String projectId) {
			List<ProjectDetails> result = new ArrayList<ProjectDetails>();
			try {
				TypedQuery<ProjectDetails> query = manager
						.createQuery(
								"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
								ProjectDetails.class);
				query.setParameter("projectId", projectId);
				result = query.getResultList();
			} catch (javax.persistence.NoResultException exp) {
				System.out.println("Student serv : No projects are found ");
			}
			return result;
		}
	
	
		// Updated by priya
		// method to read all records
		public List<ProjectDetails> readAll() {
			List<ProjectDetails> result = new ArrayList<ProjectDetails>();
			try {
				TypedQuery<ProjectDetails> query = manager.createQuery(
						"SELECT e FROM ProjectDetails e", ProjectDetails.class);
				result = query.getResultList();
			} catch (javax.persistence.NoResultException exp) {
				System.out.println("Student serv : No projects are found ");
			}
			return result;
		}
	

	// method to update a record
	public ProjectDetails updateProject(String id, String name, String status,
			String theme, String scope, String startDate, String endDate,
			String location) {
		ProjectDetails project = manager.find(ProjectDetails.class, id);
		if (project != null) {
			project.setProjectName(name);
			project.setStatus(status);
			project.setTheme(theme);
			project.setScope(scope);
			project.setLocation(location);
			project.setStartDate(startDate);
			project.setEndDate(endDate);
		}
		return project;
	}

	public ProjectDetails createProject(String id, String name, String status,
			String theme, String scope, String startDate, String endDate,
			String location) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ProjectDetails createProject(String projectId) {
		ProjectDetails project = new ProjectDetails();
		project.setProjectId(projectId);
		project.setProjectName("");
		project.setStartDate("");
		project.setStatus("Active");

		manager.persist(project);

		return project;
	}

	public ProjectDetails findProject(String projectId) {
		ProjectDetails result = new ProjectDetails();
		try {

			TypedQuery<ProjectDetails> query1 = manager
					.createQuery(
							"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
							ProjectDetails.class);
			query1.setParameter("projectId", projectId);
			result = query1.getSingleResult();

		} catch (javax.persistence.NoResultException exp) {

			System.out
					.println("No project found in project service find partner");

		}
		return result;
	}

	
	
	// Priya
		public List<ProjectDetails> readProjectWithStatus(String status) {
			// TODO Auto-generated method stub
			List<ProjectDetails> result = new ArrayList<ProjectDetails>();
			try {
				TypedQuery<ProjectDetails> query = manager.createQuery(
						"SELECT e FROM ProjectDetails e where e.status='" + status
								+ "'", ProjectDetails.class);
				result = query.getResultList();
			} catch (javax.persistence.NoResultException exp) {
				System.out.println("Student serv : No projects are found ");
			}
			return result;
		}

		// Priya
		public List<ProjectDetails> getProjectWithDate(String startDate) {
			// TODO Auto-generated method stub
			List<ProjectDetails> result = new ArrayList<ProjectDetails>();
			try {
				TypedQuery<ProjectDetails> query = manager.createQuery(
						"SELECT e FROM ProjectDetails e where e.startDate='"
								+ startDate + "'", ProjectDetails.class);
				result = query.getResultList();
			} catch (javax.persistence.NoResultException exp) {
				System.out.println("Student serv : No projects are found ");
			}
			return result;
		}

		// Priya
		public List<ProjectDetails> getProjectWithTheme(String theme) {
			// TODO Auto-generated method stub
			List<ProjectDetails> result = new ArrayList<ProjectDetails>();
			try {
				TypedQuery<ProjectDetails> query = manager.createQuery(
						"SELECT e FROM ProjectDetails e where e.theme='" + theme
								+ "'", ProjectDetails.class);
				result = query.getResultList();
			} catch (javax.persistence.NoResultException exp) {
				System.out.println("Student serv : No projects are found ");
			}
			return result;
		}

		// Priya
		public List<ProjectDetails> getProjectWithStudentId(String student_id) {

			List<ProjectDetails> result = new ArrayList<ProjectDetails>();
			try {
				TypedQuery<Student> query1 = manager.createQuery(
						"SELECT s FROM Student s WHERE s.studentId = '"
								+ student_id + "'",

						Student.class);

				Student result1 = query1.getSingleResult();

				result = result1.getProjectDetailsList();

			} catch (javax.persistence.NoResultException exp) {
				System.out.println("Student serv : No projects are found ");
			}

			return result;
		}

		// Priya
		public List<ProjectDetails> getProjectWithFacultyId(String faculty_id) {
			// TODO Auto-generated method stub
			List<ProjectDetails> result = new ArrayList<ProjectDetails>();
			try {
				TypedQuery<Faculty> query1 = manager.createQuery(
						"SELECT f FROM Faculty f WHERE f.facultyId = '"
								+ faculty_id + "'",

						Faculty.class);

				Faculty result1 = query1.getSingleResult();

				result = result1.getProjectDetailsList();

			} catch (javax.persistence.NoResultException exp) {
				System.out.println("Student serv : No projects are found ");
			}

			return result;
		}

		// Priya
		public List<ProjectDetails> deleteProject(String project_id) {
			List<ProjectDetails> result = new ArrayList<ProjectDetails>();
			try {
				TypedQuery<ProjectDetails> query1 = manager
						.createQuery(
								"SELECT p FROM ProjectDetails p WHERE p.projectId = :projectId",
								ProjectDetails.class);
				query1.setParameter("projectId", project_id);
				ProjectDetails result1 = query1.getSingleResult();
				
				deletePartners(result1);
				deleteHyperLinks(result1);
				deleteMedia(result1);
				EntityTransaction et = manager.getTransaction();
				if(!et.isActive())
				{
				
					et.begin();
				}
				manager.createQuery(
						"DELETE FROM ProjectDetails WHERE projectId ='"
								+ project_id + "'").executeUpdate();
				if(et.isActive())
					et.commit();

				TypedQuery<ProjectDetails> query = manager.createQuery(
						"SELECT p FROM ProjectDetails p", ProjectDetails.class);

				result = query.getResultList();
			} catch (javax.persistence.NoResultException exp) {
				System.out.println("Project serv : No projects are found ");
				
			}
			return result;
		}

		private void deleteMedia(ProjectDetails result1) {
			List<Media> result = new ArrayList<Media>();
			try {
				result = result1.getMediaList();
				if(result==null)
					return;
				EntityTransaction et = manager.getTransaction();
				if(!et.isActive())
				{
					
					et.begin();
				}
				for (Media media : result) {
					manager.createQuery(
							"DELETE FROM Media WHERE path ='"
									+ media.getPath() + "'")
							.executeUpdate();
				}
				if(et.isActive())
					et.commit();
			} catch (javax.persistence.NoResultException exp) {
				System.out.println("No Media are found");
			}
			
		}

		private void deleteHyperLinks(ProjectDetails result1) {
			List<Hyperlink> result = new ArrayList<Hyperlink>();
			try {
				result = result1.getHyperlinkList();
				if(result==null)
					return;
				EntityTransaction et = manager.getTransaction();
				if(!et.isActive())
				{
					et.begin();
				}
				for (Hyperlink hp : result) {
					manager.createQuery(
							"DELETE FROM Hyperlink WHERE hyperlink ='"
									+ hp.getHyperlink() + "'")
							.executeUpdate();
				}
				if(et.isActive())
					et.commit();
			} catch (javax.persistence.NoResultException exp) {
				System.out.println("No hyperlink are found");
			}
			
		}

		// Priya
		private void deletePartners(ProjectDetails result1) {
			List<Partner> result = new ArrayList<Partner>();
			try {
				result = result1.getPartnerList();
				if(result==null)
					return;
				EntityTransaction et = manager.getTransaction();
				if(!et.isActive())
					et.begin();
				for (Partner partner : result) {
					manager.createQuery(
							"DELETE FROM Partner WHERE partnerName ='"
									+ partner.getPartnerName() + "'")
							.executeUpdate();
				}
				et.commit();
			} catch (javax.persistence.NoResultException exp) {
				System.out.println("No partners are found");
			}

		}

		// Priya
		public List<ProjectDetails> getProjectWithScope(String scope) {
			// TODO Auto-generated method stub
			List<ProjectDetails> result = new ArrayList<ProjectDetails>();
			
			try {
				TypedQuery<ProjectDetails> query = manager.createQuery(
						"SELECT e FROM ProjectDetails e where e.scope='" + scope
								+ "'", ProjectDetails.class);
				result = query.getResultList();
				
			} catch (javax.persistence.NoResultException exp) {
				System.out.println("Project serv : No projects are found ");
			}
			return result;
		}

		// Priya
		public List<ProjectDetails> getProjectWithPartner(String partner) {
			// TODO Auto-generated method stub
			List<ProjectDetails> result = new ArrayList<ProjectDetails>();
			try {
				TypedQuery<Partner> query1 = manager.createQuery(
						"SELECT p FROM Partner p WHERE p.partnerName = '" + partner
								+ "'", Partner.class);

				Partner partner1 = query1.getSingleResult();
				ProjectDetails pd = partner1.getProjectId();
				String projectId = pd.getProjectId();

				TypedQuery<ProjectDetails> query = manager.createQuery(
						"SELECT p FROM ProjectDetails p where p.projectId='"
								+ projectId + "'", ProjectDetails.class);

				result = query.getResultList();

			} catch (javax.persistence.NoResultException exp) {
				System.out.println("Student serv : No projects are found ");
			}

			return result;
		}


}
