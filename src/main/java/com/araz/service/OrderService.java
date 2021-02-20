package com.araz.service;

import com.araz.dao.OrderDAO;
import com.araz.dbUtil.ConnectionPool;
import com.araz.entity.Order;
import com.araz.util.ApplicationExeption;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    final static Logger log = Logger.getLogger(OrderService.class);

    private OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    public boolean insert(Order order) {
        boolean result = false;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orderDAO.insertOrder(connection, order );
                result = true;
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<Order> userOrders(int id){
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orders = orderDAO.getUserOrder(connection, id);
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("orders selected");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    public List<Order> getAllOrders(){
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orderList = orderDAO.getAllOrders(connection);
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("All orders'e got!");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderList;
    }


    public boolean admitUserOrder(int id) {
        boolean result = false;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orderDAO.admitUserOrder(connection, id );
                result = true;
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("Order was admited");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public boolean deleteOrder(int id) {
        boolean result = false;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orderDAO.deleteOrder(connection, id );
                result = true;
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("Order was deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public List<Order> getOrdersByPrice(){
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orders = orderDAO.getOrderByPrice(connection);
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("orders selected");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    public List<Order> getOrdersByRoad(){
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orders = orderDAO.getOrderByRoad(connection);
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("orders selected");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }


    public List<Order> getOrdersByTime(){
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orders = orderDAO.getOrderByTime(connection);
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("orders by time selected");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    public Order getOrderById(int id){
        Order order = null;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                order = orderDAO.getOrderById(connection, id);
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("order got");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return order;
    }

    public List<Order> getOrdersByStatusConfirmed(){
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orders = orderDAO.getOrderByStatusConfirmed(connection);
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("orders selected");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    public boolean updateOrderToStatusPayed(int id) {
        boolean result = false;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orderDAO.updateOrderToStatusPayed(connection, id );
                result = true;
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("Order was payed");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean insertCodeToOrder(int code, int id) {
        boolean result = false;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orderDAO.insertCodeToOrder(connection,code ,id);
                result = true;
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("Code was insert");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int getCodeFromOrder(int id){
        int code = 0;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                code = orderDAO.getOrderCode(connection, id);
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("Code from order got");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return code;
    }

    public int getOrdersNumber(){
        int ordersNumber = 0;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                ordersNumber = orderDAO.getOrdersNumber(connection);
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("Orders count -" + ordersNumber);
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ordersNumber;
    }


    public List<Order> getAllOrdersByLimit(int page, int pageSize){
        List<Order> orderList = new ArrayList<>();
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            try {
                orderList = orderDAO.getAllOrdersByLimit(connection, page, pageSize);
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
            connection.commit();
            log.info("All orders by limit got!");
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return orderList;
    }

    public List<Integer> getOrdersStatusByDay(String date)  {
        List<Integer> list = new ArrayList<>();
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            list = orderDAO.getOrdersStatusByDay(connection, date);
            connection.commit();
            log.info("All orders by day were get!");
        } catch (SQLException | ApplicationExeption e) {
            rollbackConnection(connection);
            try {
                throw new ApplicationExeption(e.getMessage());
            } catch (ApplicationExeption applicationExeption) {

            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public double getAvgRoadByDay(String date){
        double avg = 0;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            avg = orderDAO.getAvgRoadByDat(connection, date);
        }catch (SQLException | ApplicationExeption e) {
            rollbackConnection(connection);
            log.error(e.getMessage(), e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return avg;
    }

    private void rollbackConnection(Connection connection){
        try {
            if(connection != null) {
                connection.rollback();
            }
        } catch (SQLException e) {
            try {
                throw new ApplicationExeption(e.getMessage());
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
        }
    }
}
