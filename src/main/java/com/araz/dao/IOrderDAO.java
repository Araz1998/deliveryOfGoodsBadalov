package com.araz.dao;

import com.araz.entity.Order;
import com.araz.util.ApplicationExeption;

import java.sql.Connection;
import java.util.List;

public interface IOrderDAO {
    boolean insertOrder(Connection connection, Order order) throws ApplicationExeption;
    List<Order> getUserOrder(Connection connection, int id) throws ApplicationExeption;
    List<Order> getAllOrders(Connection connection) throws ApplicationExeption;
    boolean admitUserOrder(Connection connection, int id) throws ApplicationExeption;
    boolean deleteOrder(Connection connection, int id) throws ApplicationExeption;
    List<Order> getOrderByPrice(Connection connection) throws ApplicationExeption;
    List<Order> getOrderByRoad(Connection connection) throws ApplicationExeption;
    List<Order> getOrderByDate(Connection connection) throws ApplicationExeption;
    Order getOrderById (Connection connection, int id) throws ApplicationExeption;
    List<Order> getOrdersByStatusConfirmed(Connection connection) throws ApplicationExeption;
    boolean updateOrderToStatusPayed(Connection connection, int id) throws ApplicationExeption;
    boolean insertCodeToOrder(Connection connection, int code, int id) throws ApplicationExeption;
    int getOrderCode (Connection connection, int id) throws ApplicationExeption;
    int getOrdersNumber(Connection connection) throws ApplicationExeption;
    List<Order> getAllOrdersByLimit(Connection connection, int page, int pageSize) throws ApplicationExeption;
    List<Integer> getOrdersStatusByDay(Connection connection, String date) throws ApplicationExeption;
    double getAvgRoadByDat(Connection connection, String date) throws ApplicationExeption;
    List<String> getInfoForDay(Connection connection, String date) throws ApplicationExeption;




}
