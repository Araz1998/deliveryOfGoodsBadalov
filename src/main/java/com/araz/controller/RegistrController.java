package com.araz.controller;

import com.araz.dao.UserDAO;
import com.araz.entity.Role;
import com.araz.entity.User;
import com.araz.service.UserService;
import com.araz.util.PasswordHash;
import org.apache.commons.validator.routines.EmailValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class RegistrController extends HttpServlet {

    private UserDAO userDAO;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        userService = new UserService(userDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/registration.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String tempPassword = req.getParameter("password");
        String email = req.getParameter("email");
        String password = null;
        password = PasswordHash.getInstance().hash(tempPassword);

        User user = null;
        if (emailValid(email) == true) {
            user = new User(login, password, Role.USER, email);
        } else {
            req.setAttribute("errMessage", "Your email is not correct");
            req.getRequestDispatcher("view/registration.jsp").
                    forward(req, resp);
        }

        boolean result = userService.insert(user);

        if(result == true) {
            resp.sendRedirect("/index.jsp");
        } else {
            req.setAttribute("errMessage", "This email or login has been existed");
            req.getRequestDispatcher("view/registration.jsp").
                                        forward(req, resp);
        }
    }

    private boolean emailValid(String email) {
        return EmailValidator.getInstance().isValid(email);
    }
}
