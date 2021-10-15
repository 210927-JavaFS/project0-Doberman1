package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	
	public boolean updateRequirements(String goodname) {
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		String input = "";
		int i;
		
		
try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "UPDATE craftedgoodsrequirements SET timber = ?, coarseleather = ?, linen = ?, ironingot =  ?, greenwood = ?, ironore =? , rawhide=?, fibers=? WHERE goodname = ?;";
			
			
			
			PreparedStatement statement = conn.prepareStatement(sql);
			try{
				
	       
			
			System.out.println("How much timber does it now need?");
			input = sc.nextLine();
			statement.setInt(++count, Integer.parseInt(input));
			System.out.println("What about coarse leather?");
			input = sc.nextLine();
			statement.setInt(++count, Integer.parseInt(input));
			System.out.println("Linen?");
			input = sc.nextLine();
			statement.setInt(++count, Integer.parseInt(input));
			System.out.println("Iron ingots?");
			input = sc.nextLine();
			statement.setInt(++count, Integer.parseInt(input));
			System.out.println("Greenwood?");
			input = sc.nextLine();
			statement.setInt(++count, Integer.parseInt(input));
			System.out.println("Iron ore?");
			input = sc.nextLine();
			statement.setInt(++count, Integer.parseInt(input));
			System.out.println("Raw hide?");
			input = sc.nextLine();
			statement.setInt(++count, Integer.parseInt(input));
			System.out.println("Fibers?");
			input = sc.nextLine();
			statement.setInt(++count, Integer.parseInt(input));
			}
	        catch (NumberFormatException ex){
	            System.out.println("Please only enter a number.");
	            
	            ex.printStackTrace();
	            return false;
	        }
			
			System.out.println("Thanks for helping keep the crafting bank up to date!");
			statement.setString(++count, goodname);
			
			
			statement.execute();
			
			return true;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

}
