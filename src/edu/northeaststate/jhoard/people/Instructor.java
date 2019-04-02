package edu.northeaststate.jhoard.people;

import java.io.Serializable;

public class Instructor extends Employee implements Serializable
{
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
		return "Instructor{" + "officeNum='" + officeNum + '\'' + ", title='" + title + '\'' + ", pay=" + pay
				+ ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", bannerID='" + bannerID
				+ '\'' + '}';
	}
}
