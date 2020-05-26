package com.ConnectionFactroy;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static Connection con;
static {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/taskdb", "root", "");
		System.out.println("Connected");
	}catch(Exception e) {
		e.getMessage();
	}
}
public static Connection getConnection() {
	// TODO Auto-generated method stub
	return con;
}
}
