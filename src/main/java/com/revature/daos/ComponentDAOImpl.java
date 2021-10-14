package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Component;
import com.revature.models.UserModel;
import com.revature.services.ComponentService;
import com.revature.utils.ConnectionUtil;

public class ComponentDAOImpl implements ComponentDAO{
	
	public List<Component> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
			String sql = "SELECT * FROM componentinventory;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Component> list = new ArrayList<>();
			
			//ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
			//with a while loop to iterate through all the data. 
			
			while(result.next()) {
				
				Component component = new Component();
				component.setComponentinventoryID(result.getInt("componentinventoryID"));
				component.setTimber(result.getInt("timber"));
				component.setCoarseleather(result.getInt("coarseleather"));
				component.setLinen(result.getInt("linen"));
				component.setIroningot(result.getInt("ironingot"));
				component.setGreenwood(result.getInt("greenwood"));
				component.setIronore(result.getInt("ironore"));
				component.setRawhide(result.getInt("rawhide"));
				component.setFibers(result.getInt("fibers"));
				list.add(component);
			}
			
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Component findByID(int componentinventoryID) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM componentinventory WHERE componentinventoryID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, componentinventoryID);
			
			ResultSet result = statement.executeQuery();
			
			Component component = new Component();
			
			
			if(result.next()) {
				
				component.setComponentinventoryID(result.getInt("componentinventoryID"));
				component.setTimber(result.getInt("timber"));
				component.setCoarseleather(result.getInt("coarseleather"));
				component.setLinen(result.getInt("linen"));
				component.setIroningot(result.getInt("ironingot"));
				component.setGreenwood(result.getInt("greenwood"));
				component.setIronore(result.getInt("ironore"));
				component.setRawhide(result.getInt("rawhide"));
				component.setFibers(result.getInt("fibers"));

			}
			
			return component;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean updateComponent(String s, int i, UserModel user) {
		//*** next thing to do. need to use user loginID to find the right foreign key to insert there
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "";
			Component c = ComponentService.findByID(user.getUserID());
				
			if(s.contains("timber")) {
			sql = "UPDATE componentinventory SET timber = ? WHERE componentinventoryID = (SELECT userID FROM users WHERE username = ?);";
			}else if(s.contains("coarseleather")) {
				sql = "UPDATE componentinventory SET coarseleather = ? WHERE componentinventoryID = (SELECT userID FROM users WHERE username = ?);";
				
				i = i+c.getCoarseleather();	
				
			}else if(s.contains("linen")) {
				sql = "UPDATE componentinventory SET linen = ? WHERE componentinventoryID = (SELECT userID FROM users WHERE username = ?);";
				i = i+c.getLinen();
			}else if(s.contains("ironingot")) {
				sql = "UPDATE componentinventory SET ironingot = ? WHERE componentinventoryID = (SELECT userID FROM users WHERE username = ?);";
				i = i+c.getIroningot();
			}else if(s.contains("greenwood")) {
				sql = "UPDATE componentinventory SET greenwood = ? WHERE componentinventoryID = (SELECT userID FROM users WHERE username = ?);";
				i = i+c.getGreenwood();
			}else if(s.contains("ironore")) {
				sql = "UPDATE componentinventory SET ironore = ? WHERE componentinventoryID = (SELECT userID FROM users WHERE username = ?);";
				i = i+c.getIronore();
			}else if(s.contains("rawhide")) {
				sql = "UPDATE componentinventory SET rawhide = ? WHERE componentinventoryID = (SELECT userID FROM users WHERE username = ?);";
				i = i+c.getRawhide();
			}else if(s.contains("fiber")) {
				sql = "UPDATE componentinventory SET fibers = ? WHERE componentinventoryID = (SELECT userID FROM users WHERE username = ?);";
				i = i+c.getFibers();
			}else {
				return false;
			}
			
			if(i<0) {
				System.out.println("You can't withdraw more than you have deposited.");
				return false;
			}
			
			
			int count =0;
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			//statement.setString(++count, "timber");
			statement.setInt(++count, i);
			statement.setString(++count, user.getUsername());
			//statement = conn.prepareStatement(statement.toString());
			statement.execute();
			return true;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	
	public boolean addComponent() {
		
	try(Connection conn = ConnectionUtil.getConnection()){
				
				String sql = "INSERT INTO componentinventory (ironore) VALUES (0);";
				
				PreparedStatement statement = conn.prepareStatement(sql);
							
				statement.execute();
				
				return true;
	
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return false;
	}
}
