package com.revature.daos;

import java.util.List;

import com.revature.models.Component;
import com.revature.models.UserModel;

public interface ComponentDAO {

	public List<Component> findAll();
	public Component findByID(int componentinventoryID);
	public boolean updateComponent(String s, int i, UserModel user);
	public boolean addComponent();
	
}
