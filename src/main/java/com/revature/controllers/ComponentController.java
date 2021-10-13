package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.UserModel;
import com.revature.services.ComponentService;
import com.revature.utils.StringUtil;


public class ComponentController {
	
	int amount;
	Scanner sc = new Scanner(System.in);
	String input;
	UserModel user;
	
	public boolean deposit(String item, UserModel user) {
		
		item = StringUtil.cleanString(item);
		
	System.out.println("How much would you like to deposit?");	
	
		input = sc.nextLine();
		if(input.contains(".*\\d.*")){
			
			input = StringUtil.cleanString(input);
			
			try{
	             amount = Integer.parseInt(input);
	        }
	        catch (NumberFormatException ex){
	            System.out.println("Please only enter a number.");
	            deposit(item, user);
	        }
			
			if(ComponentService.updateComponent(item, amount, user)) {
				
				return true;
				
			}
			
		}
			
		
		return false;
			
	}
	

}
