package eu.mrndesign.matned.workerrest.workerrestapplication.controller;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.TeamDTO;
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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static eu.mrndesign.matned.workerrest.workerrestapplication.utils.JsonOps.asJsonString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;
    @MockBean
    private WorkerService workerService;



    @Test
    @DisplayName("GET /orders test - all orders found with status 200")
    void getAllTeams() throws Exception {
        List<TeamDTO> teams = Arrays.asList( new TeamDTO("team1"), new TeamDTO("team1"));
        Mockito.doReturn(teams).when(teamService).findAll();
        mockMvc.perform(
                MockMvcRequestBuilders.get("/team")
                        .accept("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().json(asJsonString(teams)))
                .andReturn();
    }

    @Test
    void saveTeam() throws Exception {
        TeamDTO team = new TeamDTO("team1");
        Mockito.doReturn(team).when(teamService).save(any());
        mockMvc.perform(
                MockMvcRequestBuilders.post("/team")
                        .content(asJsonString(team))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().json(asJsonString(team)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void saveTeamFailsWhenTooLongName() throws Exception {
        TeamDTO team = new TeamDTO("12345678901234567890123456789012345678901234567890123");
        Mockito.doReturn(team).when(teamService).save(any());
        mockMvc.perform(
                MockMvcRequestBuilders.post("/team")
                        .content(asJsonString(team))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void editTeam() {
        //        TODO
    }

    @Test
    void deleteTeam() {
        //        TODO
    }

    @Test
    void getTeamById() {
    }

    @Test
    void getTeamsByWorker() {
        //        TODO
    }

    @Test
    void addTeamMember() {
        //        TODO
    }

    @Test
    void removeTeamMember() {
        //        TODO
    }
}