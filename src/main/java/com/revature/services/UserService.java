package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.UserModel;

public class UserService {
	
	String username = new String();
	String password = new String();
	int userType;
	private UserDAO userDao = new UserDAOImpl();
	
	public UserService(String username, String password, int userType){
		this.username = username;
		this.password = password;
		this.userType = userType;
		
		
	}

	public void createNewUser(String username, String password, int userType){
		this.username = username;
		this.password = password;
		this.userType = userType;
		
		
	}
	
	
	public List<UserModel> findAllUsers() {
		return userDao.findAll();
	}

	public UserModel findByID(int ID) {
		return userDao.findByID(ID);
		
	}
	 
	public boolean newUser(UserModel user) {
		return userDao.addUser(user);
	}
	
		
}
