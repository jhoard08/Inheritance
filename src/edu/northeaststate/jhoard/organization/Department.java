package edu.northeaststate.jhoard.organization;

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

	public String addACourseToInventory(String number, String section){
		Course course1 = new Course(number, section);
		course.add(course1);
		return "TODO";
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
		return "Department{" + "name='" + name + '\'' + ", course=" + course + '}';
	}
}
