package com.revature.controllers;

//import java.util.LinkedList;
import java.util.Scanner;

import com.revature.Inventory;
import com.revature.models.UserModel;
import com.revature.services.ComponentService;
import com.revature.services.CraftedService;
import com.revature.services.UserService;
import com.revature.utils.Encrypt;

public class UserController {
	
	String loginID;
	//LinkedList<Integer> password = new LinkedList<Integer>();
	String password;
	int userType = 0;
	Scanner sc = new Scanner(System.in);
	String input = " ";
	Inventory userInventory = new Inventory();
	ComponentController components = new ComponentController();
	
	
	
	public UserController() {
		
		
	}
	
	
	public void setLogin(String s) {
		loginID = s; 
		
	}
	
	public void setPassword(String s) {
		
		Encrypt encryptor = new Encrypt();
		password = encryptor.encrypt(s);
				
	}
	
	public UserModel newUser() {
		
		System.out.println("Please enter a username:");
		String loginID = sc.nextLine();
		System.out.println("Thanks, username accepted. Please enter a password:");
		String password = sc.nextLine();
	
		UserModel user = new UserModel(loginID, password, userType);	
			
		if(UserService.newUser(user) && ComponentService.addComponent() && CraftedService.addCrafted()){
			//did a hotfix here that may cause the incorrect boolean here later changes shown in userService
			
			
			System.out.println("New account created!");
				
			return (user); 
			
			
		}else {
			System.out.println("Something went wrong. We could not get you registered. Please try again.");
			return null;
		}
		
	}
	
	public void runUser(UserModel user){
		System.out.println("You can deposit resources, withdraw resources, check your inventory,\nor see what you can make with your current inventory.");
		System.out.println("To deposit, type deposit.\nTo withdraw, type withdraw.\nTo check your inventory, type inventory.\nTo see what you can craft, type craft.\nTo exit the bank, type exit.");
		
		while(!(input.equalsIgnoreCase("exit"))){
			input = sc.nextLine();
			if(input.equalsIgnoreCase("exit")) {
				break;
			}else if(input.equalsIgnoreCase("deposit")){
				
				System.out.println("What would you like to deposit?\nYou can deposit timber, coarse leather, linen,\n iron ingots, greenwood, iron ore, rawhide or fibers.");
				input= sc.nextLine();
				if(components.deposit(input, user)) {
					System.out.println("Your deposit was successful!");
					
				}else {
					System.out.println("Sorry, your deposit failed. Please try again.");
				}
				
			}else if(input.equalsIgnoreCase("inventory")) {
				userInventory.checkInventory();
						
			}else if(input.equalsIgnoreCase("craft")) {
				userInventory.checkCraft();
				
			}else if(input.equalsIgnoreCase("withdraw")){
				userInventory.withdraw();
				
			}else{
				System.out.println("\""+input+"\" was not understood.\nPlease type deposit, withdraw, inventory, or craft.");
				
			}				
			
		}
		
	}

}
