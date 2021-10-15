package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Component;
import com.revature.models.Crafted;
import com.revature.models.Requirements;
import com.revature.services.ComponentService;
import com.revature.services.CraftedService;
import com.revature.services.RequirementsService;
import com.revature.utils.StringUtil;

public class CraftedController {

	
	public void craft(int userID) {
		
		
		List<Requirements> requirements = new ArrayList<>();
		requirements =RequirementsService.findAllRequirements();
		Component c = new Component();
		c= ComponentService.findByID(userID);
		int count = 0;
		Scanner sc = new Scanner(System.in);
		String input = " ";
		String input2 = " ";
		
		
		for(Requirements r : requirements) {
			
			
			if(r.getTimber()<=c.getTimber() && r.getCoarseleather()<=c.getCoarseleather() &&
				r.getLinen()<=c.getLinen() && r.getIroningot()<=c.getIroningot() &&
				r.getGreenwood()<=c.getGreenwood() && r.getIronore()<=c.getIronore() &&
				r.getRawhide()<=c.getRawhide() && r.getFibers()<=c.getFibers()){
				
				
				
				if(r.getGoodname().startsWith("a") || 
						r.getGoodname().startsWith("e")||
						r.getGoodname().startsWith("i")||
						r.getGoodname().startsWith("o")||
						r.getGoodname().startsWith("u")){
					
				System.out.println("You can craft an "+r.getGoodname());
				}else {
					System.out.println("You can craft a "+r.getGoodname());
				}
			}else{
				count++;
					
				}
			
			
			
		}
		
		if(count == 37) {
			System.out.println("It looks like you can't craft anything with what you currently have in the bank.");
			}else if(count == 36){
				
				System.out.println("If you'd like to craft this item, type its name. Otherwise, just type menu.");
				input = sc.nextLine();
				input2 = StringUtil.cleanString(input);
				if(CraftedService.updateCrafted(input2, userID)) {
					System.out.println("You've successfully added your "+input+" to your history!");
				}else if(input.equalsIgnoreCase("menu")){
					
					System.out.println("Returning to menu.");
				}else {
					
					System.out.println("Sorry, "+input+" was not understood. Returning to menu.");
				}
				
			}else {
				System.out.println("If you'd like to craft one of these items, type its name. Otherwise, just type menu.");
				input = sc.nextLine();
				input2 = StringUtil.cleanString(input);
				if(CraftedService.updateCrafted(input2, userID)) {
					System.out.println("You've successfully added your "+input+" to your history!");
				}else {
					
					System.out.println("Sorry, "+input+" was not understood. Returning to menu.");
				}
			}
	}
	
	public String getHistory(Crafted c) {
		String s = "So far, you've crafted:\n";
		
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getLinenleggings()>0){
			s=s+c.getLinenleggings()+" linen leggings\n";	
		}
		if(c.getLinenbonnet()>0){
			s=s+c.getLinenbonnet()+" linen bonnet\n";	
		}
		if(c.getLinenshoes()>0){
			s=s+c.getLinenshoes()+" linen shoes\n";	
		}
		if(c.getLinenhat()>0){
			s=s+c.getLinenhat()+" linen hat\n";	
		}
		if(c.getLinenhandwraps()>0){
			s=s+c.getLinenhandwraps()+" linen handwraps\n";	
		}
		if(c.getLinenshirt()>0){
			s=s+c.getLinenshirt()+" linen shirt\n";	
		}
		if(c.getLinenpants()>0){
			s=s+c.getLinenpants()+" linen pants\n";	
		}
		if(c.getLinendress()>0){
			s=s+c.getLinendress()+" linen dress\n";	
		}
		if(c.getLinengloves()>0){
			s=s+c.getLinengloves()+" linen gloves\n";	
		}
		if(c.getCoarseleathergloves()>0){
			s=s+c.getCoarseleathergloves()+" coarse leather gloves\n";	
		}
		if(c.getCoarseleatherpants()>0){
			s=s+c.getCoarseleatherpants()+" coarse leather pants\n";	
		}
		if(c.getCoarseleathershirt()>0){
			s=s+c.getCoarseleathershirt()+" coarse leather shirt\n";	
		}
		if(c.getCoarseleatherhat()>0){
			s=s+c.getCoarseleatherhat()+" coarse leather hat\n";	
		}
		if(c.getIrongreataxe()>0){
			s=s+c.getIrongreataxe()+" iron greataxe\n";	
		}
		if(c.getIronwarhammer()>0){
			s=s+c.getIronwarhammer()+" iron warhammer\n";	
		}
		if(c.getIronspear()>0){
			s=s+c.getIronspear()+" iron spear\n";	
		}
		if(c.getIronrapier()>0){
			s=s+c.getIronrapier()+" iron rapier\n";	
		}
		if(c.getIronhatchet()>0){
			s=s+c.getIronhatchet()+" iron hatchet\n";	
		}
		if(c.getIronroundshield()>0){
			s=s+c.getIronroundshield()+" iron roundshield\n";	
		}
		if(c.getIronlongsword()>0){
			s=s+c.getIronlongsword()+" iron longsword\n";	
		}
		if(c.getIronplategreaves()>0){
			s=s+c.getIronplategreaves()+" ironplate greaves\n";	
		}
		if(c.getIronplatehelmet()>0){
			s=s+c.getIronplatehelmet()+" ironplate helmet\n";	
		}
		if(c.getIronplateboots()>0){
			s=s+c.getIronplateboots()+" ironplate boots\n";	
		}
		if(c.getIronplatebreastplate()>0){
			s=s+c.getIronplatebreastplate()+" ironplate breastplate\n";	
		}
		if(c.getIronplategauntlets()>0){
			s=s+c.getIronplategauntlets()+" ironplate gauntlets\n";	
		}
		if(c.getIronmusket()>0){
			s=s+c.getIronmusket()+" iron musket\n";	
		}
		if(c.getTreatedwoodenbow()>0){
			s=s+c.getTreatedwoodenbow()+" treated wooden bow\n";	
		}
		if(c.getIronskinningknife()>0){
			s=s+c.getIronskinningknife()+" iron skinning knife\n";	
		}
		if(c.getIronloggingaxe()>0){
			s=s+c.getIronloggingaxe()+" iron logging axe\n";	
		}
		if(c.getIronminingpickaxe()>0){
			s=s+c.getIronminingpickaxe()+" iron mining pickaxe\n";	
		}
		if(c.getIronharvestingsickle()>0){
			s=s+c.getIronharvestingsickle()+" iron harvesting sickle\n";	
		}
		if(c.getTreatedwoodenpole()>0){
			s=s+c.getTreatedwoodenpole()+" treated wooden pole\n";	
		}
		
		return s;
	}
	

}
