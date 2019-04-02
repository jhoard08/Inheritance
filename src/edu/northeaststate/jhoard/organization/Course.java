package edu.northeaststate.jhoard.organization;

import java.io.Serializable;

public class Course implements Serializable
{
	private String number;
	private String section;

	public Course(String number, String section){
		this.number = number;
		this.section = section;
	}

	public String getNumber()
	{
		return number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getSection()
	{
		return section;
	}

	public void setSection(String section)
	{
		this.section = section;
	}

	@Override public String toString()
	{
		return "Course{" + "number='" + number + '\'' + ", section='" + section + '\'' + '}';
	}
}
