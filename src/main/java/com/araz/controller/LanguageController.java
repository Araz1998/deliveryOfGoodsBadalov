package com.araz.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Servlet that check input data, and set attribute for language
 */
public class LanguageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String language = req.getParameter("language");
        if (language.equals("ru") || language.equals("en") || language.isEmpty()) {
            session.setAttribute("lang", language);
        }
        req.getRequestDispatcher( "/").forward(req, resp);
    }
}
