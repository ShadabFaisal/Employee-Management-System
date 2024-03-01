package com.springboot.employeemanagementsystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.employeemanagementsystem.Entity.Employee;
import com.springboot.employeemanagementsystem.Exceptions.EmployeeNotFoundException;
import com.springboot.employeemanagementsystem.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	

	public ResponseEntity<Employee> addEmployee(Employee employee) {
		Employee savedEmployee = repository.save(employee);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	public ResponseEntity<Employee> getEmployee(Long id) {
		Employee emp;

		if (repository.findById(id).isEmpty()) {
			// Throw a EmployeeNotFoundException if the Customer with the given id is not
			// found
			throw new EmployeeNotFoundException();
		} else {
			// Retrieve the Customer by customerId using the customerRepo
			emp = repository.findById(id).get();
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employeeList = repository.findAll();
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}

	public ResponseEntity<Employee> updateEmployee(Long id, Employee employee) {

		Employee emp;

		if (repository.findById(id).isEmpty() && repository.findByAadharNumber(employee.getAadharNumber())==null) {
			// Throw a EmployeeNotFoundException if the Customer with the given id is not
			// found
			throw new EmployeeNotFoundException();
		} else {
			// Retrieve the Customer by customerId using the customerRepo
			emp = repository.findById(id).get();
		}
		
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmailId(employee.getEmailId());
		emp.setAddress(employee.getAddress());
		emp.setContactNumber(employee.getContactNumber());
		emp.setGender(employee.getGender());
		emp.setPanNumber(employee.getPanNumber());
		emp.setAadharNumber(employee.getAadharNumber());
		emp.setSalary(employee.getSalary());
		Employee updatedEmployee = repository.save(emp);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	public String deleteEmployee(Long id) {
		repository.deleteById(id);
		return "Delete Success";
	}

}
