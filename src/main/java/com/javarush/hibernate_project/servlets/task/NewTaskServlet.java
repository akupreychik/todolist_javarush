package com.javarush.hibernate_project.servlets.task;

import com.javarush.hibernate_project.command.TaskCommand;
import com.javarush.hibernate_project.enums.TaskPriority;
import com.javarush.hibernate_project.enums.TaskStatus;
import com.javarush.hibernate_project.services.TagService;
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
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static com.javarush.hibernate_project.consts.WebConstants.*;

@WebServlet(name = "newTaskServlet", value = "/new-task")
public class NewTaskServlet extends HttpServlet {

    private TaskService taskService;
    private UserService userService;
    private TagService tagService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        taskService = (TaskService) context.getAttribute(TASK_SERVICE);
        userService = (UserService) context.getAttribute(USER_SERVICE);
        tagService = (TagService) context.getAttribute(TAG_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        addAttributes(req);
        req.getRequestDispatcher("/task/new_task.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //String username = (String) req.getSession().getAttribute("user");
        String username = "yqpuss";
        if (ObjectUtils.anyNull(username)) {
            resp.sendRedirect("/hibernate_project_war_exploded/login");
        }
        TaskCommand taskCommand = buildTaskCommand(req, username);
        taskService.save(taskCommand);
        resp.sendRedirect("/hibernate_project_war_exploded/table-task");
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
                .tags(tagService.getTagsByIds(convertTagsIds(req.getParameterValues("taskTags"))))
                .build();
    }

    private Set<Long> convertTagsIds(String[] tags) {
        return Arrays.stream(tags)
                .map(Long::parseLong)
                .collect(Collectors.toSet());
    }

    private void addAttributes(HttpServletRequest req) {
        req.setAttribute(STATUSES, taskService.getAllStatuses());
        req.setAttribute(PRIORITIES, taskService.getAllPriorities());
        req.setAttribute(TAGS, tagService.getAll());
    }
}
