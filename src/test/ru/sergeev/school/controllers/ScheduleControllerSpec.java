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
import ru.sergeev.school.controllers.ScheduleController;
import ru.sergeev.school.services.ScheduleService;
import spock.lang.Specification;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

class ScheduleControllerSpec extends Specification {
    private MockMvc mockMvc;

    @InjectMocks
    private ScheduleController scheduleController;

    @Mock
    private ScheduleService scheduleService;

    @Mock
    private View mockView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = standaloneSetup(scheduleController).setSingleView(mockView).build();
    }

    @Test
    void shouldReturnScheduleByGradeId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/schedule"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(scheduleService, times(1)).getSchedulesByGradeId(1);
        verifyNoMoreInteractions(scheduleService);
    }

    @Test
    void shouldReturnStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/grades/1/schedules"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verifyNoMoreInteractions(scheduleService);
    }
}
