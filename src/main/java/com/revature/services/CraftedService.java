package com.revature.services;

import java.util.List;

import com.revature.daos.CraftedDAO;
import com.revature.daos.CraftedDAOImpl;
import com.revature.models.Crafted;


public class CraftedService {
	
	
	private static CraftedDAO craftedDao = new CraftedDAOImpl();	
	//added the static. may cause errors later??
	
	public Crafted findByID(int ID){
		
		return craftedDao.findByID(ID);
	}

	public boolean updateCrafted(Crafted crafted) {
		
		return craftedDao.updateCrafted(crafted);
		
	}
	 
	public static boolean addCrafted() {
		return craftedDao.addCrafted();
	}
	
	
}
