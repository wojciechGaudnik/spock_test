package com.wojciech.gaudnik.spock_test.service

import com.wojciech.gaudnik.spock_test.model.Employee
import com.wojciech.gaudnik.spock_test.model.EmployeeRepository
import spock.lang.Specification

import static spock.genesis.Gen.string


class EmployeeServiceTestGoodSpec extends Specification {

    EmployeeRepository employeeRepository

    EmployeeService employeeService

    void GetAll() {
        given:
            employeeRepository = Mock()
            employeeService = new EmployeeService(employeeRepository)
            def em1 = Employee.builder().id(1).name(string(~'[a-zA-Z]{10}').take(1).join()).build()
            def em2 = Employee.builder().id(2).name(string(~'[a-zA-Z]{10}').take(1).join()).build()
            def em3 = Employee.builder().id(3).name(string(~'[a-zA-Z]{10}').take(1).join()).build()
            def em4 = Employee.builder().id(4).name(string(~'[a-zA-Z]{10}').take(1).join()).build()

            employeeRepository.findAll() >> [em1, em2, em3]

        when:
            def result = employeeService.getAll()
        then:
            result == [em1, em2, em3]
    }
}
