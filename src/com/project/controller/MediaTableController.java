package com.project.controller;

import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.project.tablemodel.MediaTableModel;
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
public class MediaTableController implements ListSelectionListener,
		TableModelListener {
	private MediaTableModel tableModel;
	private ViewerProjectDetailsForm gui;
	private ProjectDetailsAddForm gui1;
	 private ProjectDetailsEdit projectDetailsEdit;

	public MediaTableController(ViewerProjectDetailsForm gui, String projectId) {
		this.gui = gui;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new MediaTableModel(projectId);
		tableModel.addTableModelListener(this);
				
		//System.out.println("You can see me6!!!");
		
	}

	public MediaTableController(ProjectDetailsEdit projectDetailsEdit,

			String projectId) {

			this.projectDetailsEdit = projectDetailsEdit;

			// create the tableModel using the data in the cachedRowSet

			tableModel = new MediaTableModel(projectId);

			tableModel.addTableModelListener(this);
	}



	public MediaTableController(ProjectDetailsAddForm projectDetailsForm,
			String projectId) {
		this.gui1 = projectDetailsForm;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new MediaTableModel(projectId);
		tableModel.addTableModelListener(this);
		// TODO Auto-generated constructor stub
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


	public void addMedia(String projectId, ArrayList<String> listMediaName,
			ArrayList<String> listMediaPath) {
		tableModel.addMedia(projectId,listMediaName,listMediaPath);
		
	}
}
