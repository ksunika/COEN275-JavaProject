package com.project.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.project.entity.Login;

public class LoginService {

	private EntityManager manager;

	public LoginService(EntityManager manager) {
		this.manager = manager;
	}

	public boolean validate(String username, String password) {
		try {
			TypedQuery<Login> query = manager.createQuery(
					"SELECT l FROM Login l WHERE l.username = :username",
					Login.class);
			query.setParameter("username", username);
			Login result = query.getSingleResult();
			if (result.getPassword().equals(password))
				return true;
		} catch (javax.persistence.NoResultException exp) {
			System.out.println("No users are found ");
		}
		return false;
	}
}
