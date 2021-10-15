package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuController {
	

	private static Scanner sc = new Scanner(System.in);
	private static UserController userController = new UserController();
	private static AdminController adminController = new AdminController();
	private static Logger log = LoggerFactory.getLogger(MenuController.class);
	
	
	public void goMenu() {
		System.out.println("Welcome to the New World Crafting Bank!\n");
		System.out.println("Please login or create a new account.\nTo login, enter username and then password.\nTo create a new account, enter new.");
		
		String input1 = " ";	
	
		while(!(input1.equalsIgnoreCase("exit"))) {
			
			input1 = sc.nextLine();
			log.info("User input in goMenu():"+input1);
		
			if(input1.equalsIgnoreCase("exit")) {
				break;	
				
			}
			else if(input1.equalsIgnoreCase("new")){
				
				userController.runUser(userController.newUser());
				break;
				
			}
			else if(input1.equalsIgnoreCase("Administrator")) {
				
				System.out.println("Password?");
				input1 = sc.nextLine();
				log.info("User input in goMenu():"+input1);
				
				if(input1.equals("helloTim")) {
					
					adminController.runUser(adminController.newUser());
					break;
				}
				System.out.println("Wrong password.");
				System.out.println("Please login or create a new account.\nTo login, enter username and then password.\nTo create a new account, enter new.");
			}
			else{
				
				if(adminController.login(input1)) {
					break;
				}
				
			}
			
		}
		
		System.out.println("Goodbye!");
			
		sc.close();
	}


}
	
