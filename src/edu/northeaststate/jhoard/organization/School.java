package edu.northeaststate.jhoard.organization;

import edu.northeaststate.jhoard.exceptions.DepartmentAlreadyExistException;
import edu.northeaststate.jhoard.exceptions.DepartmentNotFoundException;
import edu.northeaststate.jhoard.exceptions.PersonAlreadyExistsException;
import edu.northeaststate.jhoard.people.Instructor;
import edu.northeaststate.jhoard.people.Person;
import edu.northeaststate.jhoard.people.Staff;
import edu.northeaststate.jhoard.people.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class School implements Serializable
{
	private String name;
	private String address;
	private ArrayList<Department> departments;
	private ArrayList<Person> people;

	public School(String name, String address)
	{
		this.departments = new ArrayList<>();
		this.people = new ArrayList<>();
		this.name = name;
		this.address = address;
	}

	//public Instructor(String firstName, String lastName, String bannerID, String title, double pay, String officeNum)
	public void addAnIntstructor(String fName, String lName, String bannerID, String office, String title, double pay)
			throws PersonAlreadyExistsException
	{
		for (Person instructor : people)
		{
			if (!instructor.getFirstName().equalsIgnoreCase(fName) && !instructor.getLastName().equalsIgnoreCase(lName)
					&& !instructor.getBannerID().equalsIgnoreCase(bannerID))
			{
				throw new PersonAlreadyExistsException("This person already exist");
			}
		}
		people.add(new Instructor(fName, lName, bannerID, title, pay, office));

	}

	//public Staff(String firstName, String lastName, String bannerID, String title, double pay, int shift)
	public void addStaff(String fName, String lName, String bannerID, String title, double pay, int shift)
			throws PersonAlreadyExistsException
	{
		for (Person person : people)
		{
			if (person.getFirstName().equalsIgnoreCase(fName) && person.getLastName().equalsIgnoreCase(lName) && person
					.getBannerID().equalsIgnoreCase(bannerID))
				continue;
			{
				throw new PersonAlreadyExistsException("This person already exist");
			}
		}
		people.add(new Staff(fName, lName, bannerID, title, pay, shift));
	}

	//public Student(String firstName, String lastName, String bannerID, double gpa)
	public void addAStudent(String fName, String lName, String bannerID, double gpa) throws PersonAlreadyExistsException
	{
		people.add(new Student(fName, lName, bannerID, gpa));
	}

	public void addDepartment(String deptName) throws DepartmentAlreadyExistException
	{
		for (Department dept : departments)
		{
			if (!dept.getName().equalsIgnoreCase(deptName))
				continue;
			throw new DepartmentAlreadyExistException("This department already exists for this school");
		}
		departments.add(new Department(deptName));
	}

	public void getDepartment(String dept) throws DepartmentNotFoundException
	{
		//TODO

	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override public String toString()
	{
		return "School{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", departments=" + departments
				+ ", people=" + people + '}';
	}
}
