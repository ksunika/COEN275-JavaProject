package com.project.tablemodel;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

import com.project.entity.Media;
import com.project.service.MediaService;

/**
*
* @author ksusha
*/
public class MediaTableModel extends AbstractTableModel {

	  List<Media> mediaResultList;   // stores the model data in a List collection of type CourseList
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private Media media;			    // represents the entity Partner
	  private MediaService mediaService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	    public MediaTableModel(String projectId) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    media = new Media();
	    mediaService = new MediaService(manager);
	    
	    mediaResultList = mediaService.readMedia(projectId);
	    
	    
	    // update the number of rows and columns in the model
	    numrows = mediaResultList.size();
	    numcols = Media.getNumberOfColumns();
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
		  return mediaResultList.get(row).getColumnData(col);
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
				return media.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	
	 public List<Media> getList() {
		 return mediaResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public MediaTableModel(List<Media> list, EntityManager em)  {
	    mediaResultList = list;
	    numrows = mediaResultList.size();
	    media = new Media();
	   	numcols = media.getNumberOfColumns();     
		manager = em;  
		mediaService = new MediaService(manager);
	 }

	public void addMedia(String projectId, ArrayList<String> listMediaName,
			ArrayList<String> listMediaPath) {
		// TODO Auto-generated method stub
		mediaService.addMedia(projectId,listMediaName,listMediaPath);
		
	}
	 	
}
