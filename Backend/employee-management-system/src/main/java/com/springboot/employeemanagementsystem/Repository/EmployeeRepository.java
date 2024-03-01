package com.springboot.employeemanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.employeemanagementsystem.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public Employee findByAadharNumber(String aadharNumber);

}
