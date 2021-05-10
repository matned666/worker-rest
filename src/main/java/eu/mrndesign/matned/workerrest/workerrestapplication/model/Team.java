package eu.mrndesign.matned.workerrest.workerrestapplication.model;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.TeamDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NullDataProvidedException;
import eu.mrndesign.matned.workerrest.workerrestapplication.exception.TeamDoesntContainMemberException;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "TEAM_ENTITY")
public class Team extends BaseEntity implements IEntityApply<Team, TeamDTO>, IEntity<Team, WorkerEntity> {

    @Column(name = "NAME", length = 50)
    private String teamName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<WorkerEntity> workers;

    public String getTeamName() {
        return teamName;
    }

    @Override
    public Team applyNew(TeamDTO editedData) {
        if (editedData != null) {
            this.teamName = editedData.getName();
            return this;
        } else throw new NullDataProvidedException();
    }

    @Override
    public void addToList(WorkerEntity added) {
        if (workers == null)
            workers = new LinkedList<>();
        workers.add(added);
    }

    @Override
    public void removeFromList(WorkerEntity added) {
        if (workers == null)
            throw new TeamDoesntContainMemberException();
        else {
            if (!workers.contains(added))
                throw new TeamDoesntContainMemberException();
            else workers.remove(added);
        }
    }
}
