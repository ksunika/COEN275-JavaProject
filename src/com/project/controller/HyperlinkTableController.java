package com.project.controller;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.project.tablemodel.HyperlinkTableModel;
import com.project.views.ProjectDetailsAddForm;
import com.project.views.ProjectDetailsEdit;
import com.project.views.ViewerProjectDetailsForm;

/**
 * Glue between the view (CourseListGUI) and the model (CourseListTableModel).
 * No database specific code here. Contains a reference to both the TableModel
 * and the graphical user interface.
 * 
 * @author ksusha
 */
public class HyperlinkTableController implements ListSelectionListener,
		TableModelListener {
	private HyperlinkTableModel tableModel;
	private ViewerProjectDetailsForm viewerGUI;
	private ProjectDetailsEdit editGUI;
	//private ProjectDetailsAddFormOLD addGUI;
	private ProjectDetailsAddForm addGUI1;
	

	public HyperlinkTableController(ViewerProjectDetailsForm gui, String projectId, String type) {
		
		this.viewerGUI = gui;
		tableModel = new HyperlinkTableModel(projectId, type);
		tableModel.addTableModelListener(this);
				
		
	}


	public HyperlinkTableController(ProjectDetailsEdit gui, String projectId, String type) {
		
		this.editGUI = gui;		
		tableModel = new HyperlinkTableModel(projectId, type);
		tableModel.addTableModelListener(this);
	}
	
//	public HyperlinkTableController(ProjectDetailsAddFormOLD gui, String projectId, String type) {
//		
//		this.addGUI = gui;		
//		tableModel = new HyperlinkTableModel(projectId, type);
//		tableModel.addTableModelListener(this);
//	}


	public HyperlinkTableController(ProjectDetailsAddForm projectDetailsForm,
			String projectId, String type) {
		this.addGUI1 = projectDetailsForm;		
		tableModel = new HyperlinkTableModel(projectId, type);
		tableModel.addTableModelListener(this);
		// TODO Auto-generated constructor stub
	}


	public TableModel getTableModel() {
		return tableModel;
	}

	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();

		

	}

	public void tableChanged(TableModelEvent e) {
		
	}


	public void addRow(String path, String projectId, String type) {
		tableModel.addRow(path, projectId, type);
		tableModel.fireTableDataChanged();
		
	}
	
	public void deleteRow(String path) {
		tableModel.deleteRow(path);
		tableModel.fireTableDataChanged();
		
	}
	

}
