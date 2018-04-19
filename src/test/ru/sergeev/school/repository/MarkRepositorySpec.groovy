package sergeev.school.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.entities.Mark
import ru.sergeev.school.repository.MarkRepository
import spock.lang.Specification


@SpringBootTest(classes = Application.class)
class MarkRepositorySpec extends Specification {
    @Autowired
    private MarkRepository markRepository

    private final MARK_LIST_SIZE = 9
    private final MARK_ID_TO_DELETE = 5

    void "should delete mark with id '5'"() {
        when:
        markRepository.deleteMarkByMarkId(MARK_ID_TO_DELETE)

        then:
        markRepository.findAll().size() == MARK_LIST_SIZE - 1
    }

    void "should save mark"() {
        when:
        markRepository.save(new Mark())

        then:
        markRepository.findAll().size() == MARK_LIST_SIZE
    }
}