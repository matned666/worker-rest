package eu.mrndesign.matned.workerrest.workerrestapplication.exception;

import eu.mrndesign.matned.workerrest.workerrestapplication.utils.ExceptionMessages;

public class NullDataProvidedException extends RuntimeException{

    public NullDataProvidedException() {
        super(ExceptionMessages.NULL_DATA_PROVIDED);
    }
}
