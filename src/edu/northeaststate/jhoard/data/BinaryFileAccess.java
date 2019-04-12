package edu.northeaststate.jhoard.data;
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
import edu.northeaststate.jhoard.organization.School;

import java.io.*;

public class BinaryFileAccess
{
	public static School openSchool(String fileName) throws IOException, ClassNotFoundException
	{
		ObjectInputStream input = null;
		input = new ObjectInputStream(new FileInputStream(fileName));
		School school = (School)input.readObject();
		input.close();

		return school;
	}
	public static void saveSchoolFile(String fileName, School school) throws IOException
	{
		File file = new File(fileName);
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file.getAbsoluteFile()));
		output.writeObject(school);
		System.out.println("Saved To File path: " + file.getAbsolutePath());
		output.close();
	}
}
