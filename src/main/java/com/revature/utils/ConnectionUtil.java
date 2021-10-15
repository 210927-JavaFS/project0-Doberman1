package com.revature.utils;


import java.sql.*;

public class ConnectionUtil {

	public static Connection getConnection() throws SQLException {
	
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("Trouble connecting to the database.");
		}
		
		String url = "jdbc:postgresql://mydatabaseinstance.czhcyr5nyzgr.us-east-2.rds.amazonaws.com:5432/mydatabase";
		String username = "postgres";
		String password = "pastword"; 
		
		return DriverManager.getConnection(url, username, password);
	}
	
}
