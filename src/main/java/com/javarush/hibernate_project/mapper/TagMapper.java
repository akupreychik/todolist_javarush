package com.javarush.hibernate_project.mapper;

import com.javarush.hibernate_project.command.TagCommand;
import com.javarush.hibernate_project.dto.TagDTO;
import com.javarush.hibernate_project.model.Tag;
import org.mapstruct.Mapper;

@Mapper
public interface TagMapper {

    TagMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(TagMapper.class);

    TagDTO mapToDTO(Tag tag);

    Tag mapToEntity(TagCommand tagCommand);
}
