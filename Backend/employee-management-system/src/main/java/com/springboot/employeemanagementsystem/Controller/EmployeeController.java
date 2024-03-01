package com.springboot.employeemanagementsystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employeemanagementsystem.Entity.Employee;
import com.springboot.employeemanagementsystem.Service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		return employeeService.getEmployee(id);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		return employeeService.deleteEmployee(id);
	}

}
