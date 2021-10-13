package com.revature.daos;

import java.util.List;

import com.revature.models.Requirements;

public interface RequirementsDAO {
	
	public List<Requirements> findAll();
	public Requirements findByName(String goodname);
	public boolean updateRequirements(Requirements requirements);

}
