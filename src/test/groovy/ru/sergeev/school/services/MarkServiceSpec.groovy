package ru.sergeev.school.services

import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.entities.Mark
import ru.sergeev.school.repository.MarkRepository
import ru.sergeev.school.repository.SubjectRepository
import ru.sergeev.school.repository.UserRepository
import ru.sergeev.school.services.MarkService
import ru.sergeev.school.services.impl.MarkServiceImpl
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class MarkServiceSpec extends Specification {
    private MarkService markService
    private MarkRepository markRepository
    private UserRepository userRepository
    private SubjectRepository subjectRepository

    def setup() {
        markRepository = Mock()
        userRepository = Mock()
        subjectRepository = Mock()
        markService = new MarkServiceImpl(markRepository, userRepository, subjectRepository)
    }


    def "should call MarkRepository method 'findMarksByStudentUserIdAndSubjectSubjectId'"() {
        when:
        markService.getMarksByStudentIdAndSubjectId(1, 1)

        then:
        1 * markRepository.findMarksByStudentUserIdAndSubjectSubjectId(1, 1)
    }

    def "should call MarkRepository method 'delete'"() {
        when:
        markService.deleteMarkById(1)

        then:
        1 * markRepository.deleteMarkByMarkId(1)
    }

    def "should call MarkRepository method 'save'"() {
        when:
        markService.saveMark(5, 1, 1)

        then:
        1 * markRepository.save(_ as Mark)
        1 * userRepository.findUserByUserId(1)
        1 * subjectRepository.findSubjectBySubjectId(1)
    }
}
