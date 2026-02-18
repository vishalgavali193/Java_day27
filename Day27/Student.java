package com.examples;

public class Student {

	int id;
	String name, course;
	float marks;
	public Student(String name, String course, float marks) {
		super();
		this.name = name;
		this.course = course;
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCourse() {
		return course;
	}
	public float getMarks() {
		return marks;
	}
	
	
	
}
