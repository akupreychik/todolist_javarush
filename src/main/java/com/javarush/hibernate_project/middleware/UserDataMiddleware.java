package com.javarush.hibernate_project.middleware;

import com.javarush.hibernate_project.command.UserCommand;
import com.javarush.hibernate_project.command.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserDataMiddleware extends Middleware {

    private final Logger logger = LogManager.getLogger(UserDataMiddleware.class);
    public static final String EMAIL_REGEX = "^(.+)@(.+)$";
    public static final String NAME_REGEX = "^[A-Z][a-z]+$";
    public static final String USERNAME_REGEX = "^[a-z0-9_-]{3,15}$";


    @Override
    public boolean check(Command command) {
        UserCommand userCommand = (UserCommand) command;
        if (userCommand.getEmail().matches(EMAIL_REGEX)
                && userCommand.getFirstName().matches(NAME_REGEX)
                && userCommand.getLastName().matches(NAME_REGEX)
                && userCommand.getUsername().matches(USERNAME_REGEX)) {
            return checkNext(command);
        }
        logger.error("User data is not valid");
        return false;
    }
}
