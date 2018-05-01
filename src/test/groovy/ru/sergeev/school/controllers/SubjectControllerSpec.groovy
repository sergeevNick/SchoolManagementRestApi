package ru.sergeev.school.controllers

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.web.servlet.View
import ru.sergeev.school.controllers.SubjectController
import ru.sergeev.school.services.SubjectService
import spock.lang.Specification

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class SubjectControllerSpec extends Specification {
    private MockMvc mockMvc
    private View mockView
    private SubjectController subjectController
    private SubjectService subjectService

    def setup() {
        subjectService = Mock()
        mockView = Mock()
        subjectController = new SubjectController(subjectService)
        mockMvc = standaloneSetup(subjectController).setSingleView(mockView).build()
    }

    def "should call SubjectService method 'getSubjectsByGradeId' and return status 200"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/subjects"))

        then:
        1 * subjectService.getSubjectsByGradeId(1)
        response.andExpect(MockMvcResultMatchers.status().isOk())
    }

    def "should return status 400 when url is bad"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/subject"))

        then:
        0 * subjectService.getSubjectsByGradeId(1)
        response.andExpect(MockMvcResultMatchers.status().isNotFound())
    }
}