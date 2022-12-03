package com.javarush.hibernate_project.servlets;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "IndexSerlver", value = "/")
public class IndexServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}