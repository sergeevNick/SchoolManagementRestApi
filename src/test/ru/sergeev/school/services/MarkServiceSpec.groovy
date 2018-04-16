package ru.sergeev.school.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.entities.Mark
import ru.sergeev.school.repository.MarkRepository
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.sql.Date

@SpringBootTest(classes = Application.class)
class MarkServiceSpec extends Specification {
    @Autowired
    private final MarkService markService

    private final MARK_LIST_SIZE = 9

    def "should delete last mark"() {
        when:
        markService.deleteMarkById(markService.listAllMarks().last().markId)

        then:
        markService.listAllMarks().size() == MARK_LIST_SIZE - 1
    }

    def "should save mark"() {
        when:
        markService.saveMark(5, 1, 3)

        then:
        markService.listAllMarks().size() == MARK_LIST_SIZE
    }
}
