package com.revature;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controllers.MenuController;


public class Main {

	private static Logger log = LoggerFactory.getLogger(Main.class);
	private static MenuController menuController = new MenuController();
	
	public static void main(String[] args){
		
		log.info("=========New Run Through The APP=============");
		
		menuController.goMenu();
	}
}
