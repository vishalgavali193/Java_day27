package com.examples;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1 - load driver -- com.mysql.cj.jdbc.Driver.class
		try {
		Class.forName(" driverClassPath");
		}
		catch(ClassNotFoundException c) {}
		
		
		//public static void forName(String name) throws ClassNotFoundException{
	//body	
	//}
	//	com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		//2- establish connection
		DriverManager.getConnection(String url);
		DriverManager.getConnection(String url, String unm, String pwd)
		DriverManager.getConnection(String url, Properties props);
		
		// public static Connection getConnection(..) throws SQLException{}
		
		Connection con = DriverManager.getConnection(url, pwd, Properties);
		//3- create statement
		Statement - static sql queries
		PrepareStatement- dynamic queries
		CallableStatement- stored procedure & functions
		
		Connection<interface> - createStatement()
				preapareStatement(String sql)
				callableStatement()
		
		//4- execute and manage result
				executeQuery() : ResultSet  ResultSetMetadata
				executeUpdate() : int
				execute() : boolean
				
		//5 - handle exception
		
		
		
		
	}

}
