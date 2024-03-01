package com.springboot.employeemanagementsystem.Exceptions;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException() {

	}

	public EmployeeNotFoundException(String mssg) {
		super(mssg);
	}
}
