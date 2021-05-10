package eu.mrndesign.matned.workerrest.workerrestapplication.controller;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.TeamDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.dto.WorkerDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.service.IService;
import eu.mrndesign.matned.workerrest.workerrestapplication.service.ITeamService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final IService<WorkerDTO> workerService;
    private final ITeamService<TeamDTO, WorkerDTO> teamService;


    public WorkerController(IService<WorkerDTO> workerService,
                            ITeamService<TeamDTO, WorkerDTO> teamService) {
        this.workerService = workerService;
        this.teamService = teamService;
    }


    @GetMapping("")
    public List<WorkerDTO> getAllWorkersData(){
        return workerService.findAll();
    }

    @PostMapping("")
    public WorkerDTO postNewWorker(@Valid @RequestBody WorkerDTO data){
        return workerService.save(data);
    }

    @GetMapping("/{id}")
    public WorkerDTO getWorkerById(@PathVariable Long id){
        return workerService.findById(id);
    }

    @PostMapping("/{id}")
    public WorkerDTO editExistingWorkerData(@PathVariable Long id,
                                            @Valid @RequestBody WorkerDTO data){
        return workerService.edit(id, data);
    }

    @DeleteMapping("/{id}")
    public List<WorkerDTO> removeWorker(@PathVariable Long id){
        return workerService.deleteById(id);
    }

    @GetMapping("/team/{id}")
    public List<TeamDTO> allWorkerTeams(@PathVariable Long id){
        return teamService.findAllByB(id);
    }

}
