package edu.northeaststate.jhoard.people;

import java.io.Serializable;
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
public class Student extends Person implements Serializable
{
	protected double gpa;

	public Student()
	{
		super();
	}

	public Student(String firstName, String lastName, String bannerID, double gpa)
	{
		super(firstName, lastName, bannerID);
		this.gpa = gpa;
	}

	public double getGpa()
	{
		return gpa;
	}

	public void setGpa(double gpa)
	{
		this.gpa = gpa;
	}

	@Override public String toString()
	{
		return "\n\nStudent: " + super.toString() + " GPA: " + gpa;
	}
}
