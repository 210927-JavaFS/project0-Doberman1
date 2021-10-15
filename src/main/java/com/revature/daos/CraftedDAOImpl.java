package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.revature.models.Crafted;

import com.revature.services.CraftedService;
import com.revature.utils.ConnectionUtil;

public class CraftedDAOImpl implements CraftedDAO{
	
	
	public List<Crafted> findAllCrafted() {
		try(Connection conn = ConnectionUtil.getConnection()){ 
			String sql = "SELECT * FROM craftedinventory;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Crafted> list = new ArrayList<>();
			 
			
			while(result.next()) {
				
				Crafted crafted = new Crafted();
				crafted.setCraftedinventoryID(result.getInt("craftedinventoryID"));
				crafted.setLinenleggings(result.getInt("linenleggings"));
				crafted.setLinenbonnet(result.getInt("linenbonnet"));
				crafted.setLinenshoes(result.getInt("linenshoes"));
				crafted.setLinenhat(result.getInt("linenhat"));
				crafted.setLinenhandwraps(result.getInt("linenhandwraps"));
				crafted.setLinenshirt(result.getInt("linenshirt"));
				crafted.setLinenpants(result.getInt("linenpants"));
				crafted.setLinendress(result.getInt("linendress"));
				crafted.setLinengloves(result.getInt("coarseleathergloves"));
				crafted.setCoarseleatherboots(result.getInt("coarseleatherboots"));
				crafted.setCoarseleathergloves(result.getInt("coarseleathergloves"));
				crafted.setCoarseleatherpants(result.getInt("coarseleatherpants"));
				crafted.setCoarseleathershirt(result.getInt("coarseleathershirt"));
				crafted.setCoarseleatherhat(result.getInt("coarseleatherhat"));
				crafted.setIrongreataxe(result.getInt("irongreataxe"));
				crafted.setIronwarhammer(result.getInt("ironspear"));
				crafted.setIronspear(result.getInt("ironspear"));
				crafted.setIronrapier(result.getInt("ironrapier"));
				crafted.setIronhatchet(result.getInt("ironhatchet"));
				crafted.setIronroundshield(result.getInt("ironroundshield"));
				crafted.setIronlongsword(result.getInt("ironlongsword"));
				crafted.setIronplategreaves(result.getInt("ironplategreaves"));
				crafted.setIronplatehelmet(result.getInt("ironplatehelmet"));
				crafted.setIronplateboots(result.getInt("ironplateboots"));
				crafted.setIronplatebreastplate(result.getInt("ironplatebreastplate"));
				crafted.setIronplategauntlets(result.getInt("ironplategauntlets"));
				crafted.setIronmusket(result.getInt("ironmusket"));
				crafted.setTreatedwoodenbow(result.getInt("treatedwoodenbow"));
				crafted.setIronskinningknife(result.getInt("ironskinningknife"));
				crafted.setIronloggingaxe(result.getInt("ironloggingaxe"));
				crafted.setIronminingpickaxe(result.getInt("ironminingpickaxe"));
				crafted.setIronharvestingsickle(result.getInt("ironharvestingsickle"));
				crafted.setTreatedwoodenpole(result.getInt("treatedwoodenpole"));
				list.add(crafted);
			}
			
			return list;
			
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Some input was invalid.");
		}
		return null;
	}
	
	

	public Crafted findByID(int craftedID) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM craftedinventory WHERE craftedinventoryID = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setInt(1, craftedID);
			
			ResultSet result = statement.executeQuery();
			
			Crafted crafted = new Crafted();
			
			
			if(result.next()) {
				
				
				crafted.setCraftedinventoryID(result.getInt("craftedinventoryID"));
				crafted.setLinenleggings(result.getInt("linenleggings"));
				crafted.setLinenbonnet(result.getInt("linenbonnet"));
				crafted.setLinenshoes(result.getInt("linenshoes"));
				crafted.setLinenhat(result.getInt("linenhat"));
				crafted.setLinenhandwraps(result.getInt("linenhandwraps"));
				crafted.setLinenshirt(result.getInt("linenshirt"));
				crafted.setLinenpants(result.getInt("linenpants"));
				crafted.setLinendress(result.getInt("linendress"));
				crafted.setLinengloves(result.getInt("coarseleathergloves"));
				crafted.setCoarseleatherboots(result.getInt("coarseleatherboots"));
				crafted.setCoarseleathergloves(result.getInt("coarseleathergloves"));
				crafted.setCoarseleatherpants(result.getInt("coarseleatherpants"));
				crafted.setCoarseleathershirt(result.getInt("coarseleathershirt"));
				crafted.setCoarseleatherhat(result.getInt("coarseleatherhat"));
				crafted.setIrongreataxe(result.getInt("irongreataxe"));
				crafted.setIronwarhammer(result.getInt("ironspear"));
				crafted.setIronspear(result.getInt("ironspear"));
				crafted.setIronrapier(result.getInt("ironrapier"));
				crafted.setIronhatchet(result.getInt("ironhatchet"));
				crafted.setIronroundshield(result.getInt("ironroundshield"));
				crafted.setIronlongsword(result.getInt("ironlongsword"));
				crafted.setIronplategreaves(result.getInt("ironplategreaves"));
				crafted.setIronplatehelmet(result.getInt("ironplatehelmet"));
				crafted.setIronplateboots(result.getInt("ironplateboots"));
				crafted.setIronplatebreastplate(result.getInt("ironplatebreastplate"));
				crafted.setIronplategauntlets(result.getInt("ironplategauntlets"));
				crafted.setIronmusket(result.getInt("ironmusket"));
				crafted.setTreatedwoodenbow(result.getInt("treatedwoodenbow"));
				crafted.setIronskinningknife(result.getInt("ironskinningknife"));
				crafted.setIronloggingaxe(result.getInt("ironloggingaxe"));
				crafted.setIronminingpickaxe(result.getInt("ironminingpickaxe"));
				crafted.setIronharvestingsickle(result.getInt("ironharvestingsickle"));
				crafted.setTreatedwoodenpole(result.getInt("treatedwoodenpole"));

			}
			
			return crafted;
			
		}catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Some input was invalid.");
		}
		return null;
	}

	
	public boolean updateCrafted(String s, int userID) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "";
			Crafted c = CraftedService.findByID(userID);
			int i;
				
			if(s.contains("linenleggings")) {
				sql = "UPDATE craftedinventory SET linenleggings = ? WHERE craftedinventoryID = ?;";
				i = c.getLinenleggings()+1;
			}else if(s.contains("linenbonnet")) {
				sql = "UPDATE craftedinventory SET linenbonnet = ? WHERE craftedinventoryID = ?;";	
				i = c.getLinenbonnet()+1;
			}else if(s.contains("linenhat")) {
				sql = "UPDATE craftedinventory SET linenhat = ? WHERE craftedinventoryID = ?;";	
				i = c.getLinenhat()+1;
			}else if(s.contains("linenshoes")) {
				sql = "UPDATE craftedinventory SET linenshoes = ? WHERE craftedinventoryID = ?;";	
				i = c.getLinenshoes()+1;
			}else if(s.contains("linenhandwraps")) {
				sql = "UPDATE craftedinventory SET linenhandwraps = ? WHERE craftedinventoryID = ?;";	
				i = c.getLinenhandwraps()+1;
			}else if(s.contains("linenshirt")) {
				sql = "UPDATE craftedinventory SET linenshirt = ? WHERE craftedinventoryID = ?;";	
				i = c.getLinenshirt()+1;
			}else if(s.contains("linenpants")) {
				sql = "UPDATE craftedinventory SET linenpants = ? WHERE craftedinventoryID = ?;";	
				i = c.getLinenpants()+1;
			}else if(s.contains("linendress")) {
				sql = "UPDATE craftedinventory SET linendress = ? WHERE craftedinventoryID = ?;";	
				i = c.getLinendress()+1;
			}else if(s.contains("linengloves")) {
				sql = "UPDATE craftedinventory SET linengloves = ? WHERE craftedinventoryID = ?;";	
				i = c.getLinengloves()+1;
			}else if(s.contains("coarseleatherboots")) {
				sql = "UPDATE craftedinventory SET coarseleatherboots = ? WHERE craftedinventoryID = ?;";	
				i = c.getCoarseleatherboots()+1;
			}else if(s.contains("coarseleathergloves")) {
				sql = "UPDATE craftedinventory SET coarseleathergloves = ? WHERE craftedinventoryID = ?;";	
				i = c.getCoarseleathergloves()+1;
			}else if(s.contains("coarseleatherpants")) {
				sql = "UPDATE craftedinventory SET coarseleatherpants = ? WHERE craftedinventoryID = ?;";	
				i = c.getCoarseleatherpants()+1;
			}else if(s.contains("coarseleathershirt")) {
				sql = "UPDATE craftedinventory SET coarseleathershirtt = ? WHERE craftedinventoryID = ?;";	
				i = c.getCoarseleathershirt()+1;
			}else if(s.contains("coarseleatherhat")) {
				sql = "UPDATE craftedinventory SET coarseleatherhat = ? WHERE craftedinventoryID = ?;";	
				i = c.getCoarseleatherhat()+1;
			}else if(s.contains("irongreataxe")) {
				sql = "UPDATE craftedinventory SET irongreataxe = ? WHERE craftedinventoryID = ?;";	
				i = c.getIrongreataxe()+1;
			}else if(s.contains("ironwarhammer")) {
				sql = "UPDATE craftedinventory SET ironwarhammer = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronwarhammer()+1;
			}else if(s.contains("ironspear")) {
				sql = "UPDATE craftedinventory SET ironspear = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronspear()+1;
			}else if(s.contains("ironrapier")) {
				sql = "UPDATE craftedinventory SET ironrapier = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronrapier()+1;
			}else if(s.contains("ironhatchet")) {
				sql = "UPDATE craftedinventory SET ironhatchet = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronhatchet()+1;
			}else if(s.contains("ironroundshield")) {
				sql = "UPDATE craftedinventory SET ironroundshield = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronroundshield()+1;
			}else if(s.contains("ironlongsword")) {
				sql = "UPDATE craftedinventory SET ironlongsword = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronlongsword()+1;
			}else if(s.contains("ironplategreaves")) {
				sql = "UPDATE craftedinventory SET ironplategreaves = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronplategreaves()+1;
			}else if(s.contains("ironplatehelmet")) {
				sql = "UPDATE craftedinventory SET ironplatehelmet = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronplatehelmet()+1;
			}else if(s.contains("ironplateboots")) {
				sql = "UPDATE craftedinventory SET ironplateboots = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronplateboots()+1;
			}else if(s.contains("ironplatebreastplate")) {
				sql = "UPDATE craftedinventory SET ironplatebreastplate = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronplatebreastplate()+1;
			}else if(s.contains("ironplategauntlets")) {
				sql = "UPDATE craftedinventory SET ironplategauntlets = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronplategauntlets()+1;
			}else if(s.contains("ironmusket")) {
				sql = "UPDATE craftedinventory SET ironmusket = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronmusket()+1;
			}else if(s.contains("treatedwoodenbow")) {
				sql = "UPDATE craftedinventory SET treatedwoodenbow = ? WHERE craftedinventoryID = ?;";	
				i = c.getTreatedwoodenbow()+1;
			}else if(s.contains("ironskinningknife")) {
				sql = "UPDATE craftedinventory SET ironskinningknife = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronskinningknife()+1;
			}else if(s.contains("ironloggingaxe")) {
				sql = "UPDATE craftedinventory SET ironloggingaxe = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronloggingaxe()+1;
			}else if(s.contains("ironminingpickaxe")) {
				sql = "UPDATE craftedinventory SET ironminingpickaxe  = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronminingpickaxe ()+1;
			}else if(s.contains("ironharvestingsickle")) {
				sql = "UPDATE craftedinventory SET ironharvestingsickle = ? WHERE craftedinventoryID = ?;";	
				i = c.getIronharvestingsickle()+1;
			}else if(s.contains("treatedwoodenpole")) {
				sql = "UPDATE craftedinventory SET treatedwoodenpole = ? WHERE craftedinventoryID = ?;";	
				i = c.getTreatedwoodenpole()+1;
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
			statement.setInt(++count, userID);
			//statement = conn.prepareStatement(statement.toString());
			statement.execute();
			return true;

		}catch(SQLException e) {
			//e.printStackTrace();
			System.out.println("Some input was invalid.");
		}
		
		
		
		
		return false;
	}
	
	public boolean addCrafted() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
					
					String sql = "INSERT INTO craftedinventory (ironwarhammer) VALUES (0)";
									
					PreparedStatement statement = conn.prepareStatement(sql);			
					statement.execute();
					
					return true;
		
				}catch(SQLException e) {
					//e.printStackTrace();
					System.out.println("Some input was invalid.");
				}
				return false;
		}

	
	
}
