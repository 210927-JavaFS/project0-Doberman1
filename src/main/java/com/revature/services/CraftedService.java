package com.revature.services;

import java.util.List;

import com.revature.daos.CraftedDAO;
import com.revature.daos.CraftedDAOImpl;
import com.revature.models.Crafted;


public class CraftedService {
	
	
	private static CraftedDAO craftedDao = new CraftedDAOImpl();

	
	public static List<Crafted> findAllCrafted() {
		return craftedDao.findAllCrafted();
	}
	
	public static Crafted findByID(int ID){
		
		return craftedDao.findByID(ID);
	}

	public static boolean updateCrafted(String name, int userID) {
		
		return craftedDao.updateCrafted(name, userID);
		
	}
	 
	public static boolean addCrafted() {
		return craftedDao.addCrafted();
	}
	
	
}
