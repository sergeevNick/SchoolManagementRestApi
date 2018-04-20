package sergeev.school.controllers

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.web.servlet.View
import ru.sergeev.school.controllers.ScheduleController
import ru.sergeev.school.services.ScheduleService
import spock.lang.Specification

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class ScheduleControllerSpec extends Specification {
    private MockMvc mockMvc
    private View mockView
    private ScheduleController scheduleController
    private ScheduleService scheduleService

    void setup() {
        scheduleService = Mock()
        mockView = Mock()
        scheduleController = new ScheduleController(scheduleService)
        mockMvc = standaloneSetup(scheduleController).setSingleView(mockView).build()
    }

    void "should call ScheduleService method 'getSchedulesByGradeId' and return status 200"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/schedule"))

        then:
        1 * scheduleService.getSchedulesByGradeId(1)
        response.andExpect(MockMvcResultMatchers.status().isOk())
    }

    void "should return status 400 when url is bad"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/schedules"))

        then:
        0 * scheduleService.getSchedulesByGradeId(1)
        response.andExpect(MockMvcResultMatchers.status().isNotFound())
    }
}