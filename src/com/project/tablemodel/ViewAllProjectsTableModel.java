package com.project.tablemodel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

import com.project.entity.*;
import com.project.service.ViewerProjectService;

@SuppressWarnings("serial")
public class ViewAllProjectsTableModel extends AbstractTableModel{

	List<ProjectDetails> projectList;
	List<Object> AllDetails;
	private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit"; // Used
																			// in
																			// persistence.xml
	private static EntityManagerFactory factory; // JPA
	private EntityManager manager;
	private ProjectDetails projectDetails;
	private ViewerProjectService projectService;

	int numcols, numrows;

	public ViewAllProjectsTableModel() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		
		projectDetails = new ProjectDetails();
		
		projectService = new ViewerProjectService(manager);
		
		projectList =  projectService.readAll();
		numrows = projectList.size();
		numcols =  projectDetails.getNumberOfColumns();
	}
	
	
	
	 // returns a count of the number of rows
	 public int getRowCount() {
		return numrows;
	 }
	
	 // returns a count of the number of columns
	 public int getColumnCount() {
		return numcols;
	 }
	
	 // returns the data at the given row and column number
	 public Object getValueAt(int row, int col) {
		try {
		  return projectList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	 }
	
	 // table cells are not editable
	 public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	 }
	
	 public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
	
	 // returns the name of the column
	 public String getColumnName(int col) {
		   try {
				return projectDetails.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	
	 public List<ProjectDetails> getList() {
		 return projectList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public ViewAllProjectsTableModel(List<ProjectDetails> list, EntityManager em)  {
		 projectList = list;
	    numrows = projectList.size();
	    projectDetails = new ProjectDetails();
	   	numcols = projectDetails.getNumberOfColumns();     
		manager = em;  
		projectService = new ViewerProjectService(manager);
	 }



	public ViewAllProjectsTableModel getProjectWithStatus(String status) {
		// TODO Auto-generated method stub
		projectList =  projectService.readProjectWithStatus(status);
		numrows = projectList.size();
		numcols =  projectDetails.getNumberOfColumns();
		return this;
	}



	public ViewAllProjectsTableModel getProjectWithDate(String startDate) {
		// TODO Auto-generated method stub
		projectList =  projectService.getProjectWithDate(startDate);
		numrows = projectList.size();
		numcols =  projectDetails.getNumberOfColumns();
		return this;
	}



	public ViewAllProjectsTableModel getProjectWithTheme(String theme) {
		// TODO Auto-generated method stub
		projectList =  projectService.getProjectWithTheme(theme);
		numrows = projectList.size();
		numcols =  projectDetails.getNumberOfColumns();
		return this;
	}
	
	public ViewAllProjectsTableModel getProjectWithStudentId(String student_id) {
		projectList =  projectService.getProjectWithStudentId(student_id);
		numrows = projectList.size();
		numcols =  projectDetails.getNumberOfColumns();
		return this;
	}



	public ViewAllProjectsTableModel getProjectWithFacultyId(String faculty_id) {
		// TODO Auto-generated method stub
		projectList =  projectService.getProjectWithFacultyId(faculty_id);
		numrows = projectList.size();
		numcols =  projectDetails.getNumberOfColumns();
		return this;
	}



	public ViewAllProjectsTableModel deleteProject(String project_id) {
		projectList =  projectService.deleteProject(project_id);
		numrows = projectList.size();
		numcols =  projectDetails.getNumberOfColumns();
		return this;
		
	}



	public ViewAllProjectsTableModel getProjectWithScope(String scope) {
		// TODO Auto-generated method stub
		projectList =  projectService.getProjectWithScope(scope);
		numrows = projectList.size();
		numcols =  projectDetails.getNumberOfColumns();
		return this;
	}



	public ViewAllProjectsTableModel getProjectWithPartner(String partner) {
		// TODO Auto-generated method stub
		projectList =  projectService.getProjectWithPartner(partner);
		numrows = projectList.size();
		numcols =  projectDetails.getNumberOfColumns();
		return this;
	}



//	public ViewAllProjectsTableModel getProjectWithId(String student_id) {
//		// TODO Auto-generated method stub
//		AllDetails = projectService.getProjectWithId(student_id);
//		numrows = projectList.size();
//		numcols =  projectDetails.getNumberOfColumns();
//		return this;
//	}
}
