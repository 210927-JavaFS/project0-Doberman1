package com.revature.services;

import java.util.List;

import com.revature.daos.ComponentDAO;
import com.revature.daos.ComponentDAOImpl;
import com.revature.models.Component;
import com.revature.models.UserModel;

public class ComponentService {
	
	private static ComponentDAO componentDao = new ComponentDAOImpl();	
	
	public List<Component> findAllComponents() {
		return componentDao.findAll();
	}

	public Component findByID(int ID){
		
		return componentDao.findByID(ID);
		
	}
	
	public static boolean updateComponent(String s, int i, UserModel user) {
		return componentDao.updateComponent(s, i, user);
	}
	
	 
	public static boolean addComponent() {
		return componentDao.addComponent();
	}
	

}
