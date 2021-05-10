package eu.mrndesign.matned.workerrest.workerrestapplication.dto;

import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NullEntityDataProvidedException;
import eu.mrndesign.matned.workerrest.workerrestapplication.model.WorkerEntity;
import eu.mrndesign.matned.workerrest.workerrestapplication.utils.Patterns;

import java.util.Objects;

public class WorkerDTO extends BaseDTO implements IDTO<WorkerDTO, WorkerEntity> {


    private Long id;
    private String name;
    private Double salary;
    private String employmentDate;

    public WorkerDTO() {
    }

    private WorkerDTO(String name, Double salary, String employmentDate) {
        this.name = name;
        this.salary = salary;
        this.employmentDate = employmentDate;
    }

    @Override
    public WorkerDTO applyNew(WorkerEntity entity) {
        if (entity != null)
            if (entity.getActiveWorker() != null)
                return new WorkerDTO(
                        entity.getName(),
                        entity.getActiveWorker().getSalary(),
                        Patterns.getDateToString(entity.getActiveWorker().getEmploymentDate()))
                        .applyId(entity.getId());
            else return new WorkerDTO(entity.getName(), null, null);
        else throw new NullEntityDataProvidedException();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    private WorkerDTO applyId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerDTO workerDTO = (WorkerDTO) o;
        return Objects.equals(id, workerDTO.id) && Objects.equals(name, workerDTO.name) && Objects.equals(salary, workerDTO.salary) && Objects.equals(employmentDate, workerDTO.employmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, employmentDate);
    }
}
