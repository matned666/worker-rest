package eu.mrndesign.matned.workerrest.workerrestapplication.model;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.WorkerDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NullDataProvidedException;
import eu.mrndesign.matned.workerrest.workerrestapplication.utils.SqlNames;

import javax.persistence.*;

@Entity
@Table(name = SqlNames.WORKER)
public class WorkerEntity  extends BaseEntity implements IEntityApply<WorkerEntity, WorkerDTO> {

    @Override
    public WorkerEntity applyNew(WorkerDTO editedData) {
        this.name = editedData.getName();
        this.activeWorker = new ActiveWorker().applyNew(editedData);
        return this;
    }

    @Override
    public void applyChanges(WorkerDTO editedData) {
        if (editedData != null) {
            this.name = editedData.getName();
            this.activeWorker.applyChanges(editedData);
        }else throw new NullDataProvidedException();
    }

    @Column(name = SqlNames.NAME)
    private String name;

    @Embedded
    private ActiveWorker activeWorker;

    public String getName() {
        return name;
    }

    public ActiveWorker getActiveWorker() {
        return activeWorker;
    }
}