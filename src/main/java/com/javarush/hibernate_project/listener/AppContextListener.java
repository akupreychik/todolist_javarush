package com.javarush.hibernate_project.listener;

import com.javarush.hibernate_project.components.PasswordHashing;
import com.javarush.hibernate_project.provider.Provider;
import com.javarush.hibernate_project.provider.SessionProvider;
import com.javarush.hibernate_project.repositories.TagRepository;
import com.javarush.hibernate_project.repositories.TaskRepository;
import com.javarush.hibernate_project.repositories.UserRepository;
import com.javarush.hibernate_project.services.TagService;
import com.javarush.hibernate_project.services.TaskService;
import com.javarush.hibernate_project.services.UserService;
import com.javarush.hibernate_project.services.impl.TagServiceImpl;
import com.javarush.hibernate_project.services.impl.TaskServiceImpl;
import com.javarush.hibernate_project.services.impl.UserServiceImpl;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.javarush.hibernate_project.consts.WebConstants.*;

@WebListener
public class AppContextListener implements ServletContextListener {

    private static final String CONTEXT_INITIALIZED = "Context initialized";
    private final Logger logger = LogManager.getLogger(AppContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();

        PasswordHashing passwordHashing = new PasswordHashing();
        SessionProvider sessionProvider = new Provider();

        UserRepository userRepository = new UserRepository(sessionProvider.getSessionFactory());
        TaskRepository taskRepository = new TaskRepository(sessionProvider.getSessionFactory());
        TagRepository tagRepository = new TagRepository(sessionProvider.getSessionFactory());

        UserService userService = new UserServiceImpl(userRepository, passwordHashing);
        TaskService taskService = new TaskServiceImpl(taskRepository);
        TagService tagService = new TagServiceImpl(tagRepository);

        context.setAttribute(USER_SERVICE, userService);
        context.setAttribute(TASK_SERVICE, taskService);
        context.setAttribute(TAG_SERVICE, tagService);
        logger.info(CONTEXT_INITIALIZED);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
