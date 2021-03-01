package com.araz.controller;

import com.araz.dao.UserDAO;
import com.araz.entity.Role;
import com.araz.entity.User;
import com.araz.service.UserService;
import com.araz.util.PasswordHash;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
        userService = new UserService(userDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    /**
     * This method, validate some information from input data, for login in site
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String tempPassword = req.getParameter("password");
        String email = req.getParameter("email");
        String password = PasswordHash.getInstance().hash(tempPassword);

        System.out.println("pass - " + password);
        User user = userService.getUser(login, password);
        if (user.getId() != 0) {
            Role role = user.getRole();
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            moveTo(role, req, resp);
        } else {
            req.setAttribute("errMessage", "You haven't registered yet!");
            req.getRequestDispatcher("view/registration.jsp").forward(req, resp);
        }
    }

    private void moveTo(Role role, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        if (role == Role.USER) {
            resp.sendRedirect("/orders");
        } else {
            resp.sendRedirect("/admin?pageSize=2&page=1");
        }
    }
}
