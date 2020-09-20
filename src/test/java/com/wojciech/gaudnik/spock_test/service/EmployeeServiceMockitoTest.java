package com.wojciech.gaudnik.spock_test.service;


import com.wojciech.gaudnik.spock_test.model.Employee;
import com.wojciech.gaudnik.spock_test.model.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.verify;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceTestSpec{

	@Mock
	EmployeeRepository employeeRepository;

	@InjectMocks
	EmployeeService employeeService;

	@Test
	void GetAll() {
		var em1 = Employee.builder().id(1L).name("test1").build();
		var em2 = Employee.builder().id(2L).name("test1").build();
		var em3 = Employee.builder().id(3L).name("test1").build();
		var em4 = Employee.builder().id(4L).name("test1").build();
		LinkedList<Employee> employs = new LinkedList<>() {{
			add(em1);
			add(em2);
			add(em3);
		}};

		//given
		given(employeeRepository.findAll()).willReturn(employs);
//		when(employeeRepository.findAll()).thenReturn(employs);

		//when
		var result = employeeService.getAll();

		//then
		verify(employeeRepository).findAll();
		assertThat(result).isEqualTo(employs);

		then(employeeRepository).should().findAll();
		assertThat(result).isEqualTo(employs);
	}
}

   
