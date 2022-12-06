package com.javarush.hibernate_project.servlets.comments;

import com.javarush.hibernate_project.command.TaskCommentCommand;
import com.javarush.hibernate_project.services.TaskCommentService;
import com.javarush.hibernate_project.services.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.javarush.hibernate_project.consts.WebConstants.*;

@WebServlet(name = "newTaskCommentServlet", value = "/new-task-comment")
public class NewTaskCommentServlet extends HttpServlet {

    private TaskCommentService taskCommentService;
    private UserService userService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        taskCommentService = (TaskCommentService) context.getAttribute(TASK_COMMENT_SERVICE);
        userService = (UserService) context.getAttribute(USER_SERVICE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskCommentCommand taskCommentCommand = buildTaskCommentCommand(req);
        taskCommentService.save(taskCommentCommand);
        resp.sendRedirect("/hibernate_project_war_exploded/task?id=" + taskCommentCommand.getTaskId());
    }

    private TaskCommentCommand buildTaskCommentCommand(HttpServletRequest req) {
        return TaskCommentCommand.builder()
                .comment(req.getParameter("comment"))
                .taskId(Long.parseLong(req.getParameter("taskId")))
                .userId(userService.getUserByUsername(getUserNameFromSession(req)).getId())
                .build();
    }

    private String getUserNameFromSession(HttpServletRequest req) {
        //return (String) req.getSession().getAttribute(USER_ATTRIBUTE);
        return "yqpuss";
    }
}
