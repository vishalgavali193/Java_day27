package com.examples;

public class Test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Student st = new Student("Rahul", "mbbs", 89);
StudentDAO sd = new StudentDAO();
sd.store(st);
sd.retrieveById(2);

	}

}
