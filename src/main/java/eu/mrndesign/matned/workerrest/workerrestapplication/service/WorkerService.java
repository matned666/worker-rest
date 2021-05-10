package eu.mrndesign.matned.workerrest.workerrestapplication.service;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.WorkerDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NoWorkerWithTheIdFoundInDataBaseException;
import eu.mrndesign.matned.workerrest.workerrestapplication.model.WorkerEntity;
import eu.mrndesign.matned.workerrest.workerrestapplication.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService extends BaseService implements IService<WorkerDTO> {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<WorkerDTO> findAll() {
        return workerRepository.findAll().stream()
                .map(x->new WorkerDTO().applyNew(x))
                .collect(Collectors.toList());
    }

    @Override
    public WorkerDTO findById(Long id) {
        return new WorkerDTO().applyNew(workerRepository.findById(id).orElseThrow(NoWorkerWithTheIdFoundInDataBaseException::new));
    }

    @Override
    public List<WorkerDTO> deleteById(Long id) {
        workerRepository.deleteById(id);
        return findAll();
    }

    @Override
    public WorkerDTO save(WorkerDTO dto) {
        WorkerEntity entity = new WorkerEntity().applyNew(dto);
        return new WorkerDTO().applyNew(workerRepository.save(entity));
    }

    @Override
    public WorkerDTO edit(Long id, WorkerDTO data) {
        WorkerEntity toEdit = workerRepository.findById(id).orElseThrow(NoWorkerWithTheIdFoundInDataBaseException::new);
        toEdit.applyNew(data);
        return new WorkerDTO().applyNew(workerRepository.save(toEdit));
    }
}
