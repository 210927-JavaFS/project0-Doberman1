package com.revature;

import java.util.LinkedList;
import java.util.Scanner;

public class User {
	
	String loginID;
	LinkedList<Integer> password = new LinkedList<Integer>();
	int ID;
	Scanner sc = new Scanner(System.in);
	String input = " ";
	Inventory userInventory = new Inventory();	
	
	public User() {
		
		
	}
	
	public User(int i) {
		ID = i;
				
	}
	
	
	public void setLogin(String s) {
		loginID = s; 
		
	}
	
	public void setPassword(String s) {
		
		Encrypt encryptor = new Encrypt();
		password = encryptor.encrypt(s);
				
	}
	
	public void runUser(){
		System.out.println("You can deposit resources, check your inventory,\nor see what you can make with your current inventory.");
		System.out.println("To deposit, type deposit.\nTo check your inventory, type inventory.\nTo see what you can craft, type craft.\nTo exit the bank, type exit.");
		
		while(!(input.equalsIgnoreCase("exit"))){
			input = sc.nextLine();
			if(input.equalsIgnoreCase("exit")) {
				break;	
			}else if(input.equalsIgnoreCase("deposit")) {
				userInventory.checkInventory();
				
			}else if(input.equalsIgnoreCase("inventory")) {
				userInventory.checkInventory();
						
			}else if(input.equalsIgnoreCase("craft")) {
				userInventory.checkCraft();
				
			}else{
				System.out.println("\""+input+"\" was not understood.\nPlease type deposit, inventory, or craft.");
				
			}
					
			
		}
		System.out.println("Goodbye!");
		
	}
	
	

}
