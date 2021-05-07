package eu.mrndesign.matned.workerrest.workerrestapplication.service;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.WorkerDTO;

import java.util.List;

public interface IService<E> {

    List<E> findAllWorkers();
    E findById(Long id);
    List<E> deleteById(Long id);
    E save(E dto);
    E edit(Long id, E data);

}
