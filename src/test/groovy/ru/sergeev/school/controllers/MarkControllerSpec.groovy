package sergeev.school.controllers

import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.web.servlet.View
import ru.sergeev.school.controllers.MarkController
import ru.sergeev.school.services.MarkService
import spock.lang.Specification

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class MarkControllerSpec extends Specification {
    private MockMvc mockMvc
    private View mockView
    private MarkController markController
    private MarkService markService

    void setup() {
        markService = Mock()
        mockView = Mock()
        markController = new MarkController(markService)
        mockMvc = standaloneSetup(markController).setSingleView(mockView).build()
    }

    void "should call MarkService method 'saveMark' and return status 200"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.post("/marks/students/1/subjects/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"value\": 5}")
                .accept(MediaType.APPLICATION_JSON))

        then:
        1 * markService.saveMark(5, 1, 1)
        response.andExpect(MockMvcResultMatchers.status().isOk())
    }

    void "should call MarkService method 'deleteMarkById' and return status 200"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.delete("/marks/1"))

        then:
        1 * markService.deleteMarkById(1)
        response.andExpect(MockMvcResultMatchers.status().isOk())
    }

    void "should call MarkService method 'getMarksByStudentIdAndSubjectId' and return status 200"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/marks/students/1/subjects/2"))

        then:
        1 * markService.getMarksByStudentIdAndSubjectId(1, 2)
        response.andExpect(MockMvcResultMatchers.status().isOk())
    }

    void "should return status 400 when url is bad"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/marks/students/404/subjects/"))

        then:
        0 * markService.getMarksByStudentIdAndSubjectId(1, 2)
        response.andExpect(MockMvcResultMatchers.status().isNotFound())
    }
}