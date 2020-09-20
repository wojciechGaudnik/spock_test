package com.wojciech.gaudnik.spock_test.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.wojciech.gaudnik.spock_test.model.Employee
import com.wojciech.gaudnik.spock_test.model.EmployeeRepository
import com.wojciech.gaudnik.spock_test.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import spock.lang.Unroll

import static groovy.json.JsonOutput.toJson
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*


//https://allegro.tech/2018/04/Spring-WebMvcTest-with-Spock.html
@WebMvcTest(controllers = [EmployeeController])
class EmployeeControllerAllegroSpecIT extends Specification {

    @Autowired
    protected MockMvc mockMvc

    @MockBean
    EmployeeService employeeService

    @MockBean
    EmployeeRepository employeeRepository

    @Unroll
    def "GetByNam"() {
        given:
        Map request = [
                name: "John"
        ]
        and:
        employeeService.getEmployeeByName("John") >> new Employee("John")
//        employeeRepository.findByName("John") >> new Employee("John")


        when:
        def result = mockMvc.perform(get("/hello/employee")
                .param("name", "John")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(request)))

//        def result2 = doRequest(post("/hello/employee").contentType(MediaType.APPLICATION_JSON).content(toJson(request))).andReturn()

        then:
        result.andExpect(status().isOk())

//        and:
//        result.andExpect(jsonPath('$.registration_id').value('registration-id-1'))        // 5
//        result.andExpect(jsonPath('$.email_address').value('john.wayne@gmail.com'))
//        result.andExpect(jsonPath('$.name').value('John'))
//        result.andExpect(jsonPath('$.last_name').value('Wayne'))


//        and:
//        with (objectMapper.readValue(response.contentAsString, Map)) {
//            it.registration_id == 'registration-id-1'
//            it.email_address == 'john.wayne@gmail.com'
//            it.name == 'John'
//            it.last_name == 'Wayne'
//        }

    }
}
