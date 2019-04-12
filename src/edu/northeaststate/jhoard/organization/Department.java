package edu.northeaststate.jhoard.organization;
/**
 * -------------------------------------------------
 * File name: CollegeDriver.java
 * Project name: Project 6
 * -------------------------------------------------
 * Creator's name: Jacob Hoard
 * Email: jhoard1@northeaststate.edu
 * Course and section: CISP 1020 A01
 * Creation date: Apr 2, 2019
 * -------------------------------------------------
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable
{
	private String name;
	private ArrayList<Course> course;

	public Department(String name){
		this.name = name;
		this.course = new ArrayList<>();
	}

	public void addACourseToInventory(String number, String section){
		Course course1 = new Course(number, section);
		course.add(course1);
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(Course courses : course){
			sb.append(courses);
		}
		return sb.toString();
	}
}
