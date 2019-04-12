package edu.northeaststate.jhoard;
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
import edu.northeaststate.jhoard.data.BinaryFileAccess;
import edu.northeaststate.jhoard.exceptions.DepartmentAlreadyExistException;
import edu.northeaststate.jhoard.exceptions.DepartmentNotFoundException;
import edu.northeaststate.jhoard.exceptions.PersonAlreadyExistsException;
import edu.northeaststate.jhoard.organization.School;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class CollegeDriver
{
	private static Scanner input = new Scanner(System.in);

	/**
	 * Boots the whole application creating a Object of school setting it to null
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		School school = null;
		bootApplication(school);
	}

	/**
	 * Opens the file the user enters. If no file exist throws an exception
	 *
	 * @param school
	 */
	public static void openFile(School school)
	{
		System.out.print("Enter the file name to load: ");
		String fileName = input.nextLine().trim();
		try
		{
			school = BinaryFileAccess.openSchool(fileName);
			System.out.println(school);
			enterSchoolData(school);
		} catch (IOException | ClassNotFoundException e)
		{
			System.out.println("\n" + e.getMessage() + "\n");
		}
	}

	/**
	 * Creates a new file with a school name and address
	 * @param school
	 */
	public static void newCollegeFile(School school)
	{
		System.out.print("Please enter your school name: ");
		String schoolName = input.nextLine();
		System.out.print("Enter the school address: ");
		String schoolAddress = input.nextLine();
		school = new School(schoolName, schoolAddress);
		enterSchoolData(school);
	}

	/**
	 * Boots the application giving the user options for what they would like to do.
	 * Creates, Open, Save a file
	 * @param school
	 */
	public static void bootApplication(School school)
	{
		String choice;
		System.out.println("=====================================");
		System.out.println("\tCollege Reporting Application");
		System.out.println("=====================================");
		System.out.println("1: to load college data from a file");
		System.out.println("2: to enter new college data");
		System.out.println("3: to save");
		System.out.println("4: to exit");
		choice = input.nextLine();

		if (choice.equalsIgnoreCase("1"))
		{
			openFile(school);
		} else if (choice.equalsIgnoreCase("2"))
		{
			newCollegeFile(school);
		} else if (choice.equalsIgnoreCase("3"))
		{
			saveSchoolData(school);
		} else
		{
			System.exit(-1);
		}

	}

	/**
	 * Adds a department to the School object catches the exception if already exist
	 * @param deptName
	 * @param school
	 */
	public static void addDepartment(String deptName, School school)
	{
		try
		{
			school.addDepartment(deptName);
		} catch (DepartmentAlreadyExistException e)
		{
			System.out.println(e.getMessage() + "\n");
			;
		}
	}

	/**
	 * adds a course to the department of choice validating whether the department exist or not in a try catch
	 * @param school
	 */
	public static void addCourseToDepartment(School school)
	{
		try
		{
			System.out.print("Enter the department name: ");
			String departmentName = input.nextLine().trim();
			System.out.print("Enter course name: ");
			String courseName = input.nextLine().trim();
			System.out.print("Enter course section number: ");
			String courseSection = input.nextLine().trim();
			school.getDepartment(departmentName).addACourseToInventory(courseName, courseSection);
		} catch (DepartmentNotFoundException e)
		{
			System.out.println(e.getMessage() + "\n");
		}
	}

	/**
	 * This method adds an Instructor to the array throws an exception if person already exist
	 * @param firstName
	 * @param lastName
	 * @param bannerID
	 * @param office
	 * @param title
	 * @param pay
	 * @param school
	 */
	public static void addInstructor(String firstName, String lastName, String bannerID, String office, String title,
			double pay, School school)
	{
		try
		{
			school.addAnInstructor(firstName, lastName, bannerID, office, title, pay);
		} catch (PersonAlreadyExistsException e)
		{
			System.out.println(e.getMessage() + "\n");
			;
		}
	}

	/**
	 *	Adds a student unless student already exist in the file
	 * @param firstName
	 * @param lastName
	 * @param bannerID
	 * @param gpa
	 * @param school
	 */
	public static void addStudent(String firstName, String lastName, String bannerID, double gpa, School school)
	{
		try
		{
			school.addAStudent(firstName, lastName, bannerID, gpa);
		} catch (PersonAlreadyExistsException e)
		{
			System.out.println(e.getMessage() + "\n");
		}
	}

	/**
	 *	Adds a staff member unless member already exist in the file
	 * @param firstName
	 * @param lastName
	 * @param bannerID
	 * @param title
	 * @param pay
	 * @param shift
	 * @param school
	 */
	public static void addStaff(String firstName, String lastName, String bannerID, String title, double pay, int shift,
			School school)
	{
		try
		{
			school.addStaff(firstName, lastName, bannerID, title, pay, shift);
		} catch (PersonAlreadyExistsException e)
		{
			System.out.println(e.getMessage() + "\n");
		}
	}

	/**
	 * Allows the user to enter data until finished
	 * @param school
	 */
	public static void enterSchoolData(School school)
	{
		// while true take user input depending on the value entered take either department
		// course, student, staff, or exit program.
		do
		{
			System.out.println("\n1: to enter a new department");
			System.out.println("2: to enter a new courses");
			System.out.println("3: to enter a new students");
			System.out.println("4: to enter a new instructors");
			System.out.println("5: to enter a new staff");
			System.out.println("6: to enter to exit");
			System.out.print("Enter selection: ");
			String selection = input.nextLine();
			// add data to the department
			if (selection.equalsIgnoreCase("1"))
			{
				System.out.print("Enter the department name: ");
				String departmentName = input.nextLine();
				addDepartment(departmentName, school);
				// add course to department
			}
			// add course to department
			else if (selection.equalsIgnoreCase("2"))
			{
				addCourseToDepartment(school);
			}
			// add user input to student
			else if (selection.equalsIgnoreCase("3"))
			{
				System.out.print("Enter Students First Name: ");
				String fName = input.nextLine();
				System.out.print("Enter Students Last Name: ");
				String lName = input.nextLine();
				System.out.print("Enter Student Banner ID: ");
				String bannerID = input.nextLine();
				System.out.print("Enter Students GPA: ");
				String gpa = input.nextLine();
				double convertGpaToDouble = Double.parseDouble(gpa);
				addStudent(fName, lName, bannerID, convertGpaToDouble, school);
			}
			// add info for instructor
			else if (selection.equalsIgnoreCase("4"))
			{
				System.out.print("Enter the instructor's first name: ");
				String fName = input.nextLine();
				System.out.print("Enter the instructor's last name: ");
				String lName = input.nextLine();
				System.out.print("Enter the instructor banner id: ");
				String banner = input.nextLine();
				System.out.print("Enter the office number for instructor: ");
				String officeNum = input.nextLine();
				System.out.print("Enter the title for instructor: ");
				String titleName = input.nextLine();
				System.out.print("Enter the pay for instructor: ");
				String salary = input.nextLine();
				double payDbl = Double.parseDouble(salary);
				addInstructor(fName, lName, banner, officeNum, titleName, payDbl, school);
			}
			// add info for staff
			else if (selection.equalsIgnoreCase("5"))
			{
				System.out.print("Enter Staff Members First Name: ");
				String fName = input.nextLine();
				System.out.print("Enter Staff Members Last Name: ");
				String lName = input.nextLine();
				System.out.print("Enter Staff Members Banner ID: ");
				String bannerID = input.nextLine();
				System.out.print("Enter Staff Members Title: ");
				String title = input.nextLine();
				System.out.print("Enter Staff Members Pay: ");
				String pay = input.nextLine();
				System.out.print("Enter Staff Member shift: ");
				String shift = input.nextLine();
				double payToDouble = Double.parseDouble(pay);
				int shiftToInt = Integer.parseInt(shift);
				addStaff(fName, lName, bannerID, title, payToDouble, shiftToInt, school);
			}
			// goes back to the first method of booting up the application seeing if the user wants to
			// open a new file, create a new file, save the doc they've altered, or exit the program.
			else
			{
				if (selection.equalsIgnoreCase("6"))
				{
					bootApplication(school);
				}
				System.out.println("\ninvalid input, try again\n\n");
			}
			System.out.println(school);
		} while (true);

	}

	/**
	 * Saves the data the user added into the file
	 * @param school
	 */
	public static void saveSchoolData(School school)
	{
		try
		{
			BinaryFileAccess.saveSchoolFile("school.txt", school);
			System.exit(-1);
		} catch (FileAlreadyExistsException e)
		{
			System.out.println(e);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
