package eu.mrndesign.matned.workerrest.workerrestapplication.controller;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.TeamDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.repository.TeamRepository;
import eu.mrndesign.matned.workerrest.workerrestapplication.service.TeamService;
import eu.mrndesign.matned.workerrest.workerrestapplication.service.WorkerService;
import eu.mrndesign.matned.workerrest.workerrestapplication.utils.JsonOps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class})
@SpringBootTest
@ActiveProfiles("Test")
@AutoConfigureMockMvc
class TeamControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TeamService teamService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private TeamRepository teamRepository;



    @Test
    @DisplayName("GET /orders test - all orders found with status 200")
    void getAllTeams() throws Exception {

    }

}