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

/**
 * Parent object of the Employee and Students by using polymorphism and inheritance
 */
public class Person implements Serializable
{
	protected String firstName;
	protected String lastName;
	protected String bannerID;

	public Person(){super();}

	public Person(String firstName, String lastName, String bannerID)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.bannerID = bannerID;
	}

	public String getFirstName()
	{
		return firstName;
	}


	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getBannerID()
	{
		return bannerID;
	}

	public void setBannerID(String bannerID)
	{
		this.bannerID = bannerID;
	}

	@Override public String toString()
	{
		return "Name: " + firstName + " " + lastName + " BannerID: " + bannerID;
	}
}
