package sergeev.school.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.repository.SubjectRepository
import spock.lang.Specification


@SpringBootTest(classes = Application.class)
class SubjectRepositorySpec extends Specification {
    @Autowired
    private final SubjectRepository subjectRepository

    void "should return number of subjects from grade"() {
        expect:
        subjectRepository.findSubjectBySubjectId(2).name == "Русский язык"
    }
}
