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
		return "\n"+ number + " " + section;
	}
}
