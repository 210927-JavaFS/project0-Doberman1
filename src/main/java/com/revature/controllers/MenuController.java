package com.revature.controllers;

import java.util.Scanner;

public class MenuController {

	private static Scanner sc = new Scanner(System.in);
	private static UserController userController = new UserController();
	
	
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
			else if(input1.equalsIgnoreCase("new")){
				
				userController.runUser(userController.newUser());
				break;
				
			}//else if(user name and password entered//){}
			else{
				
				System.out.println("Sorry, that's an invalid username.");
			}
			
		}
		
		System.out.println("Goodbye!");
			
		sc.close();
	}


}
	
