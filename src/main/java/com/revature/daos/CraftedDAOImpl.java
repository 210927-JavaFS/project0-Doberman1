package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Crafted;
import com.revature.utils.ConnectionUtil;

public class CraftedDAOImpl implements CraftedDAO{

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
			e.printStackTrace();
		}
		return null;
	}

	
	public boolean updateCrafted(Crafted crafted) {
		
		return false;
	}
	
	public boolean addCrafted() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
					
					String sql = "INSERT INTO craftedinventory (ironwarhammer) VALUES (0)";
									
					PreparedStatement statement = conn.prepareStatement(sql);			
					statement.execute();
					
					return true;
		
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return false;
		}

	
	
}
