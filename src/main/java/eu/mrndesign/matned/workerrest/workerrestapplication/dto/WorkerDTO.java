package eu.mrndesign.matned.workerrest.workerrestapplication.dto;

import eu.mrndesign.matned.workerrest.workerrestapplication.exception.NullEntityDataProvidedException;
import eu.mrndesign.matned.workerrest.workerrestapplication.model.WorkerEntity;

import java.util.Date;

public class WorkerDTO extends BaseDTO implements IDTO<WorkerDTO, WorkerEntity>{



    private String name;
    private Double salary;
    private Date employmentDate;

    public WorkerDTO() {
    }

    private WorkerDTO(String name, Double salary, Date employmentDate) {
        this.name = name;
        this.salary = salary;
        this.employmentDate = employmentDate;
    }

    @Override
    public WorkerDTO applyNew(WorkerEntity entity){
        if (entity != null)
            return new WorkerDTO(
                    entity.getName(),
                    entity.getActiveWorker() != null? entity.getActiveWorker().getSalary(): null,
                    entity.getActiveWorker() != null? entity.getActiveWorker().getEmploymentDate(): null);
        else throw new NullEntityDataProvidedException();
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }
}
