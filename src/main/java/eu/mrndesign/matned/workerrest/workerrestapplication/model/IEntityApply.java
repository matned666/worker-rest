package eu.mrndesign.matned.workerrest.workerrestapplication.model;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.WorkerDTO;

public interface IEntityApply<Entity, DTO> {

    Entity applyNew(DTO editedData);
    void applyChanges(DTO editedData);

}
