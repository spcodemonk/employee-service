package com.sp.employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.employeeservice.dao.EmployeeRepository;
import com.sp.employeeservice.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;

	public List<Employee> getEmployeeList(){
		
		return (List<Employee>) repository.findAll();
	}
}
