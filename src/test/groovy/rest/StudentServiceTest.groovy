package rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.services.StudentService
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest(classes = Application.class)
class StudentServiceTest extends Specification {

    @Autowired
    private final StudentService studentService

    private final STUDENT_LIST_SIZE = 7

    @Unroll
    def "get all students"() {
        expect:
        studentService.listAllStudents().size() == STUDENT_LIST_SIZE
    }

    @Unroll
    def "get students by grade id"() {
        expect:
        studentService.getStudentsByGradeId(1).size() == 5
        studentService.getStudentsByGradeId(2).size() == 2
    }
}