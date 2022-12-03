package com.javarush.hibernate_project.exceptions;

public class CreatingEntityException extends RuntimeException {
    public CreatingEntityException(String message, Class clazz) {
        super(message + clazz.getSimpleName());
    }

}
