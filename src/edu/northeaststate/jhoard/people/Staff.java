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

public class Staff extends Employee implements Serializable
{
	/**
	 * This class uses polymorphism and inheritance with the class
	 * Employee. It has an interface attached to it via Serializable
	 * The classes main function is to create a Staff member for the Employee Class
	 */
	protected int shift;

	public Staff()
	{
		super();
	}

	public Staff(String firstName, String lastName, String bannerID, String title, double pay, int shift)
	{
		super(firstName, lastName, bannerID, title, pay);
		this.shift = shift;
	}

	public int getShift()
	{
		return shift;
	}

	public void setShift(int shift)
	{
		this.shift = shift;
	}

	@Override public String toString()
	{
		return "\n\nStaff: " + super.toString() + " Shift: " + shift;
	}
}
