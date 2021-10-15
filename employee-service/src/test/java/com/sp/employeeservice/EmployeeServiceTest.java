package com.sp.employeeservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
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

	List<Employee> empList = new ArrayList<>();
	
	@Before
	public void EmployeeList() {
		

		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("Sam");
		emp1.setSalary(1000);
		empList.add(emp1);

		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setName("peter");
		emp2.setSalary(2000);
		empList.add(emp2);

		Employee emp3 = new Employee();
		emp3.setId(3);
		emp3.setName("Bob");
		emp3.setSalary(3000);
		empList.add(emp3);

		
	}

	@Test
	public void allEmployeeListTest() {
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("Sam");

		List<Employee> empList = new ArrayList<>();
		empList.add(emp1);

		when(repository.findAll()).thenReturn(empList);
		List<Employee> data = empService.getEmployeeList();

		assertEquals(1, data.size());

	}

	@Test
	public void getHighestSalaryEmployeeTest() {

		when(repository.findMaxSalaryByDept(0)).thenReturn(empList);

		Employee e = empService.findHighestPaidEmployee(0);

		assertEquals(3, e.getId());
	}
}
