package com.revature.services;

import java.util.List;

import com.revature.daos.RequirementsDAO;
import com.revature.daos.RequirementsDAOImpl;
import com.revature.models.Requirements;


public class RequirementsService {

	private static RequirementsDAO requirementsDAO = new RequirementsDAOImpl();	
	
	
	public static List<Requirements> findAllRequirements() {
		return requirementsDAO.findAll();
	}

	public Requirements findByName(String name) {
		return requirementsDAO.findByName(name);
		
	}
	 
	public static boolean updateRequirements(Requirements requirement) {
		return requirementsDAO.updateRequirements(requirement);
	}
	
}
