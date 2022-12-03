package com.javarush.hibernate_project.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public enum TaskPriority {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    private final String priority;

    public static TaskPriority getByPriority(String name) {
        for (TaskPriority taskPriority : values()) {
            if (taskPriority.getPriority().equals(name)) {
                return taskPriority;
            }
        }
        return null;
    }

    public static List<TaskPriority> getAll() {
        return List.of(values());
    }
}
