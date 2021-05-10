package eu.mrndesign.matned.workerrest.workerrestapplication.repository;

import eu.mrndesign.matned.workerrest.workerrestapplication.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("select t from Team t join t.workers w where w.id = ?1")
    List<Team> findAllWorkerTeams(Long workerId);

}
