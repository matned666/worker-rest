package eu.mrndesign.matned.workerrest.workerrestapplication.model;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.WorkerDTO;

import javax.persistence.*;
import java.util.Date;

import static eu.mrndesign.matned.workerrest.workerrestapplication.utils.SqlNames.*;

@Embeddable
public class ActiveWorker implements IEntityApply<ActiveWorker, WorkerDTO> {


    @Override
    public ActiveWorker applyNew(WorkerDTO editedData) {
        this.salary = editedData.getSalary();
        this.employmentDate = editedData.getEmploymentDate();
        return this;
    }

    @Column(name = SALARY)
    private Double salary;

    @Column(name = DATE_OF_EMPLOYMENT)
    private Date employmentDate;

    public Double getSalary() {
        return salary;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }
}
