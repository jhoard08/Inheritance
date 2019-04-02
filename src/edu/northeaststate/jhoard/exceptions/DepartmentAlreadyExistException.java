package edu.northeaststate.jhoard.exceptions;

public class DepartmentAlreadyExistException extends Throwable
{
	public DepartmentAlreadyExistException(String department_already_exist){
		super(department_already_exist);
	}
}
