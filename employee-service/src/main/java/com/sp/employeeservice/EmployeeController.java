package com.sp.employeeservice;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.employeeservice.dto.EmployeeDto;
import com.sp.employeeservice.model.Employee;
import com.sp.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/allEmps")
	public List<Employee> FindAllEmployees() {
		return empService.getEmployeeList();
	}
	
	@GetMapping("/sampleFeggnTest")
	public String sampleFeggnTest() {
		return "Sharad your Feign Client test is successful Wow";
	}
	
	@GetMapping("/allEmpswithPage")
	public List<Employee> findEmployeeWithSorting( @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize,@RequestParam(defaultValue = "id") String sortBy) {
		
		return empService.findEmployeeWithSorting(pageNo,pageSize, sortBy);
	}
	
	
	@GetMapping("/getemp/{id}")
	public Employee FindAllEmployees(@PathVariable int id) {
		return empService.getEmployee(id);
	}

	@PostMapping("/save-emp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto empDto) {
		Employee emp = modelMapper.map(empDto, Employee.class);
		System.out.println(emp);
		return new ResponseEntity<Employee>(empService.createEmployee(emp), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findbyname/{name}")
	public ResponseEntity<List<Employee>> findEmployeeByName(@PathVariable String name) {
		 List<Employee> empList = empService.findEmployeeByName(name);
		System.out.println(empList);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.ACCEPTED);
	}
	

}
