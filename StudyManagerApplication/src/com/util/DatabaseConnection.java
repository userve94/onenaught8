package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static Connection getConnection() throws SQLException{
		
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","gg");
		System.out.println("Connection Established...");
		return connection;
	}

}
