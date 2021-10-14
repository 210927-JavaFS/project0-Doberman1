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
				
				System.out.println("If you'd like to craft this item, type its name.");
				input = sc.nextLine();
				input2 = StringUtil.cleanString(input);
				if(CraftedService.updateCrafted(input2, userID)) {
					System.out.println("You've successfully added your "+input+" to your history!");
				}else {
					
					System.out.println("Sorry, "+input+" was not understood. Returning to menu.");
				}
				
			}else {
				System.out.println("If you'd like to craft one of these items, type its name.");
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
		String s = "So far, you've crafted:\n ";
		
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getlinenleggings()>0){
			s=s+c.getlinenleggings()+" linen leggings\n";	
		}
		if(c.getlinenbonnet()>0){
			s=s+c.getlinenbonnet()+" linen bonnet\n";	
		}
		if(c.getlinenshoes()>0){
			s=s+c.getlinenshoes()+" linen shoes\n";	
		}
		if(c.getlinenhat()>0){
			s=s+c.getlinenhat()+" linen hat\n";	
		}
		if(c.getlinenhandwraps()>0){
			s=s+c.getlinenhandwraps()+" linen handwraps\n";	
		}
		if(c.getlinenshirt()>0){
			s=s+c.getlinenshirt()+" linen shirt\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		if(c.getCoarseleatherboots()>0){
			s=s+c.getCoarseleatherboots()+" coarse leather boots\n";	
		}
		
		return s;
	}
	

}
