package eu.mrndesign.matned.workerrest.workerrestapplication.dto;

import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NullEntityDataProvidedException;
import eu.mrndesign.matned.workerrest.workerrestapplication.model.Team;

import javax.validation.constraints.Size;
import java.util.Objects;

public class TeamDTO extends BaseDTO implements IDTO<TeamDTO, Team> {

    private Long id;

    @Size(max = 50, message = "Name can to be max {max} characters long")
    private String name;

    public TeamDTO() {
    }

    public TeamDTO(String name) {
        this.name = name;
    }

    @Override
    public TeamDTO applyNew(Team data) {
        if (data != null) {
            this.name = data.getTeamName();
            this.applyId(data.getId());
            return this;
        }
        else throw new NullEntityDataProvidedException();
    }

    public String getName() {
        return name;
    }

    private TeamDTO applyId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamDTO teamDTO = (TeamDTO) o;
        return Objects.equals(id, teamDTO.id) && Objects.equals(name, teamDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
