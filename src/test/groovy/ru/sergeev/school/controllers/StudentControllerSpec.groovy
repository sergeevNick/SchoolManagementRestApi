package ru.sergeev.school.controllers

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.web.servlet.View
import ru.sergeev.school.controllers.StudentController
import ru.sergeev.school.services.UserService
import spock.lang.Specification

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup

class StudentControllerSpec extends Specification {
    private MockMvc mockMvc
    private View mockView
    private StudentController studentController
    private UserService userService

    def setup() {
        userService = Mock()
        mockView = Mock()
        studentController = new StudentController(userService)
        mockMvc = standaloneSetup(studentController).setSingleView(mockView).build()
    }

    def "should call UserService method 'getStudentsByGradeId' and return status 200"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/students"))

        then:
        1 * userService.getStudentsByGradeId(1)
        response.andExpect(MockMvcResultMatchers.status().isOk())
    }

    def "should return status 400 when url is bad"() {
        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/student"))

        then:
        0 * userService.getStudentsByGradeId(1)
        response.andExpect(MockMvcResultMatchers.status().isNotFound())
    }
}