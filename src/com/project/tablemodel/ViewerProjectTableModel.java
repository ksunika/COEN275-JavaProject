package com.project.tablemodel;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

import com.project.entity.Partner;
import com.project.entity.ProjectDetails;
import com.project.service.ViewerProjectService;

/**
*
* @author ksusha
*/
public class ViewerProjectTableModel extends AbstractTableModel {

	  List<ProjectDetails> projectDetailResultList;   // stores the model data in a List collection of type CourseList
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private ProjectDetails projectDetails;			    // represents the entity courselist
	  private ViewerProjectService viewerProjectService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	    public ViewerProjectTableModel(String projectId) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    projectDetails = new ProjectDetails();
	    viewerProjectService = new ViewerProjectService(manager);
	    
	    // read all the records from projectDetail
	   // projectDetailResultList = viewerProjectService.readAll();
	    projectDetailResultList = viewerProjectService.readProject(projectId);
	    
	    
	    // update the number of rows and columns in the model
	    numrows = projectDetailResultList.size();
	    numcols = projectDetails.getNumberOfColumns();
      }
	    public ViewerProjectTableModel() {
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    manager = factory.createEntityManager();
		    projectDetails = new ProjectDetails();
		    viewerProjectService = new ViewerProjectService(manager);
		    		    
		    
		    // update the number of rows and columns in the model
		    projectDetailResultList = viewerProjectService.readAll();
		    numrows = projectDetailResultList.size();
		    numcols = projectDetails.getNumberOfColumns();
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
		  return projectDetailResultList.get(row).getColumnData(col);
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
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {

		try {
		   ProjectDetails element = projectDetailResultList.get(row);
                   element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	
	 public List<ProjectDetails> getList() {
		 return projectDetailResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public ViewerProjectTableModel(List<ProjectDetails> list, EntityManager em)  {
	    projectDetailResultList = list;
	    numrows = projectDetailResultList.size();
	    projectDetails = new ProjectDetails();
	   	numcols = projectDetails.getNumberOfColumns();     
		manager = em;  
		viewerProjectService = new ViewerProjectService(manager);
	 }
	 
	 public void updateRow(Object[] array){
		 
		 	EntityTransaction transaction = manager.getTransaction();
			// start transaction
		 	if(!transaction.isActive())
		 		transaction.begin();   
		   	
			// update the course with the given course number
		   	String id = (String) array[0];
		   	String name = (String) array[1];
		   	String status = (String) array[2];
		   	String theme = (String) array[3];
		   	String scope = (String) array[4];
		   	String startDate = (String) array[5];
		   	String endDate = (String) array[6];
		   	String location = (String) array[7];

			viewerProjectService.updateProject(id, name, status, theme, scope, startDate, endDate, location);
						
			// commit a transaction
			if(transaction.isActive())
			  transaction.commit();
		 
	 }

	public void updateRow(String id, String name, String status, String theme,
			String scope, String startDate, String endDate, String location) {
	 	EntityTransaction transaction = manager.getTransaction();
		// start transaction
	   	transaction.begin();   
	   	
		viewerProjectService.updateProject(id, name, status, theme, scope, startDate, endDate, location);
				
			
		// commit a transaction
		  transaction.commit();
		
	}
	public void addRow(String id, String name, String status, String theme,
			String scope, String startDate, String endDate, String location) {
		EntityTransaction transaction = manager.getTransaction();
	   	transaction.begin();   
	   	
		ProjectDetails newProject = viewerProjectService.createProject(id, name, status, theme, scope, startDate, endDate, location);
				
			
		// commit a transaction
		  transaction.commit();
		  
		
	}
	public void addRow(String projectId) {
		 // add row to database
		EntityTransaction userTransaction = manager.getTransaction();  
		if(!userTransaction.isActive())
			userTransaction.begin();
		ProjectDetails newRecord = ViewerProjectService.createProject(projectId);
		if(userTransaction.isActive())
			userTransaction.commit();
		 
		// set the current row to rowIndex
		projectDetailResultList.add(newRecord);
        int row = projectDetailResultList.size();  
        int col = 0;

         
         numrows++;
		
	}
	public void deleteRow(String projectId) {
		ProjectDetails project = viewerProjectService.findProject(projectId);
		projectDetailResultList.remove(project);
	 	
		EntityTransaction userTransaction = manager.getTransaction(); 
		if(!userTransaction.isActive())
			userTransaction.begin();
		viewerProjectService.deleteProject(projectId);
		if(userTransaction.isActive())
			userTransaction.commit();

		numrows--;
		
	}
	

	 
	
}
