package com.revature.daos;

import java.util.List;

import com.revature.models.Crafted;

public interface CraftedDAO {

	public List<Crafted> findAllCrafted();
	public Crafted findByID(int craftedinventoryID);
	public boolean updateCrafted(String name, int userID);
	public boolean addCrafted();
	
}
