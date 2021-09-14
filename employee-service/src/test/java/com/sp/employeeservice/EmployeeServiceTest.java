package com.sp.employeeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sp.employeeservice.dao.EmployeeRepository;
import com.sp.employeeservice.model.Employee;
import com.sp.employeeservice.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService empService;

	@MockBean
	private EmployeeRepository repository;

	@Test
	public void allEmployeeListTest() {
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("Sam");

		List<Employee> empList = new ArrayList<>();
//		empList.add(emp1);

		when(repository.findAll()).thenReturn(empList);
		List<Employee> data = empService.getEmployeeList();

		assertEquals(1, data.size());

	}
}
