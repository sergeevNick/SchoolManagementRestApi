package sergeev.school.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.entities.Schedule
import ru.sergeev.school.repository.ScheduleRepository
import ru.sergeev.school.services.ScheduleService
import ru.sergeev.school.services.impl.ScheduleServiceImpl
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class ScheduleServiceSpec extends Specification {
    @Autowired
    private ScheduleService scheduleService

    private final SCHEDULES_OF_1ST_GRADE = 5
    private final SCHEDULES_OF_2ND_GRADE = 5

    def "should return schedules by grade gradeId"() {
        expect:
        scheduleService.getSchedulesByGradeId(1).size() == SCHEDULES_OF_1ST_GRADE
        scheduleService.getSchedulesByGradeId(2).size() == SCHEDULES_OF_2ND_GRADE
    }
}
