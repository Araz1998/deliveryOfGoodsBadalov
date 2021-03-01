package com.araz.controller;

import com.araz.dao.OrderDAO;
import com.araz.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet, for user's pay
 */
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
            req.getRequestDispatcher("view/payCab.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (req.getParameter("code").isEmpty() || req.getParameter("orderId").isEmpty()){
//            req.setAttribute("errorMessage", "Please, enter your code and order's number");
//            req.getRequestDispatcher("view/payCab.jsp").forward(req, resp);
//        }
        if (validatorCodeAndOrderId(req) == false){
            req.setAttribute("errorMessage", "Please, enter your code and order's number");
            req.getRequestDispatcher("view/payCab.jsp").forward(req, resp);
        }
        int code = Integer.parseInt(req.getParameter("code"));
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        int codeFromDb = orderService.getCodeFromOrder(orderId);
        if (code == codeFromDb){
            orderService.updateOrderToStatusPayed(orderId);
            req.setAttribute("successful", "Your order was successfully payed!");
            doGet(req, resp);
        } else {
            req.setAttribute("errorMessage", "Please, check your code and order's number");
            req.getRequestDispatcher("view/payCab.jsp").forward(req, resp);
        }
    }


    /**
     * Validate inpute data
     * @param request
     * @return
     */
    private boolean validatorCodeAndOrderId(HttpServletRequest request){
        boolean result = true;
        String codeReq = request.getParameter("code");
        String orderIdReq = request.getParameter("orderId");
        if(codeReq.isEmpty() || (codeReq.matches("[-+]?\\d+") == false) || orderIdReq.isEmpty())
        result = false;
        return result;
    }
}
