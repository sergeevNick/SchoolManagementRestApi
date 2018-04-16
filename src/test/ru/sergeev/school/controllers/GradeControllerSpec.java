package sergeev.school.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.View;
import ru.sergeev.school.controllers.GradeController;
import ru.sergeev.school.services.GradeService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
class GradeControllerSpec {
    private MockMvc mockMvc;

    @InjectMocks
    private GradeController gradeController;

    @Mock
    private GradeService gradeService;

    @Mock
    private View mockView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(gradeController).setSingleView(mockView).build();
    }

    @Test
    void shouldGetAllGrades() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/grades"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(gradeService, times(1)).listAllGrades();
        verifyNoMoreInteractions(gradeService);
    }

    @Test
    void shouldReturnStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/gradesx"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verifyNoMoreInteractions(gradeService);
    }
}