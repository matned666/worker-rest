package eu.mrndesign.matned.workerrest.workerrestapplication.model;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.WorkerDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NullDataProvidedException;
import eu.mrndesign.matned.workerrest.workerrestapplication.exception.TeamDoesntContainMemberException;
import eu.mrndesign.matned.workerrest.workerrestapplication.utils.SqlNames;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = SqlNames.WORKER)
public class WorkerEntity extends BaseEntity implements IEntityApply<WorkerEntity, WorkerDTO>, IEntity<WorkerEntity, Team> {

    @Column(name = SqlNames.NAME)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Team> teams;

    @Embedded
    private ActiveWorker activeWorker;

    public String getName() {
        return name;
    }

    public ActiveWorker getActiveWorker() {
        return activeWorker;
    }

    @Override
    public WorkerEntity applyNew(WorkerDTO editedData) {
        if (editedData != null) {
            this.name = editedData.getName();
            this.activeWorker.applyNew(editedData);
            return this;
        } else throw new NullDataProvidedException();
    }

    @Override
    public void addToList(Team added) {
        if (teams == null)
            teams = new LinkedList<>();
        teams.add(added);
    }

    @Override
    public void removeFromList(Team added) {
        if (teams == null)
            throw new TeamDoesntContainMemberException();
        else {
            if (!teams.contains(added))
                throw new TeamDoesntContainMemberException();
            else teams.remove(added);
        }
    }
}