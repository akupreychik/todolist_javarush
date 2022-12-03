package com.javarush.hibernate_project.services;

import com.javarush.hibernate_project.command.UserCommand;
import com.javarush.hibernate_project.dto.UserDTO;

public interface UserService {

    void createUser(UserCommand userCommand);

    UserDTO getUserById(Long id);

    UserDTO getUserByUsername(String username);
}
