package com.wojciech.gaudnik.spock_test

import com.wojciech.gaudnik.spock_test.controller.EmployeeController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class SpockTestApplicationSpec extends Specification {

    @Autowired(required = false)
    private EmployeeController simpleController

    def "when context is loaded then all expected beans are created"() {
        expect: "the SimpleController is created"
        simpleController
    }
}
