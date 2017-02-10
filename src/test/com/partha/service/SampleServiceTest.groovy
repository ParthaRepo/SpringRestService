package com.partha.service

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import spock.lang.Specification

/**
 * Created by pxl8108 on 2/10/17.
 */
@SpringBootTest
class SampleServiceTest extends Specification {

    @Autowired
    SampleService sampleService

    @Test
    def "Greetings"() {
        when:
        sampleService.greetings()
        then:
        assert true
    }
}
