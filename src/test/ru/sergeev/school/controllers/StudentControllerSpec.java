package sergeev.school.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.View;
import ru.sergeev.school.controllers.StudentController;
import ru.sergeev.school.services.UserService;
import spock.lang.Specification;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class StudentControllerSpec extends Specification {
    private MockMvc mockMvc;

    @InjectMocks
    private StudentController studentController;

    @Mock
    private UserService userService;

    @Mock
    private View mockView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(studentController).setSingleView(mockView).build();
    }

    @Test
    void shouldReturnStudentsByGradeId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/students"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userService, times(1)).getStudentsByGradeId(1);
        verifyNoMoreInteractions(userService);
    }

    @Test
    void shouldReturnStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/student"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verifyNoMoreInteractions(userService);
    }
}
