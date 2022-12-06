package com.javarush.hibernate_project.servlets.tag;

import com.javarush.hibernate_project.command.TagCommand;
import com.javarush.hibernate_project.services.TagService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.javarush.hibernate_project.consts.WebConstants.TAG_SERVICE;

@WebServlet(name = "newTagServlet", value = "/new-tag")
public class NewTagServlet extends HttpServlet {

    private TagService tagService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        tagService = (TagService) context.getAttribute(TAG_SERVICE);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/tag/new_tag.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        TagCommand tagCommand = buildTagCommand(req);
        tagService.save(tagCommand);
        resp.sendRedirect("/hibernate_project_war_exploded/table-tag");
    }

    private static TagCommand buildTagCommand(HttpServletRequest req) {
        return TagCommand.builder()
                .name(req.getParameter("tagName"))
                .color(req.getParameter("favcolor"))
                .build();
    }
}
