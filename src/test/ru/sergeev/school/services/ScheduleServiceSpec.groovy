package sergeev.school.services

import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.repository.ScheduleRepository
import ru.sergeev.school.services.ScheduleService
import ru.sergeev.school.services.impl.ScheduleServiceImpl
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class ScheduleServiceSpec extends Specification {
    private ScheduleService scheduleService
    private ScheduleRepository scheduleRepository

    void setup() {
        scheduleRepository = Mock()
        scheduleService = new ScheduleServiceImpl(scheduleRepository)
    }

    void "should call ScheduleRepository method 'findSchedulesByGradeGradeId'"() {
        when:
        scheduleService.getSchedulesByGradeId(1)

        then:
        1 * scheduleRepository.findSchedulesByGradeGradeId(1)
    }
}
