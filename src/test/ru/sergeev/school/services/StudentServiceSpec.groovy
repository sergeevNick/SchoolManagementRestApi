package sergeev.school.services

import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.repository.UserRepository
import ru.sergeev.school.services.UserService
import ru.sergeev.school.services.impl.UserServiceImpl
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class StudentServiceSpec extends Specification {
    private UserService userService
    private UserRepository userRepository

    void setup() {
        userRepository = Mock()
        userService = new UserServiceImpl(userRepository)
    }

    void "should call UserRepository method 'findUsersByRoleAndGradeGradeId'"() {
        when:
        userService.getStudentsByGradeId(1)

        then:
        1 * userRepository.findUsersByRoleAndGradeGradeId("STUDENT", 1)
    }
}