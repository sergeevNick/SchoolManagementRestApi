package ru.sergeev.school.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.enums.Role
import ru.sergeev.school.repository.UserRepository
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class UserRepositorySpec extends Specification {
    @Autowired
    private UserRepository userRepository

    private final STUDENTS_OF_1ST_GRADE = 5
    private final STUDENTS_OF_2ND_GRADE = 3

    def "should return students by grade gradeId"() {
        expect:
        userRepository.findUsersByRoleAndGradeGradeId(Role.STUDENT,1).size() == STUDENTS_OF_1ST_GRADE
        userRepository.findUsersByRoleAndGradeGradeId(Role.STUDENT,2).size() == STUDENTS_OF_2ND_GRADE
    }

    def "should return empty users set when gradeId or role is not exist"() {
        when:
        Set<Object> response1 = userRepository.findUsersByRoleAndGradeGradeId(Role.STUDENT,4353451)
        Set<Object> response2 = userRepository.findUsersByRoleAndGradeGradeId("SomeNonExistentRole",1)

        then:
        notThrown(Exception)
        response1.isEmpty()
        response2.isEmpty()
    }
}
