package edu.northeaststate.jhoard.people;

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
		return "Employee{" + "title='" + title + '\'' + ", pay=" + pay + ", firstName='" + firstName + '\''
				+ ", lastName='" + lastName + '\'' + ", bannerID='" + bannerID + '\'' + '}';
	}
}
