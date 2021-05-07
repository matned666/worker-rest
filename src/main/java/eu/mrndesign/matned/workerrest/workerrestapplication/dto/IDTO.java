package eu.mrndesign.matned.workerrest.workerrestapplication.dto;

import eu.mrndesign.matned.workerrest.workerrestapplication.model.WorkerEntity;

public interface IDTO <DTO, Entity> {

    public DTO applyNew(Entity data);

}
