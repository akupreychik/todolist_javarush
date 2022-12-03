package com.javarush.hibernate_project.middleware;

import com.javarush.hibernate_project.command.TaskCommand;
import com.javarush.hibernate_project.command.abstracts.AbstractCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TaskMiddleware extends Middleware {

    private final Logger logger = LogManager.getLogger(TaskMiddleware.class);

    public static final String NAME_REGEX = "^[A-Z][a-z]+$";
    public static final String DESCRIPTION_REGEX = "^[A-Z][a-z]+$";

    public static final String NAME_ERROR_MESSAGE = "Task name is not valid";


    @Override
    public boolean check(AbstractCommand command) {
        TaskCommand taskCommand = (TaskCommand) command;
        /*if (taskCommand.getTitle().matches(NAME_REGEX)
                && taskCommand.getDescription().matches(DESCRIPTION_REGEX)) {
            return checkNext(command);
        }
        logger.error(NAME_ERROR_MESSAGE);
        return false;*/
        return checkNext(command);
    }

}
