package com.sp.employeeservice.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sp.employeeservice.dao.EmployeeRepository;
import com.sp.employeeservice.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<Employee> getEmployeeList() {
		return (List<Employee>) repository.findAll();
	}

	public Employee getEmployee(int id) {
		return repository.findById(id).get();
	}

	public Employee createEmployee(Employee emp) {
		return repository.save(emp);
	}

	public List<Employee> findEmployeeByName(String name) {
		return repository.findByNameLike(name);
	}

	public List<Employee> findEmployeeWithSorting(int pageNo, int PageSize, String field) {
		Pageable paging = PageRequest.of(pageNo, PageSize);

		Page<Employee> pagedResult = repository.findAll(paging);

		return pagedResult.getContent();
	}

	public Employee findHighestPaidEmployee(Integer deptId) {
		List<Employee> data = repository.findMaxSalaryByDept(deptId);

		Employee emp = data.stream().max(Comparator.comparing(Employee::getSalary)).get();

		return emp;
	}
}
