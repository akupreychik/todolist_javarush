package com.javarush.hibernate_project.servlets.task;

import com.javarush.hibernate_project.dto.TaskDTO;
import com.javarush.hibernate_project.enums.WebMethodsType;
import com.javarush.hibernate_project.services.TaskCommentService;
import com.javarush.hibernate_project.services.TaskService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.javarush.hibernate_project.consts.WebConstants.TASK_COMMENT_SERVICE;
import static com.javarush.hibernate_project.consts.WebConstants.TASK_SERVICE;

@WebServlet(name = "taskInformationServlet", value = "/task")
public class TaskInformation extends HttpServlet {

    private TaskService taskService;
    private TaskCommentService taskCommentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        taskService = (TaskService) context.getAttribute(TASK_SERVICE);
        taskCommentService = (TaskCommentService) context.getAttribute(TASK_COMMENT_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        TaskDTO task = taskService.getTaskById(id);
        if(req.getParameter("action") != null) {
            WebMethodsType method = WebMethodsType.valueOf(req.getParameter("action"));
            deleteAction(req, resp, id, method);
        } else {
            task.setComments(taskCommentService.findCommentsByTaskId(id));
            req.setAttribute("task", task);
        }
        req.getRequestDispatcher("/task/info_task.jsp").forward(req, resp);
    }

    private void deleteAction(HttpServletRequest req, HttpServletResponse resp, Long id, WebMethodsType method) throws ServletException, IOException {
        if (method == WebMethodsType.DELETE) {
            taskService.deleteTaskById(id);
            req.getRequestDispatcher("/task/table_task.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
