package edu.northeaststate.jhoard.data;

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
		System.out.println("File path: " + file.getAbsolutePath());
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file.getAbsoluteFile()));
		output.writeObject(school);
		System.out.println("File path: " + file.getAbsolutePath());
		output.close();
	}
}
