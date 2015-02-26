package com.project.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.project.entity.ProjectDetails;
import com.project.service.PartnerService;
import com.project.tablemodel.PartnerTableModel;
import com.project.views.ProjectDetailsEdit;
import com.project.views.ProjectDetailsAddForm;
import com.project.views.ViewerProjectDetailsForm;

/**
 * Glue between the view (CourseListGUI) and the model (CourseListTableModel).
 * No database specific code here. Contains a reference to both the TableModel
 * and the graphical user interface.
 * 
 * @author ksusha
 */
public class PartnerTableController implements ListSelectionListener,
		TableModelListener {
	private PartnerTableModel tableModel;
	private ViewerProjectDetailsForm gui;
	private ProjectDetailsEdit gui2;
	
	String PERSISTENCE_UNIT_NAME = "PersistenceUnit";
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager manager = factory.createEntityManager();
	PartnerService partnerService = new PartnerService(manager);
	EntityTransaction transaction = manager.getTransaction();
	private ProjectDetailsAddForm addForm;

	public PartnerTableController(ViewerProjectDetailsForm gui, String projectId) {
		this.gui = gui;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new PartnerTableModel(projectId);
		tableModel.addTableModelListener(this);
				
		System.out.println("Partner table controller!!!");
		
	}


	public PartnerTableController(
			ProjectDetailsEdit projectDetailsEditForm, String projectId) {
		this.gui2 = gui2;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new PartnerTableModel(projectId);
		tableModel.addTableModelListener(this);
	}


	public PartnerTableController(ProjectDetailsAddForm projectDetailsForm,
			String projectId) {
		// TODO Auto-generated constructor stub
		this.addForm = projectDetailsForm;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new PartnerTableModel(projectId);
		tableModel.addTableModelListener(this);
	}


	public TableModel getTableModel() {
		return tableModel;
	}

	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		//int firstIndex = selectModel.getMinSelectionIndex();
		

	}

	public void tableChanged(TableModelEvent e) {
		
	}


	public void addRow(String id, String name, String projectId) {
		tableModel.addRow(id,  name,  projectId);
		tableModel.fireTableDataChanged();
		
	}
	public void deleteRow(String id) {
		tableModel.deleteRow(id);
		tableModel.fireTableDataChanged();
		
	}


	public void addPartner(String projectId, ArrayList<String> listPartnerName) {
		// TODO Auto-generated method stub
		tableModel.addPartner(projectId,listPartnerName);
		
	}
}
