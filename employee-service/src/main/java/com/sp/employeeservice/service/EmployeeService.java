package com.sp.employeeservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.employeeservice.dao.EmployeeRepository;
import com.sp.employeeservice.model.Employee;

@Service
@Transactional
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<Employee> getEmployeeList() {
		return (List<Employee>) repository.findAll();
	}

	public Employee getEmployee(int id) {
		return repository.findById(1).get();
	}
	
	public Employee createEmployee(Employee emp) {
		return repository.save(emp);
	}
}
