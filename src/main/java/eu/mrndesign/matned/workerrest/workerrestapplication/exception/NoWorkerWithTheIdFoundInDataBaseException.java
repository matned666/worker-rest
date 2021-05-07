package eu.mrndesign.matned.workerrest.workerrestapplication.exception;

import eu.mrndesign.matned.workerrest.workerrestapplication.utils.ExceptionMessages;

public class NoWorkerWithTheIdFoundInDataBaseException extends RuntimeException{

    public NoWorkerWithTheIdFoundInDataBaseException() {
        super(ExceptionMessages.NO_WORKER_WITH_THE_ID_FOUND_IN_DATABASE);
    }
}
