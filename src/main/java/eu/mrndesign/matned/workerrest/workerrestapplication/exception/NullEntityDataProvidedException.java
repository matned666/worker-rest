package eu.mrndesign.matned.workerrest.workerrestapplication.exception;

import eu.mrndesign.matned.workerrest.workerrestapplication.utils.ExceptionMessages;

public class NullEntityDataProvidedException extends RuntimeException{

    public NullEntityDataProvidedException() {
        super(ExceptionMessages.NULL_ENTITY_DATA_PROVIDED);
    }
}
