package eu.mrndesign.matned.workerrest.workerrestapplication.repository;

import eu.mrndesign.matned.workerrest.workerrestapplication.model.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {

    @Query("select w from WorkerEntity w join w.teams t where t.id = ?1")
    List<WorkerEntity> findAllWorkersByTeamId(Long teamId);

}
