package edu.northeaststate.jhoard.people;

import java.io.Serializable;

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
		return "Person{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", bannerID='"
				+ bannerID + '\'' + '}';
	}
}
