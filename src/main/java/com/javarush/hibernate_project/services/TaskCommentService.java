package com.javarush.hibernate_project.services;

import com.javarush.hibernate_project.command.TaskCommentCommand;
import com.javarush.hibernate_project.dto.TaskCommentDTO;

import java.util.List;

public interface TaskCommentService {

    void save(TaskCommentCommand taskCommentCommand);

    List<TaskCommentDTO> findCommentsByTaskId(Long id);
}
