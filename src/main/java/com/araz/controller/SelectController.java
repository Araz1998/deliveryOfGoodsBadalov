package com.araz.controller;

import com.araz.dao.OrderDAO;
import com.araz.entity.Order;
import com.araz.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller for select in main page
 */
public class SelectController extends HttpServlet {

    private OrderDAO orderDAO;
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        orderDAO = new OrderDAO();
        orderService = new OrderService(orderDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String select = req.getParameter("topSelect");
        List<Order> orderList = getSelect(select);
        req.setAttribute("orderList", orderList.stream().limit(4).collect(Collectors.toList()));
        req.getRequestDispatcher("/").forward(req, resp);
    }

    private List<Order> getSelect(String select){
        List<Order> orderList = new ArrayList<>();
        try {
            switch (select){
                case "1":
                    orderList = orderService.getOrdersByRoad();
                    break;
                case "2":
                    orderList = orderService.getOrdersByDate();
                    break;
                case "3":
                    orderList = orderService.getOrdersByPrice();
                    break;
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return orderList;
    }
}
