package eu.mrndesign.matned.workerrest.workerrestapplication.model;

public interface IEntityApply<Entity, DTO>{

    Entity applyNew(DTO editedData);

}
