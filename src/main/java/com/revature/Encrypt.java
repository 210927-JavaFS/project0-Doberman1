package com.revature;

import java.util.LinkedList;

public class Encrypt {

	private LinkedList<Integer> newpassword = new LinkedList<Integer>();
	private int counter = 0;
	
	public Encrypt() {
		
		
	}
	
	
	public LinkedList<Integer> encrypt(String s) {
		
		for(char i: s.toCharArray()) {
			
			switch (counter){
			case 0: newpassword.add((i+5)*868);
				break;
			case 1:	newpassword.add((i-3)*122);
				break;
			case 2:	newpassword.add((i+123)*37);	
				break;
			default: newpassword.add((i-14)*-77);
				break;
			}
			
			counter++;
			if(counter>3) {
				
				counter =0;
			}
			
		}
		
		return newpassword;
	}
	
}
