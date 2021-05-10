package eu.mrndesign.matned.workerrest.workerrestapplication.model;

import eu.mrndesign.matned.workerrest.workerrestapplication.dto.WorkerDTO;
import eu.mrndesign.matned.workerrest.workerrestapplication.utils.Patterns;

import javax.persistence.*;
import java.time.LocalDate;

import static eu.mrndesign.matned.workerrest.workerrestapplication.utils.SqlNames.*;

@Embeddable
public class ActiveWorker implements IEntityApply<ActiveWorker, WorkerDTO>{


    @Override
    public ActiveWorker applyNew(WorkerDTO editedData) {
        applyInner(editedData);
        return this;
    }

    @Column(name = SALARY)
    private Double salary;

    @Column(name = DATE_OF_EMPLOYMENT)
    private LocalDate employmentDate;

    public Double getSalary() {
        return salary;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    private void applyInner(WorkerDTO editedData) {
        this.salary = editedData.getSalary();
        this.employmentDate = Patterns.getDateFromString(editedData.getEmploymentDate());
    }

}
