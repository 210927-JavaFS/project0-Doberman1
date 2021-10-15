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
import com.revature.utils.Encrypt;

public class UserDAOImpl implements UserDAO{

	
	public List<UserModel> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM users;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<UserModel> list = new ArrayList<>();
			
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
			//e.printStackTrace();
			System.out.println("Some input was invalid.");
		}
		return null;
	}

	
	public UserModel findByID(int userID) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM users WHERE userID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, userID);
			
			ResultSet result = statement.executeQuery();
			
			UserModel user = new UserModel();
			
		
			if(result.next()) {
				
				user.setUserID(result.getInt("userID"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("userpassword"));
				user.setUserType(result.getInt("usertype"));

			}
			
			return user;
			
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Some input was invalid.");
		}
		return null;
	}
	
	public UserModel findByName(String name) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM users WHERE username = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			
			UserModel user = new UserModel();
			
			
			
			if(result.next()) {
				
				user.setUserID(result.getInt("userID"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("userpassword"));
				user.setUserType(result.getInt("usertype"));

			}
			
			return user;
			
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Some input was invalid.");
		}
		return null;
	}

	
	public boolean changeType(String name, int type) {
		
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE users SET usertype = ? WHERE username = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, type);
			statement.setString(2, name);
			
			statement.execute();
			
			return true;
			
		}catch (SQLException e) {
			//e.printStackTrace();
			return false;
		}
		
	}

	
	public boolean addUser(UserModel user) {
		
	try(Connection conn = ConnectionUtil.getConnection()){
				
				//String sql = "INSERT INTO users (username, userpassword, usertype)"
				//		+ "VALUES (?,?,?);";
				
				String sql = "call createnewuser(?,?,?); ";
					
		
				int count = 0;
				
				PreparedStatement statement = conn.prepareStatement(sql);
				//statement.setInt(++count, user.getUserID());
				statement.setString(++count, user.getUsername());
				statement.setString(++count, user.getPassword());
				statement.setInt(++count, user.getUserType());
							
				statement.execute();
				
				
				
				return true;
	
			}catch(SQLException e) {
				//e.printStackTrace();
				System.out.println("Some input was invalid.");
			}
			return false;
	}
	
	public boolean checkPass(String pass, UserModel user) {
		Encrypt decryptor = new Encrypt();
		
		if(decryptor.encrypt(pass).equals(user.getPassword())) {
			return true;
		}
		
		return false;
	}
	
	
	

}
