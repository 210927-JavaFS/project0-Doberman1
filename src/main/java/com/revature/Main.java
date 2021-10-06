package com.revature;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		
		System.out.println("Welcome to the New World Crafting Bank!\n");
		System.out.println("Please login or create a new account.\nTo login, enter username and then password.\nTo create a new account, enter new.");

		Logger log = LoggerFactory.getLogger(Main.class);
		Scanner sc = new Scanner(System.in);
		String input1 = " ";
		
		log.info("Log test");
		
		
		int uniqueIdentifier = -1;

		while(!(input1.equalsIgnoreCase("exit"))) {
			
			input1 = sc.nextLine();
		
			if(input1.equalsIgnoreCase("exit")) {
				break;	
				
			}
			else if(input1.equalsIgnoreCase("new")) {
				uniqueIdentifier++; 
				System.out.println("Please enter a username:");
				User user1 = new User(uniqueIdentifier);
				user1.setLogin(sc.nextLine());
				System.out.println("Thanks, username accepted. Please enter a password:");
				user1.setPassword(sc.nextLine());
				System.out.println("New account created!");
				user1.runUser();
			}//else if(user name and password entered//){}
			else{
				
				System.out.println("Sorry, that's an invalid username.");
			}
			
		}
		
		System.out.println("Goodbye!");
			
		sc.close();
	}

}
