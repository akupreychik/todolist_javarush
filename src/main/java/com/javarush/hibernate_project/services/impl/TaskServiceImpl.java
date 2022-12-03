package com.javarush.hibernate_project.services.impl;

import com.javarush.hibernate_project.command.TaskCommand;
import com.javarush.hibernate_project.dto.TaskDTO;
import com.javarush.hibernate_project.enums.TaskPriority;
import com.javarush.hibernate_project.enums.TaskStatus;
import com.javarush.hibernate_project.exceptions.CreatingEntityException;
import com.javarush.hibernate_project.mapper.TaskMapper;
import com.javarush.hibernate_project.middleware.Middleware;
import com.javarush.hibernate_project.middleware.TaskMiddleware;
import com.javarush.hibernate_project.model.Task;
import com.javarush.hibernate_project.repositories.TaskRepository;
import com.javarush.hibernate_project.services.TaskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private static final String TASK_SAVED = "Task saved";
    private static final String ERROR_WHILE_SAVING_TASK = "Error while saving task";
    private final Logger logger = LogManager.getLogger(TaskServiceImpl.class);

    private final TaskRepository taskRepository;
    private final Middleware middleware;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.taskMapper = TaskMapper.INSTANCE;
        this.middleware = Middleware.link(
                new TaskMiddleware());

    }

    @Override
    public void save(TaskCommand taskCommand) throws CreatingEntityException {
        try {
            if (middleware.check(taskCommand)) {
                taskRepository.save(taskMapper.mapToEntity(taskCommand));
                logger.info(TASK_SAVED);
            }
        } catch (Exception e) {
            logger.error(ERROR_WHILE_SAVING_TASK, e);
            throw new CreatingEntityException(ERROR_WHILE_SAVING_TASK, Task.class);
        }
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        return taskMapper.mapToDTO(taskRepository.findById(id));
    }

    @Override
    public List<TaskStatus> getAllStatuses() {
        return TaskStatus.getAll();
    }

    @Override
    public List<TaskPriority> getAllPriorities() {
        return TaskPriority.getAll();
    }
}
