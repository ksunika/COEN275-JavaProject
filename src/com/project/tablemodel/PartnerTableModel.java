package com.project.tablemodel;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

import com.project.entity.Partner;
import com.project.service.PartnerService;

/**
*
* @author ksusha
*/
public class PartnerTableModel extends AbstractTableModel {

	  List<Partner> partnerResultList;   // stores the model data in a List collection 
	  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;				// JPA 
	  private Partner partner;			    // represents the entity Partner
	  private PartnerService partnerService;
	
	   // This field contains additional information about the results   
	    int numcols, numrows;           // number of rows and columns

	    public PartnerTableModel(String projectId) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    partner = new Partner();
	    partnerService = new PartnerService(manager);
	    
	    partnerResultList = partnerService.readPartner(projectId);
	    
	    
	    // update the number of rows and columns in the model
	    numrows = partnerResultList.size();
	    numcols = partner.getNumberOfColumns();
      }

	    public PartnerTableModel() {
		    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		    manager = factory.createEntityManager();
		    partner = new Partner();
		    partnerService = new PartnerService(manager);
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
		  return partnerResultList.get(row).getColumnData(col);
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
				return partner.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	
	 public List<Partner> getList() {
		 return partnerResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public PartnerTableModel(List<Partner> list, EntityManager em)  {
	    partnerResultList = list;
	    numrows = partnerResultList.size();
	    partner = new Partner();
	   	numcols = partner.getNumberOfColumns();     
		manager = em;  
		partnerService = new PartnerService(manager);
	 }
	 
	 public void addRow(String id, String name, String projectId) {
		
			
	    // add row to database
		EntityTransaction userTransaction = manager.getTransaction();  
		userTransaction.begin();
		Partner newRecord = partnerService.createPartner(id, name, projectId);
		userTransaction.commit();
		 
		// set the current row to rowIndex
        partnerResultList.add(newRecord);
        int row = partnerResultList.size();  
        int col = 0;

         
         numrows++;
	}	
	 
	 public void deleteRow(Object id) {
		 
		 	Partner partner = partnerService.findPartner((String)id);
		 	partnerResultList.remove(partner);
		 	
			EntityTransaction userTransaction = manager.getTransaction();  
			userTransaction.begin();
			partnerService.deletePartner((String) id);
			userTransaction.commit();

			numrows--;

		}

	public void addPartner(String projectId, ArrayList<String> listPartnerName) {
		// TODO Auto-generated method stub
		//partnerService.createPartner(id, name, projectId)
		partnerService.addPartner(projectId,listPartnerName);
		
	}

	 	
}
