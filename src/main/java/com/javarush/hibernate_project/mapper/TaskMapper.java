package com.javarush.hibernate_project.mapper;


import com.javarush.hibernate_project.command.TaskCommand;
import com.javarush.hibernate_project.dto.TaskDTO;
import com.javarush.hibernate_project.model.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(TaskMapper.class);

    Task mapToEntity(TaskCommand taskCommand);

    TaskDTO mapToDTO(Task task);

    Task mapToEntity(TaskDTO taskDTO);
}
