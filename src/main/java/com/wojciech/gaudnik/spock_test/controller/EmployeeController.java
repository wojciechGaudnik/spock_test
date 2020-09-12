package com.wojciech.gaudnik.spock_test.controller;

import com.wojciech.gaudnik.spock_test.model.Employee;
import com.wojciech.gaudnik.spock_test.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hello")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public String hello() {
		return "Hello";
	}

	@GetMapping("/employees")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("/employee")
	public Employee getByNam(@RequestParam String name) {

		return employeeService.getEmployeeByName(name);
	}

	@PostMapping("/employee")
	public void save(@RequestBody Employee employee) {
		employeeService.save(employee);
	}
}
   
