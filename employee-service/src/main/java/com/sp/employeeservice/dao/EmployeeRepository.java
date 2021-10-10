package com.sp.employeeservice.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sp.employeeservice.model.Employee;

public interface EmployeeRepository extends  PagingAndSortingRepository <Employee, Integer> {

	List<Employee> findByNameLike(String name);

}
