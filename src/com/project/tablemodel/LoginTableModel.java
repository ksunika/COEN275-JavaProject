package com.project.tablemodel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

import com.project.entity.Login;
import com.project.entity.ProjectDetails;
import com.project.service.LoginService;
import com.project.service.ViewerProjectService;

public class LoginTableModel extends AbstractTableModel{

	
	private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit"; // Used
																			// in
																			// persistence.xml
	private static EntityManagerFactory factory; // JPA
	private EntityManager manager;
	private ProjectDetails projectDetails;
	private LoginService loginService;

	
	public LoginTableModel()
	{
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		manager = factory.createEntityManager();

		
		loginService = new LoginService(manager);
		
	}
	public boolean validate(String username, String password) {
		
		return loginService.validate(username, password);
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
