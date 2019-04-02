package edu.northeaststate.jhoard.exceptions;

public class DepartmentNotFoundException extends Throwable
{
	public DepartmentNotFoundException(String department_not_found){
		super(department_not_found);
	}
}
