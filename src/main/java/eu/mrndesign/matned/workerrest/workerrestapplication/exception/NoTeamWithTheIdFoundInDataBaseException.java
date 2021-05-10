package eu.mrndesign.matned.workerrest.workerrestapplication.exception;

import eu.mrndesign.matned.workerrest.workerrestapplication.utils.ExceptionMessages;

public class NoTeamWithTheIdFoundInDataBaseException extends RuntimeException{

    public NoTeamWithTheIdFoundInDataBaseException() {
        super(ExceptionMessages.NO_TEAM_WITH_THE_ID_FOUND_IN_DATABASE);
    }
}
