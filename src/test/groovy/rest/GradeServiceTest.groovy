package rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.repository.GradeRepository
import ru.sergeev.school.services.GradeService
import spock.lang.Specification
import spock.lang.Unroll


@SpringBootTest(classes = Application.class)
class GradeServiceTest extends Specification {
    @Autowired
    private final GradeService gradeService

    private final GRADE_LIST_SIZE = 3

    @Unroll
    def "get all grades"() {
        expect:
        gradeService.listAllGrades().size() == GRADE_LIST_SIZE
    }

    @Unroll
    def "delete grade"() {
        when:
        gradeService.deleteGradeById(gradeService.listAllGrades().last().gradeId)

        then:
        gradeService.listAllGrades().last().number != "9в"
        gradeService.listAllGrades().size() == GRADE_LIST_SIZE - 1
    }

    @Unroll
    def "save grade"() {
        when:
        gradeService.saveGrade("9в")

        then:
        gradeService.listAllGrades().last().number == "9в"
    }
}