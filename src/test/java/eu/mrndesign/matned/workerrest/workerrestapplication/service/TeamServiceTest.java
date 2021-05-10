package eu.mrndesign.matned.workerrest.workerrestapplication.service;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.TeamDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NullDataProvidedException;
import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NullEntityDataProvidedException;
import eu.mrndesign.matned.workerrest.workerrestapplication.model.Team;
import eu.mrndesign.matned.workerrest.workerrestapplication.repository.TeamRepository;
import eu.mrndesign.matned.workerrest.workerrestapplication.repository.WorkerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith({SpringExtension.class})
@SpringBootTest
class TeamServiceTest {

    @Autowired
    private TeamService teamService;

    @MockBean
    private TeamRepository teamRepository;
    @MockBean
    private WorkerRepository workerRepository;

    @Test
    void findAll() {
       TeamDTO t1 = new TeamDTO("team1");
       TeamDTO t2 = new TeamDTO("team2");
        List<TeamDTO> teamDTOList = Arrays.asList( t1, t2);
        List<Team> teamEntityList = Arrays.asList( new Team().applyNew(t1), new Team().applyNew(t2));
        doReturn(teamEntityList).when(teamRepository).findAll();
        System.out.println("check");
        assertEquals(teamService.findAll(), teamDTOList);
    }

    @Test
    void findAllThrowsExceptionWhenEmptyDataProvided(){
        doReturn(null).when(teamRepository).save(any());
        assertThrows(NullDataProvidedException.class, () -> teamService.save(null));
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void save() {
    }

    @Test
    void edit() {
    }

    @Test
    void findAllByB() {
    }

    @Test
    void findAllByA() {
    }

    @Test
    void addWorkerById() {
    }

    @Test
    void removeWorkerById() {
    }
}