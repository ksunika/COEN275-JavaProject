package com.project.controller;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.project.tablemodel.ViewerProjectTableModel;
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
public class ViewerProjectTableController implements ListSelectionListener,
		TableModelListener {
	private ViewerProjectTableModel tableModel;
	private ViewerProjectDetailsForm gui;
	private ProjectDetailsEdit gui2;
	//private ProjectDetailsAddFormOLD gui3;
	private ProjectDetailsAddForm gui4;

	public ViewerProjectTableController(ViewerProjectDetailsForm gui, String projectId) {
		this.gui = gui;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new ViewerProjectTableModel(projectId);
		tableModel.addTableModelListener(this);

		
		int firstIndex = 0;

		gui.setProjectNameTextField((String) tableModel
				.getValueAt(firstIndex, 1));
		gui.setProjectStatusTextField((String) tableModel
				.getValueAt(firstIndex, 2));
		gui.setProjectThemeTextField((String) tableModel
				.getValueAt(firstIndex, 3));
		gui.setProjectScopeTextField((String) tableModel
				.getValueAt(firstIndex, 4));
		gui.setProjectStartDateTextField((String) tableModel
				.getValueAt(firstIndex, 5));
		gui.setProjectEndDateTextField((String) tableModel
				.getValueAt(firstIndex, 6));
		gui.setProjectLocationTextField((String) tableModel
				.getValueAt(firstIndex, 7));

				
	}

	public ViewerProjectTableController(
			ProjectDetailsEdit gui2, String projectId) {
		this.gui2 = gui2;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new ViewerProjectTableModel(projectId);
		tableModel.addTableModelListener(this);
		

		
		int firstIndex = 0;

//		gui2.setProjectIdTextField((String) tableModel
//				.getValueAt(firstIndex, 0));
		gui2.setProjectNameTextField((String) tableModel
				.getValueAt(firstIndex, 1));
		gui2.setProjectStatusTextField((String) tableModel
				.getValueAt(firstIndex, 2));
		gui2.setProjectThemeTextField((String) tableModel
				.getValueAt(firstIndex, 3));
		gui2.setProjectScopeTextField((String) tableModel
				.getValueAt(firstIndex, 4));
		gui2.setProjectStartDateTextField((String) tableModel
				.getValueAt(firstIndex, 5));
		gui2.setProjectEndDateTextField((String) tableModel
				.getValueAt(firstIndex, 6));
		gui2.setProjectLocationTextField((String) tableModel
				.getValueAt(firstIndex, 7));
	}


	
//	public ViewerProjectTableController(
//			ProjectDetailsAddFormOLD gui3) {
//		this.gui3 = gui3;
//		// create the tableModel using the data in the cachedRowSet
//		tableModel = new ViewerProjectTableModel();
//		tableModel.addTableModelListener(this);
		
//
//		
//		int firstIndex = 0;
//
//		gui3.setProjectIdTextField((String) tableModel
//				.getValueAt(firstIndex, 0));
//		gui3.setProjectNameTextField((String) tableModel
//				.getValueAt(firstIndex, 1));
//		gui3.setProjectStatusTextField((String) tableModel
//				.getValueAt(firstIndex, 2));
//		gui3.setProjectThemeTextField((String) tableModel
//				.getValueAt(firstIndex, 3));
//		gui3.setProjectScopeTextField((String) tableModel
//				.getValueAt(firstIndex, 4));
//		gui3.setProjectStartDateTextField((String) tableModel
//				.getValueAt(firstIndex, 5));
//		gui3.setProjectEndDateTextField((String) tableModel
//				.getValueAt(firstIndex, 6));
//		gui3.setProjectLocationTextField((String) tableModel
//				.getValueAt(firstIndex, 7));
//	}

	public ViewerProjectTableController(
			ProjectDetailsAddForm gui4) {
		this.gui4 = gui4;
		// create the tableModel using the data in the cachedRowSet
		tableModel = new ViewerProjectTableModel();
		tableModel.addTableModelListener(this);
		

		
//		int firstIndex = 0;
//
////		gui2.setProjectIdTextField((String) tableModel
////				.getValueAt(firstIndex, 0));
//		gui2.setProjectNameTextField((String) tableModel
//				.getValueAt(firstIndex, 1));
//		gui2.setProjectStatusTextField((String) tableModel
//				.getValueAt(firstIndex, 2));
//		gui2.setProjectThemeTextField((String) tableModel
//				.getValueAt(firstIndex, 3));
//		gui2.setProjectScopeTextField((String) tableModel
//				.getValueAt(firstIndex, 4));
//		gui2.setProjectStartDateTextField((String) tableModel
//				.getValueAt(firstIndex, 5));
//		gui2.setProjectEndDateTextField((String) tableModel
//				.getValueAt(firstIndex, 6));
//		gui2.setProjectLocationTextField((String) tableModel
//				.getValueAt(firstIndex, 7));
	}
	// new code
	public TableModel getTableModel() {
		return tableModel;
	}

	public void valueChanged(ListSelectionEvent e) {
//		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
//		
//		int firstIndex = 0;
//
//		gui.setProjectNameTextField((String) tableModel
//				.getValueAt(firstIndex, 1));
//		gui.setProjectStatusTextField((String) tableModel
//				.getValueAt(firstIndex, 2));
//		gui.setProjectThemeTextField((String) tableModel
//				.getValueAt(firstIndex, 3));
//		gui.setProjectScopeTextField((String) tableModel
//				.getValueAt(firstIndex, 4));
//		gui.setProjectStartDateTextField((String) tableModel
//				.getValueAt(firstIndex, 5));
//		gui.setProjectEndDateTextField((String) tableModel
//				.getValueAt(firstIndex, 6));
//		gui.setProjectLocationTextField((String) tableModel
//				.getValueAt(firstIndex, 7));
	}

	public void tableChanged(TableModelEvent e) {
//		try {
//
//			int firstIndex = e.getFirstRow();
//
//
//			tableModel = new ViewerProjectTableModel(tableModel.getList(),
//					tableModel.getEntityManager());
//			tableModel.addTableModelListener(this);
//
//			
//			gui.setProjectNameTextField((String) tableModel
//					.getValueAt(firstIndex, 1));
//			gui.setProjectStatusTextField((String) tableModel
//					.getValueAt(firstIndex, 2));
//			gui.setProjectThemeTextField((String) tableModel
//					.getValueAt(firstIndex, 3));
//			gui.setProjectScopeTextField((String) tableModel
//					.getValueAt(firstIndex, 4));
//			gui.setProjectStartDateTextField((String) tableModel
//					.getValueAt(firstIndex, 5));
//			gui.setProjectEndDateTextField((String) tableModel
//					.getValueAt(firstIndex, 6));
//			gui.setProjectLocationTextField((String) tableModel
//					.getValueAt(firstIndex, 7));
//			
//			
//		} catch (Exception exp) {
//			exp.getMessage();
//			exp.printStackTrace();
//		}
	}

	public void updateRow(String id, String name, String status, String theme, String scope, String startDate, String endDate, String location) {
		tableModel.updateRow(id, name, status, theme, scope, startDate, endDate, location);
		
	}

	public void addRow(String id, String name, String status, String theme,
			String scope, String startDate, String endDate, String location) {
		tableModel.addRow(id, name, status, theme, scope, startDate, endDate, location);
		
	}

	public void addRow(String projectId) {
	tableModel.addRow(projectId);
	tableModel.fireTableDataChanged();
		
	}
	public void deleteRow(String projectId) {
		tableModel.deleteRow(projectId);
		tableModel.fireTableDataChanged();
		
	}


}
