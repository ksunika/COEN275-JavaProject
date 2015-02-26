package com.project.tablemodel;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

import com.project.entity.Faculty;
import com.project.service.AdvisorProjectService;

/**
*
* @author ksusha
*/
public class FacultyTableModel extends AbstractTableModel {

	  List<Faculty> facultyResultList;   // stores the model data in a List collection of type CourseList
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private Faculty faculty;			    // represents the entity Partner
	  private AdvisorProjectService facultyService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	    public FacultyTableModel(String projectId) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    faculty = new Faculty();
	    facultyService = new AdvisorProjectService(manager);
	    
	    facultyResultList = facultyService.readFaculty(projectId);
	    
	    
	    // update the number of rows and columns in the model
	    numrows = facultyResultList.size();
	    numcols = faculty.getNumberOfColumns();
      }
	    
	    public FacultyTableModel() {
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    manager = factory.createEntityManager();
		    faculty = new Faculty();
		    facultyService = new AdvisorProjectService(manager);
		    
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
		  return facultyResultList.get(row).getColumnData(col);
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
				return faculty.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	
	 public List<Faculty> getList() {
		 return facultyResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public FacultyTableModel(List<Faculty> list, EntityManager em)  {
	    facultyResultList = list;
	    numrows = facultyResultList.size();
	    faculty = new Faculty();
	   	numcols = faculty.getNumberOfColumns();     
		manager = em;  
		facultyService = new AdvisorProjectService(manager);
	 }

	public void addAdvisor(String projectId, ArrayList<String> listAdvisorId,
			ArrayList<String> listAdvisorName) {
		facultyService.addStudent(projectId,listAdvisorId,listAdvisorName);
		
	}
	 	
}
