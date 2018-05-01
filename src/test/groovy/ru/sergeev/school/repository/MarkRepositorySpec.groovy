package ru.sergeev.school.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.entities.Mark
import ru.sergeev.school.entities.Subject
import ru.sergeev.school.entities.User
import spock.lang.Specification

import java.sql.Date

@SpringBootTest(classes = Application.class)
class MarkRepositorySpec extends Specification {
    @Autowired
    private MarkRepository markRepository
    @Autowired
    SubjectRepository subjectRepository
    @Autowired
    UserRepository userRepository


    private final MARK_LIST_SIZE = 9
    private final MARK_ID_TO_DELETE = 5

    def "should delete mark with id '5'"() {
        when:
        markRepository.deleteMarkByMarkId(MARK_ID_TO_DELETE)

        then:
        markRepository.findAll().size() == MARK_LIST_SIZE - 1
    }

    def "should save mark"() {
        given:
        Mark mark = markRepository.findAll().last()
        mark.setMarkId(mark.getMarkId() + 1)

        when:
        markRepository.save(mark)

        then:
        markRepository.findAll().size() == MARK_LIST_SIZE
    }

    def "should no throw exception when trying to delete mark with non-existent id"() {
        when:
        markRepository.deleteMarkByMarkId(7959565)
        markRepository.deleteMarkByMarkId(-7)

        then:
        notThrown(Exception)
        markRepository.findAll().size() == MARK_LIST_SIZE
    }

    def "should throw exception when trying to add mark with non-existent Subject and User"() {
        given:
        Mark mark = new Mark(4)
        mark.setDate(new Date(new java.util.Date().getTime()))
        mark.setSubject(null)
        mark.setStudent(null)

        when:
        markRepository.save(mark)

        then:
        thrown Exception
        markRepository.findAll().size() == MARK_LIST_SIZE
    }

    def "should throw exception when trying to add mark with already existent id"() {
        given:
        Mark mark = new Mark(4)
        mark.setMarkId(1)
        mark.setDate(new Date(new java.util.Date().getTime()))
        mark.setSubject(new Subject())
        mark.setStudent(new User())

        when:
        markRepository.save(mark)

        then:
        thrown Exception
        markRepository.findAll().size() == MARK_LIST_SIZE
    }
}