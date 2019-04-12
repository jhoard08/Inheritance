package edu.northeaststate.jhoard.organization;
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
import edu.northeaststate.jhoard.exceptions.DepartmentAlreadyExistException;
import edu.northeaststate.jhoard.exceptions.DepartmentNotFoundException;
import edu.northeaststate.jhoard.exceptions.PersonAlreadyExistsException;
import edu.northeaststate.jhoard.people.Instructor;
import edu.northeaststate.jhoard.people.Person;
import edu.northeaststate.jhoard.people.Staff;
import edu.northeaststate.jhoard.people.Student;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * This is the parent class that every Department or Course is built upon.
 * It has an interface attached to it via Serializable
 * The main purpose of the class is creating a new object for all the employees, departments, students, or courses
 * checking to make sure no duplicates are possible
 */
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

	/**
	 * This method takes in the fields for adding an instructor. Loops through the arraylist
	 * of Person. If a match is found an exception is throw.
	 * @param fName
	 * @param lName
	 * @param bannerID
	 * @param office
	 * @param title
	 * @param pay
	 * @throws PersonAlreadyExistsException
	 */
	//public Instructor(String firstName, String lastName, String bannerID, String title, double pay, String officeNum)
	public void addAnInstructor(String fName, String lName, String bannerID, String office, String title, double pay)
			throws PersonAlreadyExistsException
	{
		for (Person instructor : people)
		{
			if (!instructor.getBannerID().equalsIgnoreCase(bannerID))
				continue;
			{
				throw new PersonAlreadyExistsException("This person already exist");
			}
		}
		people.add(new Instructor(fName, lName, bannerID, title, pay, office));

	}

	/**
	 * This method takes in all the fields for a staff member. Looping through the list in Person
	 * If matches are found throws PersonAlreadyExistsException
	 * @param fName
	 * @param lName
	 * @param bannerID
	 * @param title
	 * @param pay
	 * @param shift
	 * @throws PersonAlreadyExistsException
	 */
	//public Staff(String firstName, String lastName, String bannerID, String title, double pay, int shift)
	public void addStaff(String fName, String lName, String bannerID, String title, double pay, int shift)
			throws PersonAlreadyExistsException
	{
		for (Person staff : people)
		{
			if (!staff.getFirstName().equalsIgnoreCase(fName) && staff.getLastName().equalsIgnoreCase(lName) && staff
					.getBannerID().equalsIgnoreCase(bannerID)){
				continue;
			}
			throw new PersonAlreadyExistsException("This person already exist");
		}
		people.add(new Staff(fName, lName, bannerID, title, pay, shift));
	}

	/**
	 * Add a new student object to person array if student already exist throw
	 * an exception
	 * @param fName
	 * @param lName
	 * @param bannerID
	 * @param gpa
	 * @throws PersonAlreadyExistsException
	 */
	//public Student(String firstName, String lastName, String bannerID, double gpa)
	public void addAStudent(String fName, String lName, String bannerID, double gpa) throws PersonAlreadyExistsException
	{
		for(Person student : people){
			if(!student.getFirstName().equalsIgnoreCase(fName) && !student.getLastName().equalsIgnoreCase(lName) && !student.getBannerID().equalsIgnoreCase(bannerID)){
				continue;
			}
			throw new PersonAlreadyExistsException("This person already exist!");
		}
		people.add(new Student(fName, lName, bannerID, gpa));
	}

	/**
	 * Creates a new department if one of the same name doesn't exist
	 * if department exist throw an exception
	 * @param deptName
	 * @throws DepartmentAlreadyExistException
	 */
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

	/**
	 * Checks to make sure a department exist before adding a course to the department
	 * if no department exist throws an exception
	 * @param dept
	 * @return
	 * @throws DepartmentNotFoundException
	 */
	public Department getDepartment(String dept) throws DepartmentNotFoundException
	{
		Department isValid = null;
		for(Department department : departments){
			if(!department.getName().equalsIgnoreCase(dept)){
				continue;
			}
			isValid = department;
			break;
		}
		if(isValid == null){
			throw new DepartmentNotFoundException("Department not found \n");
		}
		return isValid;

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

	/**
	 * Uses StringBuilder to give some formatting to the output of the data
	 * @return
	 */
	@Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("==========================================\n");
		sb.append("\t\t\t***SCHOOL REPORT***\n");
		sb.append("==========================================\n\n");
		sb.append("School Name: " + name + " Address: " + address);
		for(Department department : departments){
			sb.append("\n\nDepartment: " + department.getName());
			sb.append("\nCourse: " + department);
			}
		for(Person peoples : people){
			sb.append(peoples);
		}
		return sb.toString();
	}
}
