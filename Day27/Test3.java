package com.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dypdb", "root", "root");
	
	String qry = "insert into students(name, course, marks) values(?, ?, ?)";
	
	PreparedStatement pst = con.prepareStatement(qry);
	Scanner sc = new Scanner(System.in);
	String nm = sc.next(); 	sc.nextLine();
	String cs = sc.next();	sc.nextLine();
	float mk = sc.nextFloat();
	pst.setString(1, nm);
	pst.setString(2, cs);
	pst.setFloat(3, mk);
	int res = pst.executeUpdate();
	if(res > 0)
		System.out.println(res +" row/s inserted...");

} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
