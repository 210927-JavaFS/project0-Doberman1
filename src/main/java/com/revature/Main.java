package com.revature;


import com.revature.controllers.MenuController;


public class Main {

	private static MenuController menuController = new MenuController();
	
	public static void main(String[] args){
		
		menuController.goMenu();
	}
}
