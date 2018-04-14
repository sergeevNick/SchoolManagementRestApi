package ru.sergeev.school.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = Application.class)
class StudentServiceSpec extends Specification {
    /*@Autowired
    private final StudentService studentService

    def "should return students by grade userId"() {
        expect:
        studentService.getStudentsByGradeId(1).size() == 5
        studentService.getStudentsByGradeId(2).size() == 2
    }*/
}