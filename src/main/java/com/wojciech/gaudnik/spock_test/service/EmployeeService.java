package com.wojciech.gaudnik.spock_test.service;

import com.wojciech.gaudnik.spock_test.model.Employee;
import com.wojciech.gaudnik.spock_test.model.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}

	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
}
   
