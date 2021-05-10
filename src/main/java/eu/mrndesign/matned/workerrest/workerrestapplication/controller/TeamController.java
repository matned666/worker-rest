package eu.mrndesign.matned.workerrest.workerrestapplication.controller;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.TeamDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.dto.WorkerDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.service.ITeamService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final ITeamService<TeamDTO, WorkerDTO> teamService;

    public TeamController(ITeamService<TeamDTO, WorkerDTO> teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamDTO> getAllTeams(){
        return teamService.findAll();
    }

    @PostMapping
    public TeamDTO saveTeam(@Valid @RequestBody TeamDTO team){
        return teamService.save(team);
    }

    @PostMapping("/{id}")
    public TeamDTO editTeam(@PathVariable Long id,
                            @Valid @RequestBody TeamDTO data){
        return teamService.edit(id, data);
    }

    @DeleteMapping("/{id}")
    public List<TeamDTO> deleteTeam(@PathVariable Long id){
        return teamService.deleteById(id);
    }

    @GetMapping("/{id}")
    public TeamDTO getTeamById(@PathVariable Long id){
        return teamService.findById(id);
    }

    @GetMapping("/worker/{id}")
    public List<TeamDTO> getAllWorkerTeams(@PathVariable Long id){
        return teamService.findAllByB(id);
    }

    @PostMapping("/worker/{teamId}/{workerId}")
    public List<WorkerDTO> addTeamMember(@PathVariable Long teamId,
                                         @PathVariable Long workerId){
        return teamService.addWorkerById(teamId, workerId);
    }

    @DeleteMapping("/worker/{teamId}/{workerId}")
    public List<WorkerDTO> removeTeamMember(@PathVariable Long teamId,
                                         @PathVariable Long workerId){
        return teamService.removeWorkerById(teamId, workerId);
    }


}
