package com.wojciech.gaudnik.spock_test

import spock.lang.Specification

class GroovySpec extends Specification {

    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }
}
