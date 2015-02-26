package com.project.controller;

import com.project.tablemodel.LoginTableModel;


public class LoginController {
	
	LoginTableModel tableModel;
	
	public LoginController() {
		// TODO Auto-generated constructor stub
		
		tableModel = new LoginTableModel();
		
	}

	public boolean validate(String username, String password) {
		// TODO Auto-generated method stub
		 return tableModel.validate(username,password);
	}

}
