package com.sp.employeeservice;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String FindAllEmployees() {

		return "Hi Sharad";
	}

	@PostMapping("/save-emp")
	public String saveEmployee(@RequestBody EmployeeDto empDto) {
		Employee emp = modelMapper.map(empDto, Employee.class);
		System.out.println(emp.toString());
		return new String("Sharad");
	}

}
