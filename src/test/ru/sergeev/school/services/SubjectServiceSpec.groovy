package ru.sergeev.school.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = Application.class)
class SubjectServiceSpec extends Specification {
    @Autowired
    private final SubjectService subjectService

    def "should return number of subjects from grade"() {
        expect:
        subjectService.getSubjectsByGradeId(1).size() == 12
        subjectService.getSubjectsByGradeId(2).size() == 10
    }
}