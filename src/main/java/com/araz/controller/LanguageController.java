package com.araz.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LanguageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LANGUAGE");
        HttpSession session = req.getSession();
        String language = req.getParameter("language");
        System.out.println("language " + language);
        if (language.equals("ru") || language.equals("en") || language.isEmpty()) {
            System.out.println(language);
            session.setAttribute("lang", language);
        }
        req.getRequestDispatcher( "/").forward(req, resp);
    }
}
