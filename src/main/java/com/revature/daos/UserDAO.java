package com.revature.daos;

import java.util.List;
import com.revature.models.UserModel;

public interface UserDAO {

	public List<UserModel> findAll();
	public UserModel findByID(int userID);
	public boolean updateUser(UserModel user);
	public boolean addUser(UserModel user);
	
	
}
