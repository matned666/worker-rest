package eu.mrndesign.matned.workerrest.workerrestapplication.exception;

import eu.mrndesign.matned.workerrest.workerrestapplication.utils.ExceptionMessages;

public class WrongDateFormatException extends RuntimeException{

    public WrongDateFormatException() {
        super(ExceptionMessages.WRONG_DATE_FORMAT);
    }
}
