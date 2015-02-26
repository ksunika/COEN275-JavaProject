package com.project.controller;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableModel;

import com.project.tablemodel.ViewAllProjectsTableModel;
import com.project.views.AdminViewGui;
import com.project.views.ViewerGUI;

public class ViewAllProjectsController implements ListSelectionListener,
		RowSetListener {

	javax.swing.JFrame gui;
	ViewAllProjectsTableModel tableModel;

	// proj_StudentTableModel tableModel2;

	public ViewAllProjectsController(ViewerGUI viewerGUI) {
		// TODO Auto-generated constructor stub
		gui = viewerGUI;
		tableModel = new ViewAllProjectsTableModel();

	}

	public ViewAllProjectsController(AdminViewGui adminGUI) {
		gui = adminGUI;
		tableModel = new ViewAllProjectsTableModel();
	}

	public TableModel getTableModel() {
		return tableModel;
	}

	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
		if (gui instanceof ViewerGUI) {

			((ViewerGUI) gui).setProject_id((String) tableModel.getValueAt(
					firstIndex, 0));
		} else if (gui instanceof AdminViewGui)
			((AdminViewGui) gui).setProject_id((String) tableModel.getValueAt(
					firstIndex, 0));

		// System.out.println(gui.getProject_id());
	}

	public void tableChanged(TableModelEvent e) {

	}

	@Override
	public void cursorMoved(RowSetEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rowChanged(RowSetEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void rowSetChanged(RowSetEvent arg0) {
		// TODO Auto-generated method stub

	}

	public TableModel getProjectWithStatus(String status) {
		tableModel = tableModel.getProjectWithStatus(status);
		return tableModel;
	}

	public TableModel getProjectWithDate(String startDate) {
		// TODO Auto-generated method stub
		tableModel = tableModel.getProjectWithDate(startDate);
		return tableModel;
	}

	public TableModel getProjectWithTheme(String theme) {
		// TODO Auto-generated method stub
		tableModel = tableModel.getProjectWithTheme(theme);
		return tableModel;
	}

	public TableModel getProjectWithStudentId(String student_id) {
		// TODO Auto-generated method stub
		tableModel = tableModel.getProjectWithStudentId(student_id);
		return tableModel;
	}

	public TableModel getProjectsWithId(String student_id) {
		// TODO Auto-generated method stub
		tableModel = tableModel.getProjectWithStudentId(student_id);
		return tableModel;
	}

	public TableModel getProjectWithFacultyId(String faculty_id) {
		// TODO Auto-generated method stub
		tableModel = tableModel.getProjectWithFacultyId(faculty_id);
		return tableModel;
	}

	public TableModel deleteProject(String project_id) {
		// TODO Auto-generated method stub
		
		tableModel = tableModel.deleteProject(project_id);
		return tableModel;
	}

	public TableModel getProjectWithScope(String scope) {
		// TODO Auto-generated method stub
		tableModel = tableModel.getProjectWithScope(scope);
		return tableModel;
	}

	public TableModel getProjectWithPartner(String partner) {
		// TODO Auto-generated method stub
		tableModel = tableModel.getProjectWithPartner(partner);
		return tableModel;
	}

	// public TableModel getProjectWithId(String student_id) {
	// // TODO Auto-generated method stub
	// tableModel2 = new proj_StudentTableModel(student_id);
	// return tableModel2;
	// }
}
