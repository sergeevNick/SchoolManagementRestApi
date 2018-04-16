package sergeev.school.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.View;
import ru.sergeev.school.controllers.MarkController;
import ru.sergeev.school.services.MarkService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
class MarkControllerSpec {
    private MockMvc mockMvc;

    @InjectMocks
    private MarkController markController;

    @Mock
    private MarkService markService;

    @Mock
    private View mockView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(markController).setSingleView(mockView).build();
    }

    @Test
    void shouldReturnMarksByGradeIdAndSubjectId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/marks/students/1/subjects/2"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(markService, times(1)).getMarksByStudentIdAndSubjectId(1, 2);
        verifyNoMoreInteractions(markService);
    }

    @Test
    void shouldReturnStatus200WhenDeleteMark() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/marks/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(markService, times(1)).deleteMarkById(1);
        verifyNoMoreInteractions(markService);
    }

    @Test
    void shouldReturnStatus200WhenAddMark() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/marks/students/1/subjects/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"value\": 5}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(markService, times(1)).saveMark(5, 1, 1);
        verifyNoMoreInteractions(markService);
    }


    @Test
    void shouldReturnStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/marks/students/404/subjects/"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verifyNoMoreInteractions(markService);
    }
}
