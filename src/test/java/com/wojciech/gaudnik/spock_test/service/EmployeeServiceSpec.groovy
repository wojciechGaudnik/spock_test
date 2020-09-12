package com.wojciech.gaudnik.spock_test.service

import com.wojciech.gaudnik.spock_test.model.Employee
import com.wojciech.gaudnik.spock_test.model.EmployeeRepository
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import spock.lang.Specification

@SpringBootTest
class EmployeeServiceSpec extends Specification {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    def "Service test"() {
        given:
        Employee alex = new Employee("alex")

        when:
        Mockito.when(employeeRepository.findByName(alex.getName())).thenReturn(alex)

        then:
        employeeService.getEmployeeByName("alex") == alex
    }

}
