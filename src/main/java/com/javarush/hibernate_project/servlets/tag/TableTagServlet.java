package com.javarush.hibernate_project.servlets.tag;

import com.javarush.hibernate_project.dto.TagDTO;
import com.javarush.hibernate_project.services.TagService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static com.javarush.hibernate_project.consts.WebConstants.TAG_SERVICE;

@WebServlet(name = "tableTagServlet", value = "/table-tag")
public class TableTagServlet extends HttpServlet {

    private TagService tagService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();
        tagService = (TagService) context.getAttribute(TAG_SERVICE);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TagDTO> tags = tagService.getAll();
        req.setAttribute("tags", tags);
        req.getRequestDispatcher("/tag/table_tag.jsp").forward(req, resp);
    }
}
