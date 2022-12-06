package com.javarush.hibernate_project.services.impl;

import com.javarush.hibernate_project.command.TaskCommentCommand;
import com.javarush.hibernate_project.dto.TaskCommentDTO;
import com.javarush.hibernate_project.dto.TaskDTO;
import com.javarush.hibernate_project.dto.UserDTO;
import com.javarush.hibernate_project.mapper.TaskCommentMapper;
import com.javarush.hibernate_project.mapper.TaskMapper;
import com.javarush.hibernate_project.mapper.UserMapper;
import com.javarush.hibernate_project.model.Task;
import com.javarush.hibernate_project.model.TaskComment;
import com.javarush.hibernate_project.repositories.TaskCommentRepository;
import com.javarush.hibernate_project.services.TaskCommentService;
import com.javarush.hibernate_project.services.TaskService;
import com.javarush.hibernate_project.services.UserService;

import java.util.List;

public class TaskCommentServiceImpl implements TaskCommentService {

    private final TaskCommentRepository taskCommentRepository;
    private final TaskService taskService;
    private final UserService userService;
    private final TaskCommentMapper taskCommentMapper;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    public TaskCommentServiceImpl(TaskCommentRepository taskCommentRepository,
                                  TaskService taskService,
                                  UserService userService) {
        this.taskCommentRepository = taskCommentRepository;
        this.taskService = taskService;
        this.userService = userService;
        taskCommentMapper = TaskCommentMapper.INSTANCE;
        userMapper = UserMapper.INSTANCE;
        taskMapper = TaskMapper.INSTANCE;
    }

    @Override
    public void save(TaskCommentCommand taskCommentCommand) {
        TaskDTO taskToAddComment = taskService.getTaskById(taskCommentCommand.getTaskId());
        UserDTO userWhoAddsComment = userService.getUserById(taskCommentCommand.getUserId());
        TaskComment taskComment = taskCommentMapper.mapToEntity(taskCommentCommand);
        taskComment.setTask(taskMapper.mapToEntity(taskToAddComment));
        taskComment.setUser(userMapper.mapToEntity(userWhoAddsComment));
        taskCommentRepository.save(taskComment);
    }

    @Override
    public List<TaskCommentDTO> findCommentsByTaskId(Long id) {
        return taskCommentRepository.findByTaskId(id);
    }
}
