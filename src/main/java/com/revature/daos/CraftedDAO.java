package com.revature.daos;

import java.util.List;

import com.revature.models.Crafted;

public interface CraftedDAO {

	public Crafted findByID(int craftedinventoryID);
	public boolean updateCrafted(Crafted crafted);
	public boolean addCrafted();
	
}
