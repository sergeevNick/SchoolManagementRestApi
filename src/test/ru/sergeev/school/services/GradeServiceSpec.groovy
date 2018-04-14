package ru.sergeev.school.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import spock.lang.Specification


@SpringBootTest(classes = Application.class)
class GradeServiceSpec extends Specification {
    @Autowired
    private final GradeService gradeService

    private final GRADE_LIST_SIZE = 3

    def "should return all grades"() {
        expect:
        gradeService.listAllGrades().size() == GRADE_LIST_SIZE
    }
}