package com.revature.services;

import java.util.List;

import com.revature.daos.UserDAO;
import com.revature.daos.UserDAOImpl;
import com.revature.models.UserModel;

public class UserService {
	
	private static UserDAO userDao = new UserDAOImpl();	
	
	public static List<UserModel> findAllUsers() {
		return userDao.findAll();
	}

	public UserModel findByID(int ID) {
		return userDao.findByID(ID);
		
	}
	
	public static UserModel findByName(String name) {
		return userDao.findByName(name);
		
	}
	public static boolean newUser(UserModel user) {
		return userDao.addUser(user);
	}
	
	public static boolean checkPass(String pass, UserModel user) {
		return userDao.checkPass(pass, user);
		
	}
	
	public static boolean changeType(String name, int type) {
		
		return userDao.changeType(name, type);
	}
	
		
}
