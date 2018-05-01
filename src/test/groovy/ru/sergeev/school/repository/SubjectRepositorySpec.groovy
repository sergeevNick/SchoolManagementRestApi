package ru.sergeev.school.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.repository.SubjectRepository
import spock.lang.Specification


@SpringBootTest(classes = Application.class)
class SubjectRepositorySpec extends Specification {
    @Autowired
    private SubjectRepository subjectRepository

    def "should return subject by id"() {
        expect:
        subjectRepository.findSubjectBySubjectId(2).name == "Русский язык"
    }

    def "should return null subject when subjectId is not exist"() {
        when:
        Object response = subjectRepository.findSubjectBySubjectId(999999)

        then:
        notThrown(Exception)
        response == null
    }
}
