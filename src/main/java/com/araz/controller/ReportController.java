package com.araz.controller;

import com.araz.dao.OrderDAO;
import com.araz.entity.User;
import com.araz.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Integer> list = orderService.getOrdersStatusByDay(date);
        double avg = orderService.getAvgRoadByDay(date);
        String avgRoad = String.format("%.2f", avg);
        req.setAttribute("list", list);
        req.setAttribute("date", date);
        req.setAttribute("avg", avgRoad);
        HttpSession session = req.getSession();
        session.setAttribute("date", date);
        req.getRequestDispatcher("/view/report-page.jsp").forward(req, resp);
    }
}
