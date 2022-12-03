package com.javarush.hibernate_project.exceptions;

public class PasswordHashingException extends Exception {
    public PasswordHashingException(String message) {
        super(message);
    }
}
