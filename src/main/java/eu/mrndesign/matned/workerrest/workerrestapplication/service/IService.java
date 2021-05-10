package eu.mrndesign.matned.workerrest.workerrestapplication.service;

import java.util.List;

public interface IService<E> {

    List<E> findAll();
    E findById(Long id);
    List<E> deleteById(Long id);
    E save(E dto);
    E edit(Long id, E data);

}
