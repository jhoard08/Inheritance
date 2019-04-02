package edu.northeaststate.jhoard.people;

import java.io.Serializable;

public class Staff extends Employee implements Serializable
{
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
		return "Staff{" + "shift=" + shift + ", title='" + title + '\'' + ", pay=" + pay + ", firstName='" + firstName
				+ '\'' + ", lastName='" + lastName + '\'' + ", bannerID='" + bannerID + '\'' + '}';
	}
}
