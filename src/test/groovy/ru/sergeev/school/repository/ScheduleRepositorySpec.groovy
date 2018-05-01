package ru.sergeev.school.repository

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.repository.ScheduleRepository
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class ScheduleRepositorySpec extends Specification {
    @Autowired
    private ScheduleRepository scheduleRepository

    private final SCHEDULES_OF_1ST_GRADE = 5
    private final SCHEDULES_OF_2ND_GRADE = 5

    def "should return schedules by grade gradeId"() {
        expect:
        scheduleRepository.findSchedulesByGradeGradeId(1).size() == SCHEDULES_OF_1ST_GRADE
        scheduleRepository.findSchedulesByGradeGradeId(2).size() == SCHEDULES_OF_2ND_GRADE
    }

    def "should return empty schedule when gradeId is not exist"() {
        when:
        Object response = scheduleRepository.findSchedulesByGradeGradeId(999999)

        then:
        notThrown(Exception)
        response.isEmpty()
    }
}