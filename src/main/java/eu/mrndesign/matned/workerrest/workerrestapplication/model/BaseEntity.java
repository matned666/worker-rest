package eu.mrndesign.matned.workerrest.workerrestapplication.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    private Long id;



}
