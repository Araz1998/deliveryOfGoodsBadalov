package com.araz.controller;

import com.araz.dao.OrderDAO;
import com.araz.dao.UserDAO;
import com.araz.entity.Order;
import com.araz.service.OrderService;
import com.araz.service.UserService;
import com.araz.util.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminConntroller extends HttpServlet {
    private OrderDAO orderDAO;
    private UserDAO userDAO;
    private UserService userService;
    private OrderService orderService;
    private SendEmail sendEmail;

    @Override
    public void init() throws ServletException {
        orderDAO = new OrderDAO();
        orderService = new OrderService(orderDAO);
        sendEmail = new SendEmail("email", "password");
        userDAO = new UserDAO();
        userService = new UserService(userDAO);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/admit":
                    admitOrder(req, resp);
                    break;
                case "/delete":
                    deleteOrder(req, resp);
                    break;
                default:
                    listOrder(req, resp);
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void listOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramPage = req.getParameter("page");
        String paramPageSize = req.getParameter("pageSize");
        int page = Integer.parseInt(paramPage);
        int pageSize = Integer.parseInt(paramPageSize);
        List<Order> orderList = orderService.getAllOrdersByLimit(page, pageSize);
        int usersNumber = orderService.getOrdersNumber();
        int maxPage = (int) Math.ceil((double) usersNumber / pageSize);
        req.setAttribute("orderList", orderList);
        req.setAttribute("page", page);
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("maxPage", maxPage);
        req.getRequestDispatcher("/view/admin.jsp").forward(req, resp);
    }

    private void admitOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        orderService.admitUserOrder(id);
        Order order = orderService.getOrderById(id);
        String email = userService.getUserEmail(id);
        System.out.println("HASF from ADMIN - " + order.hashCode());
        int code = sendEmail.send(order, email);
        orderService.insertCodeToOrder(code, id);
        resp.sendRedirect("/admin");
    }

    private void deleteOrder(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        orderService.deleteOrder(id);
        resp.sendRedirect("/admin");
    }

}
