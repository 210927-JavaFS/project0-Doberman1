package com.revature.controllers;

import com.revature.models.Component;
import com.revature.models.Crafted;
import com.revature.models.Requirements;
import com.revature.models.UserModel;
import com.revature.services.ComponentService;
import com.revature.services.CraftedService;
import com.revature.services.RequirementsService;
import com.revature.services.UserService;
import com.revature.utils.StringUtil;

public class AdminController extends ContributorController{

	int userType = 2;
	
public UserModel newUser() {
		
		System.out.println("Please enter a username:");
		String loginID = sc.nextLine();
		System.out.println("Thanks, username accepted. Please enter a password:");
		String password = sc.nextLine();
		password = encryptor.encrypt(password);
	
		UserModel user = new UserModel(loginID, password, userType);	
			
		if(UserService.newUser(user)){// && ComponentService.addComponent() && CraftedService.addCrafted()){
			//did a hotfix here that may cause the incorrect boolean here later changes shown in userService
			
			
			System.out.println("New account created!");
				
			return (user); 
			
			
		}else {
			System.out.println("Something went wrong. We could not get you registered. Please try again.");
			return null;
		}
		
	}
	
public void runAdmin(UserModel user){
	//System.out.println("You can deposit resources, withdraw resources, check your inventory,\nsee what you can make with your current inventory or check your crafting history.");
	System.out.println("Hello administrator! You have access to all the commands of regular users, and");
	System.out.println("you can check items' crafting requirements,\nupdate items' crafting requirements,\nsee all users' info and inventories\nor change users' account types.");
	System.out.println("To check all crafting requirements, type requirements.\nTo update items' requirements, type update.\nTo See all user account information, type big brother.\nTo see all inventories, type capitalism.\nTo change a user's type of account, type daddy.");
	
	
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
			
		}else if(input.equalsIgnoreCase("update")){
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
			
		}else if(input.equalsIgnoreCase("bigbrother")||input.equalsIgnoreCase("big brother")){
			
			for(UserModel i : UserService.findAllUsers()) {
			System.out.println(i);
			}
			
		}else if(input.equalsIgnoreCase("capitalism")){
			
			for(Component i : ComponentService.findAllComponents()) {
				System.out.println(i);
				}
			
		}else if(input.equalsIgnoreCase("daddy")){
			String name = "";
			int type = 0;
			
			System.out.println("Accounts with type 0 are regular users.\nAccounts with type 1 are contributors.\nAccounts with type 2 are administrators.");
			System.out.println("Please enter the username of the account you'd like to change.");
			name = sc.nextLine();
			System.out.println("Please enter the type of the account you're changing them to (0, 1 or 2).");
			try {
			type = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException ex){
				System.out.println("Please only enter 0, 1 or 2.");
				
			}
			
			if(type>=0 && type <= 2) {
				UserService.changeType(name, type);
				
				if(!(UserService.findByName(name).getUserID()==0)) {
					if(type==1) {
					System.out.println("You've successfully changed the account type of "+name+" to a contributor.");
					}else if(type ==2) {
						System.out.println("You've successfully changed the account type of "+name+" to an administrator.");	
					}else {
						System.out.println("You've successfully changed the account type of "+name+" to a regular user.");
					}
				}else {
					
					System.out.println(""+name+" is not a recoreded username. Please try again.");
					
				}
			}else {
				System.out.println("Please only enter 0, 1 or 2.");
				
			}
		}else if(input.equalsIgnoreCase("requirements")) {
			
			for(Requirements i : RequirementsService.findAllRequirements()) {
				System.out.println(i);
				}
			
		}
		else{
		
			System.out.println("\""+input+"\" was not understood.\nPlease type deposit, withdraw, inventory, craft, update, big brother, capitalism or daddy.");
			
		}				
		
	}
	
	
	
}

	public boolean login(String username) {
		UserModel user = UserService.findByName(username);
		if(user.getUserID() == 0) {
		System.out.println("Sorry, that username is invalid. Please Try again.");
		return false;
		}else{
			System.out.println("Please enter your password.");
			String pass = sc.nextLine();
			if(UserService.checkPass(pass, user)) {
				if(user.getUserType()==2) {
					runAdmin(user);
					return true;
				}else if(user.getUserType()==1) {
					
					runContributor(user);
					return true;
				}else {
					runUser(user);
					return true;
					
				}
				
			}
			System.out.println("Password incorrect. Please enter your username again.");
		}
		
		return false;
}


}
