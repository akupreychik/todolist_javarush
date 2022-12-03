package com.javarush.hibernate_project.servlets.task;

import com.javarush.hibernate_project.command.TaskCommand;
import com.javarush.hibernate_project.enums.TaskPriority;
import com.javarush.hibernate_project.enums.TaskStatus;
import com.javarush.hibernate_project.services.TaskService;
import com.javarush.hibernate_project.services.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.ObjectUtils;

import java.io.IOException;

import static com.javarush.hibernate_project.consts.WebConstants.TASK_SERVICE;
import static com.javarush.hibernate_project.consts.WebConstants.USER_SERVICE;

@WebServlet(name = "newTaskServlet", value = "/new-task")
public class NewTaskServlet extends HttpServlet {

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
        req.setAttribute("statuses", taskService.getAllStatuses());
        req.setAttribute("priorities", taskService.getAllPriorities());
        req.getRequestDispatcher("/task/new_task.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = (String) req.getSession().getAttribute("user");
        if (ObjectUtils.anyNull(username)) {
            //resp.sendRedirect("/login");
            //return;
            username = "yqpuss";
        }
        TaskCommand taskCommand = buildTaskCommand(req, username);
        taskService.save(taskCommand);
        resp.sendRedirect("/table");
    }

    private TaskCommand buildTaskCommand(HttpServletRequest req, String username) {
        return TaskCommand.builder()
                .title(req.getParameter("taskName"))
                .description(req.getParameter("taskDescription"))
                .status(TaskStatus.getByStatus(req.getParameter("taskStatus")))
                .priority(TaskPriority.getByPriority(req.getParameter("taskPriority")))
                .userId(userService.getUserByUsername(username).getId())
                .hours(Integer.parseInt(req.getParameter("taskHours")))
                .text(req.getParameter("taskText"))
                .build();
    }
}
