package eu.mrndesign.matned.workerrest.workerrestapplication.service;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.TeamDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.dto.WorkerDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NoTeamWithTheIdFoundInDataBaseException;
import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NoWorkerWithTheIdFoundInDataBaseException;
import eu.mrndesign.matned.workerrest.workerrestapplication.model.Team;
import eu.mrndesign.matned.workerrest.workerrestapplication.model.WorkerEntity;
import eu.mrndesign.matned.workerrest.workerrestapplication.repository.TeamRepository;
import eu.mrndesign.matned.workerrest.workerrestapplication.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService extends BaseService implements ITeamService<TeamDTO, WorkerDTO> {

    private final TeamRepository teamRepository;
    private final WorkerRepository workerRepository;

    public TeamService(TeamRepository teamRepository,
                       WorkerRepository workerRepository) {
        this.teamRepository = teamRepository;
        this.workerRepository = workerRepository;
    }

    @Override
    public List<TeamDTO> findAll() {
        return teamRepository.findAll().stream()
                .map(x->new TeamDTO().applyNew(x))
                .collect(Collectors.toList());

    }

    @Override
    public TeamDTO findById(Long id) {
        return getTeamDTO(getTeam(id));
    }

    @Override
    public List<TeamDTO> deleteById(Long id) {
        teamRepository.deleteById(id);
        return findAll();
    }

    @Override
    public TeamDTO save(TeamDTO dto) {
        return getTeamDTO(teamRepository.save(new Team().applyNew(dto)));
    }

    @Override
    public TeamDTO edit(Long id, TeamDTO data) {
        Team toEdit = getTeam(id);
        toEdit.applyNew(data);
        return getTeamDTO(teamRepository.save(toEdit));
    }

    @Override
    public List<TeamDTO> findAllByB(Long aId) {
        return mapToDtoList(teamRepository.findAllWorkerTeams(aId));
    }

    @Override
    public List<WorkerDTO> findAllByA(Long bId) {
        return workerRepository.findAllWorkersByTeamId(bId).stream()
                .map(x->new WorkerDTO().applyNew(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkerDTO> addWorkerById(Long teamId, Long workerId) {
        Team team = getTeam(teamId);
        WorkerEntity worker = getWorker(workerId);
        team.addToList(worker);
        worker.addToList(team);
        saveTeamAndWorker(team, worker);
        return findAllByA(teamId);
    }

    @Override
    public List<WorkerDTO> removeWorkerById(Long teamId, Long workerId) {
        Team team = getTeam(teamId);
        WorkerEntity worker = getWorker(workerId);
        team.removeFromList(worker);
        worker.removeFromList(team);
        saveTeamAndWorker(team, worker);
        return findAllByA(teamId);
    }

    private List<TeamDTO> mapToDtoList(List<Team> all) {
        return all.stream()
                .map(x-> getTeamDTO(x))
                .collect(Collectors.toList());
    }

    private TeamDTO getTeamDTO(Team x) {
        return new TeamDTO().applyNew(x);
    }

    private Team getTeam(Long id) {
        return teamRepository.findById(id).orElseThrow(NoTeamWithTheIdFoundInDataBaseException::new);
    }

    private WorkerEntity getWorker(Long workerId) {
        return workerRepository.findById(workerId).orElseThrow(NoWorkerWithTheIdFoundInDataBaseException::new);
    }

    private void saveTeamAndWorker(Team team, WorkerEntity worker) {
        teamRepository.save(team);
        workerRepository.save(worker);
    }
}
