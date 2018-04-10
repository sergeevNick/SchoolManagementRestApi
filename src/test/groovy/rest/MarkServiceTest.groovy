package rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.services.MarkService
import spock.lang.Specification
import spock.lang.Unroll

import java.sql.Date

@SpringBootTest(classes = Application.class)
class MarkServiceTest extends Specification {
    @Autowired
    private final MarkService markService

    private final MARK_LIST_SIZE = 31

    @Unroll
    def "get all marks"() {
        expect:
        markService.listAllMarks().size() == MARK_LIST_SIZE
    }

    @Unroll
    def "delete last mark"() {
        when:
        markService.deleteMarkById(markService.listAllMarks().last().markId)

        then:
        markService.listAllMarks().size() == MARK_LIST_SIZE - 1
    }

    @Unroll
    def "save mark"() {
        when:
        markService.saveMark(5, 1, 3)

        then:

        markService.getMarksByStudentIdAndSubjectId(1,3).last().value == 5
        markService.getMarksByStudentIdAndSubjectId(1,3).last().date == new Date(new java.util.Date().getTime())
        markService.listAllMarks().size() == MARK_LIST_SIZE
    }
}
