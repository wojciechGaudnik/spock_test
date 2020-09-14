package com.wojciech.gaudnik.spock_test.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.wojciech.gaudnik.spock_test.model.Employee
import com.wojciech.gaudnik.spock_test.service.EmployeeService
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

import static groovy.json.JsonOutput.toJson
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

@WebMvcTest(controllers = [EmployeeController])
class EmployeeControllerAllegroSpec extends Specification {

    @Autowired
    protected MockMvc mockMvc

    @MockBean
    EmployeeService employeeService

    @Autowired
    ObjectMapper objectMapper

    def "GetByNam"() {
        given:
        Map request = [
                name: "John"
        ]
        and:
        employeeService.getEmployeeByName("John") >> new Employee("John")

        when:
        def result = mockMvc.perform(get("/hello/employee")
                .param("name", "John")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request)))

        then:
        result.andExpect(status().isOk())

//        and:
//        result.andExpect(jsonPath('$.registration_id').value('registration-id-1'))        // 5
//        result.andExpect(jsonPath('$.email_address').value('john.wayne@gmail.com'))
//        result.andExpect(jsonPath('$.name').value('John'))
//        result.andExpect(jsonPath('$.last_name').value('Wayne'))


    }
}
