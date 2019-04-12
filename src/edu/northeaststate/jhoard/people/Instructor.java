package edu.northeaststate.jhoard.people;
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

public class Instructor extends Employee implements Serializable
{
	/**
	 * This class uses polymorphism and inheritance with the class
	 * Employee. It has an interface attached to it via Serializable
	 * The classes main function is to create a Instructor for the Employee Class
	 */
	protected String officeNum;

	public Instructor(){super();}

	public Instructor(String firstName, String lastName, String bannerID, String title, double pay, String officeNum)
	{
		super(firstName, lastName, bannerID, title, pay);
		this.officeNum = officeNum;
	}

	public String getOfficeNum()
	{
		return officeNum;
	}

	public void setOfficeNum(String officeNum)
	{
		this.officeNum = officeNum;
	}

	@Override public String toString()
	{
		return "\n\nInstructor: " + super.toString();
	}
}
