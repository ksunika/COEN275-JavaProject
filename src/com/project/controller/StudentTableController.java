package com.project.controller;

import java.util.ArrayList;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.project.tablemodel.StudentTableModel;
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
public class StudentTableController implements ListSelectionListener,
		TableModelListener {
	private StudentTableModel tableModel;
	private ViewerProjectDetailsForm gui;
	private ProjectDetailsAddForm gui1;
	private ProjectDetailsEdit projectDetailsEdit;
	

	public StudentTableController(ViewerProjectDetailsForm gui, String projectId) {
		this.gui = gui;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new StudentTableModel(projectId);
		tableModel.addTableModelListener(this);
				
		//System.out.println("You can see me4!!!");
		
	}
	
	public StudentTableController(ProjectDetailsAddForm gui, String projectId) {
		this.gui1 = gui;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new StudentTableModel();
		tableModel.addTableModelListener(this);
				
		//System.out.println("You can see me4!!!");
		
	}


	public StudentTableController(ProjectDetailsEdit projectDetailsEdit,
			String projectId) {
		this.projectDetailsEdit = projectDetailsEdit;
		tableModel = new StudentTableModel(projectId);
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

	public void addStudent(String projectId, ArrayList<String> listStudentId, ArrayList<String> listStudentName) {
		// TODO Auto-generated method stub
		tableModel.addStudent(projectId,listStudentId,listStudentName);
	}
}
