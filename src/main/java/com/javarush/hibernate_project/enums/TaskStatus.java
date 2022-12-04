package com.javarush.hibernate_project.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public enum TaskStatus {
    OPEN("Open"),
    IN_PROGRESS("In progress"),
    DONE("Done");

    private final String status;

    public static TaskStatus getByStatus(String status) {
        for (TaskStatus taskStatus : values()) {
            if (taskStatus.getStatus().equals(status)) {
                return taskStatus;
            }
        }
        return null;
    }

    public static List<TaskStatus> getAll() {
        return List.of(values());
    }
}
