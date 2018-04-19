package sergeev.school.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.sergeev.school.Application
import ru.sergeev.school.entities.Day
import ru.sergeev.school.entities.Grade
import ru.sergeev.school.entities.Schedule
import ru.sergeev.school.entities.ScheduleRow
import ru.sergeev.school.entities.Subject
import ru.sergeev.school.repository.ScheduleRepository
import ru.sergeev.school.services.SubjectService
import ru.sergeev.school.services.impl.SubjectServiceImpl
import spock.lang.Specification

@SpringBootTest(classes = Application.class)
class SubjectServiceSpec extends Specification {
    private SubjectService subjectService
    private ScheduleRepository scheduleRepository

    void setup() {
        scheduleRepository = Mock()
        /*Set rows = new HashSet()
        rows.add(new ScheduleRow().setSubject(new Subject()))
        rows.add(new ScheduleRow().setSubject(new Subject()))
        rows.add(new ScheduleRow().setSubject(new Subject()))
        scheduleRepository.save(new Schedule(new Grade("11б"), new Day(), rows))*/
        //scheduleRepository.save(new Schedule())
        //println(scheduleRepository.findAll().size() + "\n\n\n\n\n")
        subjectService = new SubjectServiceImpl(scheduleRepository)
    }

    void "should call ScheduleRepository method 'findSchedulesByGradeGradeId'"() {
        when:
        subjectService.getSubjectsByGradeId(1)

        then:
        scheduleRepository != null
        scheduleRepository.findSchedulesByGradeGradeId(1) == null
        1 * scheduleRepository.findSchedulesByGradeGradeId(1)
    }
}