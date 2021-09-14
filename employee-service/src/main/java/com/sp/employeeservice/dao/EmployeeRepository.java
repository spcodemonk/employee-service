package com.sp.employeeservice.dao;

import org.springframework.data.repository.CrudRepository;

import com.sp.employeeservice.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
