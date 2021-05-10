package eu.mrndesign.matned.workerrest.workerrestapplication.dto;


public interface IDTO <DTO, Entity> {

    DTO applyNew(Entity data);

}
