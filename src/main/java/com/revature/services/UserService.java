package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.UserModel;

public class UserService {
	
	private static UserDAO userDao = new UserDAOImpl();	
	//added the static. may cause errors later??
	
	public List<UserModel> findAllUsers() {
		return userDao.findAll();
	}

	public UserModel findByID(int ID) {
		return userDao.findByID(ID);
		
	}
	 
	public static boolean newUser(UserModel user) {
		return userDao.addUser(user);
	}
	//added the static. may cause errors later??
	
		
}
