package com.revature.services;

import java.util.List;

import com.revature.daos.ComponentDAO;
import com.revature.daos.ComponentDAOImpl;
import com.revature.models.Component;
import com.revature.models.UserModel;

public class ComponentService {
	
	private static ComponentDAO componentDao = new ComponentDAOImpl();	
	
	public static List<Component> findAllComponents() {
		
		List<Component> s = componentDao.findAll();
		
		
		return s;
	}

	public static Component findByID(int ID){
		Component c = componentDao.findByID(ID);
		
		//String s = "Your component inventory includes:\n"+c.getCoarseleather()+" coarse leather\n"+c.getFibers()+" fiber\n"+c.getGreenwood()+" greenwood\n"+c.getIroningot()+" iron ingots\n"+c.getIronore()+" iron ore\n"+c.getLinen()+" linen\n"+c.getRawhide()+" raw hide\n"+c.getTimber()+" timber";
		return c;
		
	}
	
	public static boolean updateComponent(String s, int i, UserModel user) {
		return componentDao.updateComponent(s, i, user);
	}
	
	 
	public static boolean addComponent() {
		return componentDao.addComponent();
	}
	

}
