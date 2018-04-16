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
import ru.sergeev.school.controllers.SubjectController;
import ru.sergeev.school.services.SubjectService;
import spock.lang.Specification;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class SubjectControllerSpec extends Specification {
    private MockMvc mockMvc;

    @InjectMocks
    private SubjectController subjectController;

    @Mock
    private SubjectService subjectService;

    @Mock
    private View mockView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(subjectController).setSingleView(mockView).build();
    }

    @Test
    void shouldReturnSubjectsByGradeId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/subjects"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(subjectService, times(1)).getSubjectsByGradeId(1);
        verifyNoMoreInteractions(subjectService);
    }

    @Test
    void shouldReturnStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/subject"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verifyNoMoreInteractions(subjectService);
    }
}
