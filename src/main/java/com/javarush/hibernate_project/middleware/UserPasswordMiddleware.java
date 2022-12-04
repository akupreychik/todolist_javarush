package com.javarush.hibernate_project.middleware;

import com.javarush.hibernate_project.command.Command;
import com.javarush.hibernate_project.command.UserCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserPasswordMiddleware extends Middleware {

    private final Logger logger = LogManager.getLogger(UserPasswordMiddleware.class);
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

    public boolean check(Command command) {
        UserCommand userCommand = (UserCommand) command;
        if (userCommand.getPassword().matches(PASSWORD_REGEX)) {
            return checkNext(command);
        }
        logger.error("Password is not valid");
        return false;
    }

}
