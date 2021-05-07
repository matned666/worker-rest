package eu.mrndesign.matned.workerrest.workerrestapplication.repository;

import eu.mrndesign.matned.workerrest.workerrestapplication.model.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {
}
