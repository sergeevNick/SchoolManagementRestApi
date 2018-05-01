package sergeev.school.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.repository.UserRepository
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class UserRepositorySpec extends Specification {
    @Autowired
    private UserRepository userRepository

    private final STUDENTS_OF_1ST_GRADE = 5
    private final STUDENTS_OF_2ND_GRADE = 3

    void "should return students by grade gradeId"() {
        expect:
        userRepository.findUsersByRoleAndGradeGradeId("STUDENT",1).size() == STUDENTS_OF_1ST_GRADE
        userRepository.findUsersByRoleAndGradeGradeId("STUDENT",2).size() == STUDENTS_OF_2ND_GRADE
    }
}
