package edu.northeaststate.jhoard.exceptions;

public class PersonAlreadyExistsException extends Throwable
{
		public PersonAlreadyExistsException(String person_already_exist) {
			super(person_already_exist);
		}
}
