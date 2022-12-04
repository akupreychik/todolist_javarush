package com.javarush.hibernate_project.servlets.task;

import com.javarush.hibernate_project.dto.TaskDTO;
import com.javarush.hibernate_project.dto.UserDTO;
import com.javarush.hibernate_project.services.TaskService;
import com.javarush.hibernate_project.services.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.javarush.hibernate_project.consts.WebConstants.*;

@WebServlet(name = "newTaskServlet", value = "/table-task")
public class TableTaskServlet extends HttpServlet {

    private TaskService taskService;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        taskService = (TaskService) context.getAttribute(TASK_SERVICE);
        userService = (UserService) context.getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentUser = getUserNameFromSession(req);
        UserDTO user = userService.getUserByUsername(currentUser);
        List<TaskDTO> tasks = taskService.findTasksByUserId(user.getId());
        req.setAttribute("username", currentUser);
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("/task/table_task.jsp").forward(req, resp);
    }

    private String getUserNameFromSession(HttpServletRequest req) {
        return (String) req.getSession().getAttribute(USER_ATTRIBUTE);
    }
}
