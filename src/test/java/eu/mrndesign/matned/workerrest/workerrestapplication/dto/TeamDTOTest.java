package eu.mrndesign.matned.workerrest.workerrestapplication.dto;

import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NullDataProvidedException;
import eu.mrndesign.matned.workerrest.workerrestapplication.model.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamDTOTest {

    @Test
    void throwsExceptionWhenEmptyDataProvided(){
        TeamDTO t1 = null;
        assertThrows(NullDataProvidedException.class, () -> new Team().applyNew(t1));
    }

    @Test
    void applyNewChangesEntityToDtoCorrectly() {
        Team entity = new Team().applyNew(new TeamDTO("rower"));
        TeamDTO dto = new TeamDTO().applyNew(entity);

        assertEquals(entity.getTeamName(), dto.getName());


    }
}