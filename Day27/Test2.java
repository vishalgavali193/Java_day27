package com.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dypdb", "root", "root");
	
	Statement st = con.createStatement();
	
	String qry = " insert into students(name, course, marks) values('Ramesh', 'BTech', 78)";
	
	int result = st.executeUpdate(qry);
	if(result > 0) {
		System.out.println(result +" no of rows inserted...");
	}
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
