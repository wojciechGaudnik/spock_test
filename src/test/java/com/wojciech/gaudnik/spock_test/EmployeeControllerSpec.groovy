package com.wojciech.gaudnik.spock_test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class EmployeeControllerSpec extends Specification {

    @Autowired
    private MockMvc mockMvc

    def "when get is performed then the response has tatus 200 and content is 'Hello'"() {
        expect: "Status is 200 and the response is 'Hello'"
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == "Hello"
    }
}

