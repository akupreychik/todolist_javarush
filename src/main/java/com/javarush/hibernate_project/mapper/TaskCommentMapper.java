package com.javarush.hibernate_project.mapper;

import com.javarush.hibernate_project.command.TaskCommentCommand;
import com.javarush.hibernate_project.dto.TaskCommentDTO;
import com.javarush.hibernate_project.model.TaskComment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskCommentMapper {

    TaskCommentMapper INSTANCE = Mappers.getMapper(TaskCommentMapper.class);

    TaskComment mapToEntity(TaskCommentCommand taskCommentCommand);

    TaskCommentDTO mapToDTO(TaskComment taskComment);

}
