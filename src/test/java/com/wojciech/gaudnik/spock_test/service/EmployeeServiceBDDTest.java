package com.wojciech.gaudnik.spock_test.service;

import com.wojciech.gaudnik.spock_test.model.Employee;
import com.wojciech.gaudnik.spock_test.model.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceBDDTest {

	@Mock(lenient = true)
	EmployeeRepository employeeRepository;

	@InjectMocks
	EmployeeService employeeService;

	@Test
	void getEmployeeByNameTest() {
		//given
		var em1 = Employee.builder().id(1L).name("test1").build();
		var em2 = Employee.builder().id(1L).name("test2").build();
		given(employeeRepository.findByName("test1")).willReturn(em1);
//		when(employeeRepository.findByName("test1")).thenReturn(em1);

		//when
		var result = employeeService.getEmployeeByName("test1");
//		when(employeeService.getEmployeeByName("test1")).thenReturn(em2); //todo <--- doesn't work

		//then
		then(employeeRepository).should().findByName(anyString());
		then(employeeRepository).shouldHaveNoMoreInteractions();
		assertThat(result).isNotNull();
	}

	@Test
	void testSavedLambdaMatchNoMatch() {
		//given
		final String MATCH_ME = "test";
//		var employeeMatchedOrNot = Employee.builder().id(1L).name(MATCH_ME).build();  // <--- matched
		var employeeMatchedOrNot = Employee.builder().id(1L).name("NO_MATCH_ME").build();  // <--- no matched
		var employeeSaved = Employee.builder().id(1L).name(MATCH_ME).build();

		//mock return only if name to save is the same as name return from mock
		given(employeeRepository.save(argThat(argument -> argument.getName().equals(MATCH_ME)))).willReturn(employeeSaved);

		//when
		var resultEmployee = employeeService.save(employeeMatchedOrNot);

		//then
//		assertNotNull(resultEmployee);
		assertNull(resultEmployee);

	}


	@Test
	void testDoThrow() {
		doThrow(new RuntimeException("boom")).when(employeeRepository).delete(any());

		var em1 = new Employee("test");
		assertThrows(RuntimeException.class, () -> employeeRepository.delete(em1));

		verify(employeeRepository).delete(any());

	}

	@Test
	void testFindByNameThrows() {
		given(employeeRepository.findByName("test1")).willThrow(new RuntimeException("boom"));

		assertThrows(RuntimeException.class, () -> employeeService.getEmployeeByName("test1"));

		then(employeeRepository).should().findByName("test1");
	}

	@Test
	void testDeleteThrowsBDD() {
		willThrow(new RuntimeException("boom")).given(employeeRepository).delete(any());

		var em1 = new Employee("test1");
		assertThrows(RuntimeException.class, () -> employeeRepository.delete(em1));

		then(employeeRepository).should().delete(any());
	}
}