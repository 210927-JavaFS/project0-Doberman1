package com.revature.controllers;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.Main;
import com.revature.controllers.UserController;

public class MenuController {

	Scanner sc = new Scanner(System.in);
	
	public void goMenu() {
		System.out.println("Welcome to the New World Crafting Bank!\n");
		System.out.println("Please login or create a new account.\nTo login, enter username and then password.\nTo create a new account, enter new.");
	
		//Logger log = LoggerFactory.getLogger(Main.class);
		
		String input1 = " ";
		
		/* FileHandler fh = new FileHandler("");  
	    log.addHandler(fh);
	    SimpleFormatter formatter = new SimpleFormatter();  
	    fh.setFormatter(formatter);
	    */
	
		//log.info("Log test");
		
		
	
		while(!(input1.equalsIgnoreCase("exit"))) {
			
			input1 = sc.nextLine();
		
			if(input1.equalsIgnoreCase("exit")) {
				break;	
				
			}
			else if(input1.equalsIgnoreCase("new")) {
				 
				System.out.println("Please enter a username:");
				UserController user1 = new UserController();
				user1.setLogin(sc.nextLine());
				System.out.println("Thanks, username accepted. Please enter a password:");
				user1.setPassword(sc.nextLine());
				System.out.println("New account created!");
				user1.newUser();
			}//else if(user name and password entered//){}
			else{
				
				System.out.println("Sorry, that's an invalid username.");
			}
			
		}
		
		System.out.println("Goodbye!");
			
		sc.close();
	}


}
	
