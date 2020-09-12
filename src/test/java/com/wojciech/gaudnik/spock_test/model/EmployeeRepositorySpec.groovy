package com.wojciech.gaudnik.spock_test.model

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import spock.lang.Specification
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmployeeRepositorySpec extends Specification {

    @Autowired
    private TestEntityManager entityManager
//
    @Autowired
    private EmployeeRepository employeeRepository

    def "FindByName"() {
        given:
        Employee alex = new Employee("alex")
        entityManager.persistAndFlush(alex)
        entityManager.clear()

        when:
        Employee found = employeeRepository.findByName(alex.getName())

        then:
        println(found.name)
        println(alex.name)
        assertThat(found.name).isEqualTo(alex.name)
    }
}
