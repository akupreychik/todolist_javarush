package com.javarush.hibernate_project.services.impl;

import com.javarush.hibernate_project.command.UserCommand;
import com.javarush.hibernate_project.components.PasswordHashing;
import com.javarush.hibernate_project.dto.UserDTO;
import com.javarush.hibernate_project.exceptions.CreatingEntityException;
import com.javarush.hibernate_project.exceptions.PasswordHashingException;
import com.javarush.hibernate_project.mapper.UserMapper;
import com.javarush.hibernate_project.middleware.Middleware;
import com.javarush.hibernate_project.middleware.UserDataMiddleware;
import com.javarush.hibernate_project.middleware.UserPasswordMiddleware;
import com.javarush.hibernate_project.model.User;
import com.javarush.hibernate_project.repositories.UserRepository;
import com.javarush.hibernate_project.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserServiceImpl implements UserService {

    private static final String USER_WAS_NOT_CREATED = "User was not created. ";
    private static final String VALIDATION_FAILED = "Validation failed";
    private static final String USER_WAS_CREATED_SUCCESSFULLY = "User was created successfully";
    private final UserRepository userRepository;
    private final PasswordHashing passwordHashing;
    private final UserMapper userMapper;
    private final Middleware middleware;

    private final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, PasswordHashing passwordHashing) {
        this.userRepository = userRepository;
        this.passwordHashing = passwordHashing;
        this.userMapper = UserMapper.INSTANCE;
        this.middleware = Middleware.link(
                new UserPasswordMiddleware(),
                new UserDataMiddleware());
    }

    @Override
    public void createUser(UserCommand userCommand) {
        try {
            User user = userMapper.mapToEntity(userCommand);
            if (middleware.check(userCommand)) {
                saveUser(userCommand, user);
                logger.info(USER_WAS_CREATED_SUCCESSFULLY);
            } else {
                throw new CreatingEntityException(USER_WAS_NOT_CREATED + VALIDATION_FAILED, User.class);
            }
        } catch (Exception e) {
            throw new CreatingEntityException(USER_WAS_NOT_CREATED, User.class);
        }
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id);
        logger.info("User was found successfully");
        return userMapper.mapToDTO(user);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        logger.info("User was found successfully");
        return userMapper.mapToDTO(user);
    }

    private void saveUser(UserCommand userCommand, User user) throws PasswordHashingException {
        user.setPassword(passwordHashing.hashPassword(userCommand.getPassword()));
        userRepository.save(user);
    }
}
