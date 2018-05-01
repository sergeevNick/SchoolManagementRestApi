package sergeev.school.services

import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.repository.GradeRepository
import ru.sergeev.school.services.GradeService
import ru.sergeev.school.services.impl.GradeServiceImpl
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class GradeServiceSpec extends Specification {
    private GradeService gradeService
    private GradeRepository gradeRepository

    void setup() {
        gradeRepository = Mock()
        gradeService = new GradeServiceImpl(gradeRepository)
    }

    void "should call GradeRepository method 'findAll'"() {
        when:
        gradeService.listAllGrades()

        then:
        gradeRepository != null
        1 * gradeRepository.findAllByOrderByNumberAsc()
    }
}