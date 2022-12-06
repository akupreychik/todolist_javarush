package com.javarush.hibernate_project.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WebMethodsType {
    GET("get"),
    POST("post"),
    PUT("put"),
    DELETE("delete");

    private final String method;

    public String getMethod() {
        return method;
    }
}
