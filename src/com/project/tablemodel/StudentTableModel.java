package com.project.tablemodel;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

import com.project.entity.Student;
import com.project.service.StudentProjectService;

/**
*
* @author ksusha
*/
public class StudentTableModel extends AbstractTableModel {

	  List<Student> studentResultList;   // stores the model data in a List collection of type CourseList
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private Student student;			    // represents the entity Partner
	  private StudentProjectService studentService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	    public StudentTableModel(String projectId) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    student = new Student();
	    studentService = new StudentProjectService(manager);
	    
	    studentResultList = studentService.readStudent(projectId);
	    
	    
	    // update the number of rows and columns in the model
	    numrows = studentResultList.size();
	    numcols = student.getNumberOfColumns();
      }
	    
	    public StudentTableModel() {
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    manager = factory.createEntityManager();
		    studentService = new StudentProjectService(manager);
		    student = new Student();
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
		  return studentResultList.get(row).getColumnData(col);
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
				return student.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	
	 public List<Student> getList() {
		 return studentResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public StudentTableModel(List<Student> list, EntityManager em)  {
		studentResultList = list;
	    numrows = studentResultList.size();
	    student = new Student();
	   	numcols = student.getNumberOfColumns();     
		manager = em;  
		studentService = new StudentProjectService(manager);
	 }

	public void addStudent(String projectId, ArrayList<String> listStudentId, ArrayList<String> listStudentName) {
		// TODO Auto-generated method stub
		studentService.addStudent(projectId,listStudentId,listStudentName);
		 
	}
	 	
}
