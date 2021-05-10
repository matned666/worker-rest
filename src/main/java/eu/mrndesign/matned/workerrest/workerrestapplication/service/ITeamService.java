package eu.mrndesign.matned.workerrest.workerrestapplication.service;

import java.util.List;

public interface ITeamService <A, B> extends IService<A>{

    List<A> findAllByB(Long aId);

    List<B> findAllByA(Long bId);

    List<B> addWorkerById(Long teamId, Long workerId);

    List<B> removeWorkerById(Long teamId, Long workerId);
}
