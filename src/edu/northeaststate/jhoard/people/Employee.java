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

public class Employee extends Person implements Serializable
{
	protected String title;
	protected double pay;

	public Employee(){super();}

	public Employee(String firstName, String lastName, String bannerID, String title, double pay)
	{
		super(firstName, lastName, bannerID);
		this.title = title;
		this.pay = pay;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public double getPay()
	{
		return pay;
	}

	public void setPay(double pay)
	{
		this.pay = pay;
	}

	@Override public String toString()
	{
		return "Name: " + firstName + " " + lastName + " bannerID: " + bannerID + " Title: " + title + " Pay: " + pay;
	}
}
