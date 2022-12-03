package com.javarush.hibernate_project.mapper;

import com.javarush.hibernate_project.command.UserCommand;
import com.javarush.hibernate_project.dto.UserDTO;
import com.javarush.hibernate_project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapToEntity(UserCommand userCommand);

    UserDTO mapToDTO(User user);

}
