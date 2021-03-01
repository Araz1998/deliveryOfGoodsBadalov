package com.araz.controller;

import com.araz.dao.OrderDAO;
import com.araz.entity.Order;
import com.araz.entity.User;
import com.araz.service.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserOrderController extends HttpServlet {

    private OrderDAO orderDAO;
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderDAO = new OrderDAO();
        orderService = new OrderService(orderDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if(user == null){
            req.setAttribute("errMessage", "You haven't logined in your profile");
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
        }
        List<Order> orderList = orderService.getUserOrders(user.getId());
        req.setAttribute("orderList", orderList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/user.jsp");

        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("user") == null){
            req.setAttribute("errMessage", "You haven't logged in your profile");
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
        }
        User user = (User) req.getSession().getAttribute("user");
        Order order = (Order) req.getSession().getAttribute("order");
        order.setUserId(String.valueOf(user.getId()));
        orderService.insert(order);

        resp.sendRedirect("/orders");
    }


}
