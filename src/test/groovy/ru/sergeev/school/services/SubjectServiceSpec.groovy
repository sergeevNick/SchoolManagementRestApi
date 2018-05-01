package ru.sergeev.school.services

import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.repository.ScheduleRepository
import ru.sergeev.school.services.SubjectService
import ru.sergeev.school.services.impl.SubjectServiceImpl
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class SubjectServiceSpec extends Specification {
    private SubjectService subjectService
    private ScheduleRepository scheduleRepository

    def setup() {
        scheduleRepository = Mock()
        subjectService = new SubjectServiceImpl(scheduleRepository)
    }

    def "should call ScheduleRepository method 'findSchedulesByGradeGradeId'"() {
        when:
        subjectService.getSubjectsByGradeId(1)

        then:
        scheduleRepository != null
        1 * scheduleRepository.findSchedulesByGradeGradeId(1)
    }
}