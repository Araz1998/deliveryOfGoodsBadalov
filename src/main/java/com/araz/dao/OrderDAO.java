package com.araz.dao;

import com.araz.entity.Order;
import com.araz.util.ApplicationExeption;
import com.araz.util.Constant;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO, IResourcesCloseable {
    Logger logger = Logger.getLogger(OrderDAO.class);

    @Override
    public boolean insertOrder(Connection connection, Order order) throws ApplicationExeption {
        boolean result = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Constant.INSERT_ORDER);
            statement.setString(1, order.getFromCity());
            statement.setString(2, order.getToCity());
            statement.setString(3, String.valueOf(order.getTime()));
            statement.setInt(4, order.getDistance());
            statement.setInt(5, Integer.parseInt(order.getBaggageWeight()));
            statement.setFloat(6, order.getCost());
            statement.setInt(7, Integer.parseInt(order.getUserId()));
            statement.setString(8, order.getDate());
            statement.executeUpdate();
            result = true;
            logger.info("insert done!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't to insert new Order");
        } finally {
            close(statement);
        }
        return result;
    }

    @Override
    public List<Order> getUserOrder(Connection connection, int id) throws ApplicationExeption {
        List<Order> orders = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.SELECT_USER_ORDERS);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                Order order = constructOrder(rs);
                order.setDate(rs.getString("date"));
                orders.add(order);
            }
            logger.info("Orders for user with id " + id + " is selected!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get user's orders");
        } finally {
            close(rs, statement);
        }
        return orders;
    }

    @Override
    public List<Order> getAllOrders(Connection connection) throws ApplicationExeption {
        List<Order> orderList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.SELECT_ALL_ORDERS_WITH_NAME);
            rs = statement.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt(1);
                String fromCity = rs.getString(2);
                String toCity = rs.getString(3);
                String tempTime = rs.getString(4);
                String[] temp = tempTime.split("\\D+");
                Order.Time time = new Order.Time(temp[0], temp[1]);

                int road = rs.getInt(5);
                String baggage = rs.getString(6);
                float price = rs.getFloat(7);
                String userId = rs.getString(8);
                String status = rs.getString(9);
                Order order = new Order(orderId, fromCity, toCity, road, time, baggage, price, userId, status);
                orderList.add(order);
            }
            logger.info("All orders is got!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get user's orders");
        } finally {
            close(rs, statement);
        }
        return orderList;
    }

    @Override
    public boolean admitUserOrder(Connection connection, int id) throws ApplicationExeption {
        boolean result = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Constant.ADMIT_ORDER);
            statement.setInt(1, id);
            statement.executeUpdate();
            result = true;
            logger.info("Order admited!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't admit order");
        } finally {
            close(statement);
        }
        return result;
    }

    @Override
    public boolean deleteOrder(Connection connection, int id) throws ApplicationExeption {
        boolean result = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Constant.DELETE_ORDER);
            statement.setInt(1, id);
            statement.execute();
            result = true;
            logger.info("Order deleted!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't delete order");
        } finally {
            close(statement);
        }
        return result;
    }

    @Override
    public List<Order> getOrderByPrice(Connection connection) throws ApplicationExeption {
        List<Order> orders = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.SELECT_ORDER_BY_PRICE);
            rs = statement.executeQuery();
            while (rs.next()) {
                Order order = constructOrder(rs);
                orders.add(order);
            }
            logger.info("Top 3 orders by price was selected!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get top orders by price");
        } finally {
            close(rs, statement);
        }
        return orders;
    }

    @Override
    public List<Order> getOrderByRoad(Connection connection) throws ApplicationExeption {
        List<Order> orders = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.SELECT_ORDER_BY_ROAD);
            rs = statement.executeQuery();
            while (rs.next()) {
                Order order = constructOrder(rs);
                orders.add(order);
            }
            logger.info("Top 3 orders by road was selected!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get top orders by price");
        } finally {
            close(rs, statement);
        }
        return orders;
    }

    @Override
    public List<Order> getOrderByDate(Connection connection) throws ApplicationExeption {
        List<Order> orders = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.SELECT_ORDER_BY_TIME);
            rs = statement.executeQuery();
            while (rs.next()) {
                Order order = constructOrder(rs);
                orders.add(order);
            }
            logger.info("Top 3 orders by time was selected!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get top orders by price");
        } finally {
            close(rs, statement);
        }
        return orders;
    }

    @Override
    public Order getOrderById (Connection connection, int id) throws ApplicationExeption {
        Order order = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.SELECT_ORDER_BY_ID);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                order = constructOrder(rs);
                System.out.println("Hash from OrderDAO: "+ order.hashCode());
            }
            logger.info("Order with id: " + id +  " got!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get order with id: " + id);
        } finally {
            close(rs, statement);
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByStatusConfirmed(Connection connection) throws ApplicationExeption {
        List<Order> orderList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.SELECT_ORDERS_BY_STATTUS_2);
            rs = statement.executeQuery();
            while (rs.next()) {
                Order order = constructOrder(rs);
                orderList.add(order);
            }
            logger.info("Confirmed orders was selected!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get orders");
        } finally {
            close(rs, statement);
        }
        return orderList;
    }

    @Override
    public boolean updateOrderToStatusPayed(Connection connection, int id) throws ApplicationExeption {
        boolean result = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Constant.UPDATE_ORDER_TO_PAYED);
            statement.setInt(1, id);
            statement.executeUpdate();
            result = true;
            logger.info("Order payed!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't payed order");
        } finally {
            close(statement);
        }
        return result;
    }

    @Override
    public boolean insertCodeToOrder(Connection connection, int code, int id) throws ApplicationExeption {
        boolean result = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Constant.INSERT_CODE_TO_ORDER);
            statement.setInt(1, code);
            statement.setInt(2, id);
            statement.executeUpdate();
            result = true;
            logger.info("Code insert!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't insert code");
        } finally {
            close(statement);
        }
        return result;
    }

    @Override
    public int getOrderCode (Connection connection, int id) throws ApplicationExeption {
        int code = 0;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.SELECT_CODE_FROM_ORDER);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                code = rs.getInt("code");
            }
            logger.info("Code from order with id: " + id +  " got!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get code from order with id:" + id);
        } finally {
            close(rs, statement);
        }
        return code;
    }

    @Override
    public int getOrdersNumber(Connection connection) throws ApplicationExeption {
        int ordersNumber = 0;
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(Constant.GET_ORDERS_COUNT);
            if (rs.next()) {
                ordersNumber = rs.getInt(1);
            }
            logger.info(ordersNumber + " - count of orders");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Cannot find count of orders", e);
        } finally {
            close(rs, statement);
        }

        return ordersNumber;
    }

    @Override
    public List<Order> getAllOrdersByLimit(Connection connection, int page, int pageSize) throws ApplicationExeption {
        List<Order> orderList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.GET_ORDERS_BY_LIMIT);
            statement.setInt(1, pageSize);
            statement.setInt(2, pageSize * (page - 1));
            rs = statement.executeQuery();
            while (rs.next()) {
                Order order = constructOrder(rs);
                orderList.add(order);
            }
            logger.info("All orders is got!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get user's orders");
        } finally {
            close(rs, statement);
        }
        return orderList;
    }

    @Override
    public List<Integer> getOrdersStatusByDay(Connection connection, String date) throws ApplicationExeption {
        List<Integer> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.GET_ORDERS_STATUS_BY_DAY);
            statement.setString(1, date);
            statement.setString(2, date);
            statement.setString(3, date);
            rs = statement.executeQuery();
            while (rs.next()) {
                int newOrder = rs.getInt(1);
                int confirmedOrder = rs.getInt(2);
                int paidOrder = rs.getInt(3);
                list.add(newOrder);
                list.add(confirmedOrder);
                list.add(paidOrder);
            }
            logger.info("Count of paid orders was get");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get orders count");
        } finally {
            close(rs, statement);
        }
        return list;
    }

    @Override
    public double getAvgRoadByDat(Connection connection, String date) throws ApplicationExeption {
        double avgRoad = 0;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.GET_AVG_ROAD_BY_DAT);
            statement.setString(1, date);
            rs = statement.executeQuery();
            while (rs.next()){
                avgRoad = rs.getDouble(1);
            }
            logger.info("Avg road was get!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get avg road");
        } finally {
            close(rs, statement);
        }
        return avgRoad;
    }

    @Override
    public List<String> getInfoForDay(Connection connection, String date) throws ApplicationExeption {
        ResultSet rs = null;
        PreparedStatement statement = null;
        List<String> info = new ArrayList<>();
        try {
            statement = connection.prepareStatement(Constant.GET_INFO_FOR_DAY);
            statement.setString(1, date);
            statement.setString(2, date);
            statement.setString(3, date);
            statement.setString(4, date);
            statement.setString(5, date);
            rs = statement.executeQuery();
            while (rs.next()){
                info.add(rs.getString(1));
                info.add(rs.getString(2));
                info.add(rs.getString(3));
                info.add(rs.getString(4));
                info.add(String.format("%.2f", rs.getDouble(5)));
            }
            logger.info("Info for date: " + date + " was get");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get info for day: " + date);
        } finally {
            close(rs, statement);
        }
        return info;
    }

    private Order constructOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        order.setId(rs.getInt(1));
        order.setFromCity(rs.getString(2));
        order.setToCity(rs.getString(3));
        String tempTime = rs.getString(4);
        String[] temp = tempTime.split("\\D+");
        order.setTime(new Order.Time(temp[0], temp[1]));
        order.setDistance(rs.getInt(5));
        order.setBaggageWeight(rs.getString(6));
        order.setCost(rs.getFloat(7));
        order.setUserId(rs.getString(8));
        order.setStatus(rs.getString("status"));
        order.setDate(rs.getString(9));
        return order;
    }
}
