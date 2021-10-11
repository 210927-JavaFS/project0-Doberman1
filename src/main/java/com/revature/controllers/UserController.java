package com.revature.controllers;

//import java.util.LinkedList;
import java.util.Scanner;

import com.revature.Inventory;
import com.revature.models.UserModel;
import com.revature.services.UserService;
import com.revature.utils.Encrypt;

public class UserController {
	
	String loginID;
	//LinkedList<Integer> password = new LinkedList<Integer>();
	String password = new String();
	int userType = 0;
	Scanner sc = new Scanner(System.in);
	String input = " ";
	Inventory userInventory = new Inventory();
	
	
	public UserController() {
		
		
	}
	
	
	public void setLogin(String s) {
		loginID = s; 
		
	}
	
	public void setPassword(String s) {
		
		Encrypt encryptor = new Encrypt();
		password = encryptor.encrypt(s);
				
	}
	
	public void newUser() {
		
		System.out.println("Please enter a username:");
		String loginID = sc.nextLine();
		System.out.println("Thanks, username accepted. Please enter a password:");
		String password = sc.nextLine();
	
		UserModel user = new UserModel(loginID, password, userType);
			
		if(UserService.newUser(user)){
			//did a hotfix here that may cause the incorrect boolean here later changes shown in userService
			System.out.println("New account created!");
		}else {
			System.out.println("Something went wrong. We could not get you registered. Please try again.");
		}
		
	}
	
	public void runUser(){
		System.out.println("You can deposit resources, withdraw resources, check your inventory,\nor see what you can make with your current inventory.");
		System.out.println("To deposit, type deposit.\nTo withdraw, type withdraw.\nTo check your inventory, type inventory.\nTo see what you can craft, type craft.\nTo exit the bank, type exit.");
		
		while(!(input.equalsIgnoreCase("exit"))){
			input = sc.nextLine();
			if(input.equalsIgnoreCase("exit")) {
				break;	
			}else if(input.equalsIgnoreCase("deposit")) {
				userInventory.deposit();
				
			}else if(input.equalsIgnoreCase("inventory")) {
				userInventory.checkInventory();
						
			}else if(input.equalsIgnoreCase("craft")) {
				userInventory.checkCraft();
				
			}else if(input.equalsIgnoreCase("withdraw")){
				userInventory.withdraw();
				
			}else{
				System.out.println("\""+input+"\" was not understood.\nPlease type deposit, inventory, or craft.");
				
			}
					
			
		}
		System.out.println("Goodbye!");
		
	}

}
