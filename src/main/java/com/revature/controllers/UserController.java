package com.revature.controllers;

//import java.util.LinkedList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.Component;
import com.revature.models.Crafted;
import com.revature.models.UserModel;
import com.revature.services.ComponentService;
import com.revature.services.CraftedService;
import com.revature.services.UserService;
import com.revature.utils.Encrypt;

public class UserController {
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	String loginID;
	//LinkedList<Integer> password = new LinkedList<Integer>();
	String password;
	int userType = 0;
	Scanner sc = new Scanner(System.in);
	String input = " ";
	ComponentController components = new ComponentController();
	CraftedController crafted = new CraftedController();
	MenuController menu = new MenuController();
	Encrypt encryptor = new Encrypt();
	
	
	
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
		log.info("User input in UserController:"+loginID);
		System.out.println("Thanks, username accepted. Please enter a password:");
		String password = sc.nextLine();
		log.info("User input in UserController:"+password);
		password = encryptor.encrypt(password);
	
		UserModel user = new UserModel(loginID, password, userType);	
			
		if(UserService.newUser(user)){
			
			
			System.out.println("New account created!");
				
			return (user); 
			
			
		}else {
			System.out.println("Something went wrong. We could not get you registered. Please try again.");
			return null;
		}
		
	}
	
	public void runUser(UserModel user){
		System.out.println("You can deposit resources, withdraw resources, check your inventory,\nsee what you can make with your current inventory or check your crafting history.");
		System.out.println("To deposit, type deposit.\nTo withdraw, type withdraw.\nTo check your inventory, type inventory.\nTo see what you can craft, type craft.\nTo check your history, type history.\nTo exit the bank, type exit.");
		
		while(!(input.equalsIgnoreCase("exit"))){
			input = sc.nextLine();
			log.info("User input in UserController:"+input);
			if(input.equalsIgnoreCase("exit")) {
				break;
			}else if(input.equalsIgnoreCase("deposit")){
				
				System.out.println("What would you like to deposit?\nYou can deposit timber, coarse leather, linen,\n iron ingots, greenwood, iron ore, rawhide or fibers.");
				input= sc.nextLine();
				log.info("User input in UserController:"+input);
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
				
				System.out.println("What would you like to withdraw?\nYou can withdraw timber, coarse leather, linen,\n iron ingots, greenwood, iron ore, rawhide or fibers.");
				input= sc.nextLine();
				log.info("User input in UserController:"+input);
				
				if(components.withdraw(input, user)) {
					System.out.println("Your withdrawal was successful!");
					
				}else{
					System.out.println("Sorry, your withdrawal failed. Please try again.");
				}
				
			}else if(input.equalsIgnoreCase("history")){
				
				Crafted cr = new Crafted();
				cr= CraftedService.findByID(user.getUserID());
				System.out.println(crafted.getHistory(cr));
				
			}else{
			
				System.out.println("\""+input+"\" was not understood.\nPlease type deposit, withdraw, inventory, or craft.");
				
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
			log.info("User input in UserController:"+pass);
			if(UserService.checkPass(pass, user)) {
				if(user.getUserType()==2) {
					
				}
				
				runUser(user);
				return true;
			}
			System.out.println("Password incorrect. Please enter your username again.");
		}
		
		return false;
	}

}
