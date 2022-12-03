package com.javarush.hibernate_project.services;

import com.javarush.hibernate_project.command.TaskCommand;
import com.javarush.hibernate_project.dto.TaskDTO;
import com.javarush.hibernate_project.enums.TaskPriority;
import com.javarush.hibernate_project.enums.TaskStatus;

import java.util.List;

public interface TaskService {
    void save(TaskCommand taskCommand);

    TaskDTO getTaskById(Long id);

    List<TaskStatus> getAllStatuses();

    List<TaskPriority> getAllPriorities();
}
