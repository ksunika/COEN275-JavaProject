package com.project.tablemodel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

import com.project.entity.Hyperlink;
import com.project.entity.Partner;
import com.project.service.HyperlinkService;

/**
 * 
 * @author ksusha
 */
public class HyperlinkTableModel extends AbstractTableModel {

	List<Hyperlink> hyperlinkResultList; // stores the model data in a List
											// collection of type CourseList
	private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit"; // Used
																			// in
																			// persistence.xml
	private static EntityManagerFactory factory; // JPA
	private EntityManager manager; // JPA
	private Hyperlink hyperlink;
	private HyperlinkService hyperlinkService;

	// This field contains additional information about the results
	int numcols, numrows; // number of rows and columns

	public HyperlinkTableModel(String projectId, String type) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();
		hyperlink = new Hyperlink();

		hyperlinkService = new HyperlinkService(manager);

		hyperlinkResultList = hyperlinkService.readHyperlink(projectId, type);

		// update the number of rows and columns in the model
		numrows = hyperlinkResultList.size();
		numcols = Hyperlink.getNumberOfColumns();
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
			return hyperlinkResultList.get(row).getColumnData(col);
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
			return hyperlink.getColumnName(col);
		} catch (Exception err) {
			return err.toString();
		}
	}

	public List<Hyperlink> getList() {
		return hyperlinkResultList;
	}

	public EntityManager getEntityManager() {
		return manager;
	}

	// create a new table model using the existing data in list
	public HyperlinkTableModel(List<Hyperlink> list, EntityManager em) {
		hyperlinkResultList = list;
		numrows = hyperlinkResultList.size();
		hyperlink = new Hyperlink();
		numcols = hyperlink.getNumberOfColumns();
		manager = em;
		hyperlinkService = new HyperlinkService(manager);
	}

	public void addRow(String path, String projectId, String type) {
		// add row to database
		EntityTransaction userTransaction = manager.getTransaction();
		if (!userTransaction.isActive())
			userTransaction.begin();
		Hyperlink newRecord = hyperlinkService.createHyperlink(path, projectId,
				type);
		if (userTransaction.isActive())
			userTransaction.commit();

		// set the current row to rowIndex
		hyperlinkResultList.add(newRecord);
		int row = hyperlinkResultList.size();
		int col = 0;

		numrows++;

	}

	public void deleteRow(String path) {
		Hyperlink hyperlink = hyperlinkService.findHyperlink(path);
		hyperlinkResultList.remove(hyperlink);

		EntityTransaction userTransaction = manager.getTransaction();
		if (!userTransaction.isActive())
			userTransaction.begin();
		hyperlinkService.deleteHyperlink(path);
		if (userTransaction.isActive())
			userTransaction.commit();

		numrows--;

	}

}
