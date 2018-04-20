package sergeev.school.controllers

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.web.servlet.View
import ru.sergeev.school.controllers.GradeController
import ru.sergeev.school.services.GradeService
import spock.lang.Specification

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class GradeControllerSpec extends Specification {
    private MockMvc mockMvc
    private View mockView
    private GradeController gradeController
    private GradeService gradeService

    void setup() {
        gradeService = Mock()
        mockView = Mock()
        gradeController = new GradeController(gradeService)
        mockMvc = standaloneSetup(gradeController).setSingleView(mockView).build()
    }

    void "should call GradeService method 'listAllGrades' and return status 200"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/grades"))

        then:
        1 * gradeService.listAllGrades()
        response.andExpect(MockMvcResultMatchers.status().isOk())
    }

    void "should return status 400 when url is bad"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/grade"))

        then:
        0 * gradeService.listAllGrades()
        response.andExpect(MockMvcResultMatchers.status().isNotFound())
    }
}