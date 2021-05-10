package eu.mrndesign.matned.workerrest.workerrestapplication.exception;

import eu.mrndesign.matned.workerrest.workerrestapplication.utils.ExceptionMessages;

public class TeamDoesntContainMemberException extends RuntimeException{

    public TeamDoesntContainMemberException() {
        super(ExceptionMessages.TEAM_DOESNT_CONTAIN_MEMBER);
    }
}
