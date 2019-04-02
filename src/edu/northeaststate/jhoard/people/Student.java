package edu.northeaststate.jhoard.people;

import java.io.Serializable;

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
		return "Student{" + "gpa=" + gpa + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
				+ ", bannerID='" + bannerID + '\'' + '}';
	}
}
