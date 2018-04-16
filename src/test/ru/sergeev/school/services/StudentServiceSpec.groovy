package ru.sergeev.school.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = Application.class)
class StudentServiceSpec extends Specification {
    @Autowired
    private final UserService userService

    private final STUDENTS_OF_1ST_GRADE = 5
    private final STUDENTS_OF_2ND_GRADE = 3

    def "should return students by grade gradeId"() {
        expect:
        userService.getStudentsByGradeId(1).size() == STUDENTS_OF_1ST_GRADE
        userService.getStudentsByGradeId(2).size() == STUDENTS_OF_2ND_GRADE
    }
}