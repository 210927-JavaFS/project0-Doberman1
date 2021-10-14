package com.revature.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class UserModel {

	private int userID;
	private String username;
	private String password;
	private int userType;
	
	
	public UserModel() {	
	}
	
	
	public UserModel(String username, String password, 
			int userType){
		super();
		this.username = username;
		this.password = password;
		this.userType = userType;	
	}
	

	public int getUserID() {
		
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
			String sql = "SELECT userID FROM users WHERE username = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, this.username);
			
			ResultSet result = statement.executeQuery();
			
			
			
			//ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
			//with a while loop to iterate through all the data. 
			
			if(result.next()) {
				
				userID = (result.getInt("userID"));

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//sql = "select userID from users where username = ?;";
		//	statement.setString(1, user.getUsername());
			//ResultSet result = statement.executeQuery(sql);
			
			//user.setUserID(result.);
		return userID;		
	}
	
	
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userID;
		result = prime * result + userType;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userID != other.userID)
			return false;
		if (userType != other.userType)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UserModel [userID=" + userID + ", username=" + username + ", password=" + password + ", userType="
				+ userType + "]";
	}


	
	
}
