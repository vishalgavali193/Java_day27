package com.examples;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	PreparedStatement pst;
	ResultSet rs;
	
	void store(Student st) {
		String qry = "insert into students(name, course, marks) values(?, ?, ?)";
		
		try {
			pst = DBUtil.getCon().prepareStatement(qry);
			pst.setString(1, st.getName());
			pst.setString(2, st.getCourse());
			pst.setFloat(3, st.getMarks());
			
			pst.executeUpdate();
			System.out.println("student inserted...");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void update(String course, float marks, int i) {}
	
	void delete(int i) {}
	
	void retrieveById(int i) {
		String qry = "select * from students where id = ?";
		try {
			pst = DBUtil.getCon().prepareStatement(qry);
			pst.setInt(1, i);
			rs = pst.executeQuery();
			System.out.println("ID \t NAME \t COURSE \t MARKS");
			if(rs.next()) {
				System.out.println(rs.getInt("id") + "\t"+ rs.getString("name")
				+ "\t"+ rs.getString("course")+"\t" + rs.getFloat("marks"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void retrieveAll() {}
	
	
}
