package rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.services.SubjectService
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = Application.class)
class SubjectServiceTest extends Specification {
    @Autowired
    private final SubjectService subjectService

    private final SUBJECT_LIST_SIZE = 12

    @Unroll
    def "get all subjects"() {
        expect:
        subjectService.listAllSubjects().size() == SUBJECT_LIST_SIZE
    }

    @Unroll
    def "get subjects by grade id"() {
        expect:
        subjectService.getSubjectsByGradeId(1).size() == 12
        subjectService.getSubjectsByGradeId(2).size() == 10
    }
}