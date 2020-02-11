package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
// SOLID : Single responsibility principle
	
	public static Connection getOracleConnection() {
		
		Connection connection=null;
		try {
		//Translator
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		 
		// Road between application and db
		connection=DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","gg");  
		  
		System.out.println("Connection Established...");
		}catch (Exception e) {
			// TODO: handle exception
		}
		return connection;
		
	}
}
