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

    private final SUBJECTS_OF_1ST_GRADE = 12
    private final SUBJECTS_OF_2ND_GRADE = 8

    def "should return number of subjects from grade"() {
        expect:
        subjectService.getSubjectsByGradeId(1).size() == SUBJECTS_OF_1ST_GRADE
        subjectService.getSubjectsByGradeId(2).size() == SUBJECTS_OF_2ND_GRADE
    }
}