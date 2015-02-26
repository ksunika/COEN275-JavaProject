package com.project.controller;

import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.project.tablemodel.FacultyTableModel;
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
public class FacultyTableController implements ListSelectionListener,
		TableModelListener {
	private FacultyTableModel tableModel;
	private ViewerProjectDetailsForm gui;
	private ProjectDetailsAddForm guiForm;
	ProjectDetailsEdit projectDetailsEdit;

	public FacultyTableController(ViewerProjectDetailsForm gui, String projectId) {
		this.gui = gui;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new FacultyTableModel(projectId);
		tableModel.addTableModelListener(this);
				
		//System.out.println("You can see me2!!!");
		
	}


	public FacultyTableController(ProjectDetailsAddForm ProjectDetailsAddForm,
			String projectId) {
		// TODO Auto-generated constructor stub
		this.guiForm = ProjectDetailsAddForm;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new FacultyTableModel(projectId);
		tableModel.addTableModelListener(this);
	}


	public FacultyTableController(ProjectDetailsEdit projectDetailsEdit,
			String projectId) {
		this.projectDetailsEdit = projectDetailsEdit;
		tableModel = new FacultyTableModel(projectId);
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


	public void addFaculty(String projectId, ArrayList<String> listAdvisorId,
			ArrayList<String> listAdvisorName) {
		// TODO Auto-generated method stub
		tableModel.addAdvisor(projectId,listAdvisorId,listAdvisorName);
		
	}
}
