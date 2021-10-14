package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Requirements;
import com.revature.utils.ConnectionUtil;

public class RequirementsDAOImpl implements RequirementsDAO{
	
	public List<Requirements> findAll() {
		try(Connection conn = ConnectionUtil.getConnection()){ 
			String sql = "SELECT * FROM craftedgoodsrequirements;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Requirements> list = new ArrayList<>();
			
			
			while(result.next()) {
				
				Requirements requirements = new Requirements();
				requirements.setGoodname(result.getString("goodname"));
				requirements.setTimber(result.getInt("timber"));
				requirements.setCoarseleather(result.getInt("coarseleather"));
				requirements.setLinen(result.getInt("linen"));
				requirements.setIroningot(result.getInt("ironingot"));
				requirements.setGreenwood(result.getInt("greenwood"));
				requirements.setIronore(result.getInt("ironore"));
				requirements.setRawhide(result.getInt("rawhide"));
				requirements.setFibers(result.getInt("fibers"));
				list.add(requirements);
			}
			
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public Requirements findByName(String goodname) {
		try(Connection conn = ConnectionUtil.getConnection()){ //try-with-resources 
			String sql = "SELECT * FROM craftedgoodsrequirements WHERE goodname = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, goodname);
			
			ResultSet result = statement.executeQuery();
			
			Requirements requirements = new Requirements();
			
			//ResultSets have a cursor (similar to Scanner or other I/O classes) that can be used 
			//with a while loop to iterate through all the data. 
			
			if(result.next()) {
				
				requirements.setGoodname(result.getString("goodname"));
				requirements.setTimber(result.getInt("timber"));
				requirements.setCoarseleather(result.getInt("coarseleather"));
				requirements.setLinen(result.getInt("linen"));
				requirements.setIroningot(result.getInt("ironingot"));
				requirements.setGreenwood(result.getInt("greenwood"));
				requirements.setIronore(result.getInt("ironore"));
				requirements.setRawhide(result.getInt("rawhide"));
				requirements.setFibers(result.getInt("fibers"));

			}
			
			return requirements;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean updateRequirements(Requirements requirements) {
		
		return false;
	}

	

}
