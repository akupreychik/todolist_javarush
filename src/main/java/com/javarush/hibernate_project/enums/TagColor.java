package com.javarush.hibernate_project.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TagColor {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF"),
    YELLOW("#FFFF00"),
    BLACK("#000000"),
    WHITE("#FFFFFF");

    private final String color;
}
