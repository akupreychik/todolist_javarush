package com.javarush.hibernate_project.servlets.user;

import com.javarush.hibernate_project.command.UserCommand;
import com.javarush.hibernate_project.services.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import static com.javarush.hibernate_project.consts.WebConstants.USER_ATTRIBUTE;
import static com.javarush.hibernate_project.consts.WebConstants.USER_SERVICE;

@WebServlet(name = "userCreatingServlet", value = "/user-sign-up")
public class UserSignUpServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute(USER_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/user/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCommand userCommand = buildUserCommand(req);
        userService.createUser(userCommand);
        putUsernameToCurrentSession(req, userCommand);
        resp.sendRedirect("/table");
    }

    private UserCommand buildUserCommand(HttpServletRequest req) {
        return UserCommand.builder()
                .email(req.getParameter("email"))
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .password(req.getParameter("password"))
                .username(req.getParameter("username"))
                .build();
    }

    private void putUsernameToCurrentSession(HttpServletRequest req, UserCommand userCommand) {
        HttpSession session = req.getSession();
        session.setAttribute(USER_ATTRIBUTE, userCommand.getUsername());
    }
}
