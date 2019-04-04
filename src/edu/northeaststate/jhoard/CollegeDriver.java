package edu.northeaststate.jhoard;

import edu.northeaststate.jhoard.data.BinaryFileAccess;
import edu.northeaststate.jhoard.exceptions.DepartmentAlreadyExistException;
import edu.northeaststate.jhoard.exceptions.PersonAlreadyExistsException;
import edu.northeaststate.jhoard.organization.School;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class CollegeDriver
{
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException
	{
		String schoolName;
		String schoolAddress;
		String dept;
		String selection;
		String fileName;

		//System.out.print("Enter school Name ");
		//schoolName = input.nextLine();
		//System.out.print("Enter school address: ");
		//schoolAddress = input.nextLine();
		School school = null;

		System.out.print("Enter the file name to load: ");
		fileName = input.nextLine().trim();
		try {
			school = BinaryFileAccess.openSchool(fileName);
			System.out.println(school);
			enterSchoolData(school);
		}
		catch (IOException | ClassNotFoundException e) {
			System.out.println("\n" + e.getMessage() + "\n");
		}
	}
	public static void addDepartment(String deptName, School school)
	{
		try{
			school.addDepartment(deptName);
		} catch (DepartmentAlreadyExistException e)
		{
			e.printStackTrace();
		}
	}
	public static void addInstructor(String firstName, String lastName, String bannerID, String office, String title, double pay, School school){
		try{
			school.addAnIntstructor(firstName, lastName, bannerID, office, title, pay);
		}catch(PersonAlreadyExistsException e){
			e.getMessage();
		}
	}
	public static void enterSchoolData(School school) {
		do {
			System.out.println("1: to enter a new department");
			System.out.println("2: to enter a new courses");
			System.out.println("3: to enter a new students");
			System.out.println("4: to enter a new instructors");
			System.out.println("5: to enter a new staff");
			System.out.println("6: to enter to exit");
			System.out.print("Enter selection: ");
			String selection = input.nextLine();
			if (selection.equalsIgnoreCase("1"))
			{
				System.out.print("Enter the department name: ");
				String departmentName = input.nextLine();
				addDepartment(departmentName, school);
			}
			else if(selection.equalsIgnoreCase("4")){
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
			else {
				if (selection.equalsIgnoreCase("6")){
					saveSchoolData(school);
					break;
				}
				System.out.println("\ninvalid input, try again\n\n");
			}
			System.out.println(school);
		} while (true);

	}
	public static void saveSchoolData(School school){
		try{
			BinaryFileAccess.saveSchoolFile("school.txt", school);
		}catch(FileAlreadyExistsException e){
			System.out.println("file exist");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	//public static void addCourse(School school){
	//	school.getDepartment();
	//}
}
