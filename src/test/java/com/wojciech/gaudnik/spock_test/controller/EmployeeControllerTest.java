package com.wojciech.gaudnik.spock_test.controller;

import com.wojciech.gaudnik.spock_test.model.Employee;
import com.wojciech.gaudnik.spock_test.service.EmployeeService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	@SneakyThrows
	@Test
	void getByNam() {
		Employee alex = new Employee("alex");
		Employee eve = new Employee("eve");
		List<Employee> list = new LinkedList<>(){{add(alex);add(eve);}};

		given(employeeService.getAll()).willReturn(list);

		mockMvc.perform(get("/hello/employees")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", is(alex.getName())))
				.andExpect(jsonPath("$[1].name", is(eve.getName())));
	}
}