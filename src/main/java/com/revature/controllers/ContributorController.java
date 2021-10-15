package com.revature.controllers;

import com.revature.models.Component;
import com.revature.models.Crafted;
import com.revature.models.Requirements;
import com.revature.models.UserModel;
import com.revature.services.ComponentService;
import com.revature.services.CraftedService;
import com.revature.services.RequirementsService;
import com.revature.utils.StringUtil;

public class ContributorController extends UserController{
	int userType = 1;
	
	
	public void runContributor(UserModel user){
		System.out.println("You can deposit resources, withdraw resources, check your inventory,\nsee what you can make with your current inventory or check your crafting history.");
		System.out.println("To deposit, type deposit.\nTo withdraw, type withdraw.\nTo check your inventory, type inventory.\nTo see what you can craft, type craft.\nTo check your history, type history.\nTo exit the bank, type exit.");
		System.out.println("As a contributor, you can also check items' crafting requirements. To do this, type requirements.");
		System.out.println("Lastly, you can update items' crafting requirements. To do this, type update.");
		
		while(!(input.equalsIgnoreCase("exit"))){
			input = sc.nextLine();
			if(input.equalsIgnoreCase("exit")) {
				break;
			}else if(input.equalsIgnoreCase("deposit")){
				
				System.out.println("What would you like to deposit?\nYou can deposit timber, coarse leather, linen,\n iron ingots, greenwood, iron ore, rawhide or fibers.");
				input= sc.nextLine();
				if(components.deposit(input, user)) {
					System.out.println("Your deposit was successful!");
					
				}else{
					System.out.println("Sorry, your deposit failed. Please try again.");
				}
				
			}else if(input.equalsIgnoreCase("inventory")) {
				Component c = new Component();
				c = ComponentService.findByID(user.getUserID());
				
				String s = "Your component inventory includes:\n"+c.getCoarseleather()+" coarse leather\n"+c.getFibers()+" fiber\n"+c.getGreenwood()+" greenwood\n"+c.getIroningot()+" iron ingots\n"+c.getIronore()+" iron ore\n"+c.getLinen()+" linen\n"+c.getRawhide()+" raw hide\n"+c.getTimber()+" timber";

				System.out.println(s);
				
						
			}else if(input.equalsIgnoreCase("craft")) {
				crafted.craft(user.getUserID());
				
			}else if(input.equalsIgnoreCase("withdraw")){
				
				System.out.println("What would you like to withdraw?\nYou can withdraw timber, coarse leather, linen,\n iron ingots, greenwood, iron ore, rawhide, fibers\n or anything you've crafted.");
				input= sc.nextLine();
				
				if(components.withdraw(input, user)) {
					System.out.println("Your withdrawal was successful!");
					
				}else{
					System.out.println("Sorry, your withdrawal failed. Please try again.");
				}
				
			}else if(input.equalsIgnoreCase("history")){
				
				Crafted cr = new Crafted();
				cr= CraftedService.findByID(user.getUserID());
				System.out.println(crafted.getHistory(cr));
				
			}else if(input.equalsIgnoreCase("update")) {
				System.out.println("What item's crafting requirements would you like to update?");
				String input = sc.nextLine();
				System.out.println("Please go through the update wizard:.");
				String s = input;
				s = StringUtil.cleanString(s);
				if(RequirementsService.updateRequirements(s)) {
					System.out.println("You successfully updated the requirements for "+input+".");
					
				}else {
					System.out.println("Unfortunately, your update to "+input+" has failed. Returning to menu.");
					
				}
			}else if(input.equalsIgnoreCase("requirements")) {
				
				for(Requirements i : RequirementsService.findAllRequirements()) {
					System.out.println(i);
					}
				
			}
			else{
			
				System.out.println("\""+input+"\" was not understood.\nPlease type deposit, withdraw, inventory, craft or update.");
				
			}				
			
		}
		
	}
	
	
}
