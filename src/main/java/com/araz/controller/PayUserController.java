package com.araz.controller;

import com.araz.dao.OrderDAO;
import com.araz.entity.Order;
import com.araz.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PayUserController extends HttpServlet {

    private OrderDAO orderDAO;
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderDAO = new OrderDAO();
        orderService = new OrderService(orderDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String successful = (String) req.getAttribute("successful");
        if(successful != null){
//            req.setAttribute("successful", "Your order was successfully payed!");
            req.getRequestDispatcher("view/payCab.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ( req.getParameter("code").isEmpty() || req.getParameter("orderId").isEmpty() ){
            req.setAttribute("errorMessage", "Please, enter your code and order's number");
            System.out.println("here bad");
            req.getRequestDispatcher("view/payCab.jsp").forward(req, resp);
        }
        int code = Integer.parseInt(req.getParameter("code"));
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        int codeFromDb = orderService.getCodeFromOrder(orderId);
        System.out.println(codeFromDb + "FROM doPost");
        System.out.println(code + " FROM FORM");
        if (code == codeFromDb){
            orderService.updateOrderToStatusPayed(orderId);
            req.setAttribute("successful", "Your order was successfully payed!");
            System.out.println("HERE good");
//            resp.sendRedirect("view/payCab.jsp?successful=" + req.getAttribute("successful"));
            doGet(req, resp);
        } else {
            req.setAttribute("errorMessage", "Please, check your code and order's number");
            System.out.println("here bad");
            req.getRequestDispatcher("view/payCab.jsp").forward(req, resp);
        }
    }
}
