package ru.sergeev.school.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
class GradeControllerSpec {
    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private GradeController gradeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(gradeController).build();
    }

    @Test
    void getAllGrades() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/grades"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void should404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("gradesx"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}