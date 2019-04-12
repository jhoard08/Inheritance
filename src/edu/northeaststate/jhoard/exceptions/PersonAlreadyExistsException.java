package edu.northeaststate.jhoard.exceptions;
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
public class PersonAlreadyExistsException extends Throwable
{
		public PersonAlreadyExistsException(String person_already_exist) {
			super(person_already_exist);
		}
}
