package com.revature.utils;

public class StringUtil {

	public static String cleanString(String s) {
		
		s=s.replaceAll("\\s", "");
		s=s.toLowerCase();
		
		return s;
	}
	
	public static String cleanInt(String s) {
		
		s=s.replaceAll(",", "");
		s=s.replaceAll(".", "");
		s=s.replaceAll("\\s", "");
		
		return s;
	}
	
}
