package com.araz.controller;

import com.araz.dao.OrderDAO;
import com.araz.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Controller for day's info
 */
public class ReportController extends HttpServlet {

    private OrderDAO orderDAO;
    private OrderService orderService;


    @Override
    public void init() throws ServletException {
        orderDAO = new OrderDAO();
        orderService = new OrderService(orderDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("calendar");
        List<String> info = orderService.getInfoForDay(date);
        req.setAttribute("list", info);
        HttpSession session = req.getSession();
        session.setAttribute("list", info);
        req.getRequestDispatcher("/view/report-page.jsp").forward(req, resp);
    }
}
