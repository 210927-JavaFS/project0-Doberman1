package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.UserModel;
import com.revature.utils.ConnectionUtil;

public class UserDAOImpl implements UserDAO{

	
	public List<UserModel> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
			String sql = "SELECT * FROM users;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<UserModel> list = new ArrayList<>();
			
			//ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
			//with a while loop to iterate through all the data. 
			
			while(result.next()) {
				
				UserModel user = new UserModel();
				user.setUserID(result.getInt("userID"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("userpassword"));
				user.setUserType(result.getInt("usertype"));
				list.add(user);
			}
			
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public UserModel findByID(int userID) {
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
			String sql = "SELECT * FROM users WHERE userID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, userID);
			
			ResultSet result = statement.executeQuery();
			
			UserModel user = new UserModel();
			
			//ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
			//with a while loop to iterate through all the data. 
			
			if(result.next()) {
				
				user.setUserID(result.getInt("userID"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("userpassword"));
				user.setUserType(result.getInt("usertype"));

			}
			
			return user;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean updateUser(UserModel user) {
		
		return false;
	}

	
	public boolean addUser(UserModel user) {
		
	try(Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "INSERT INTO users (username, userpassword, usertype)"
						+ "VALUES (?,?,?);";
				
				int count = 0;
				
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(++count, user.getUserID());
				statement.setString(++count, user.getUsername());
				statement.setString(++count, user.getPassword());
				statement.setInt(++count, user.getUserType());
							
				statement.execute();
				
				return true;
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
	
	
	

}
