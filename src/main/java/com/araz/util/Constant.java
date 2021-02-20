package com.araz.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.security.NoSuchAlgorithmException;

public class Constant {
    //User queries
    public static final String INSERT_USER = "INSERT INTO user (login, password, role, email) VALUES (?, ?, ?, ?)";
    public static final String GET_ALL_USERS = "SELECT * FROM user";
    public static final String DELETE_USER = "DELETE FROM user WHERE id = ?";
    public static final String GET_USER = "SELECT * FROM user WHERE id = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM user WHERE login = ?";
    public static final String GET_USER_ROLE = "SELECT role FROM user WHERE login = ? AND password = ?";
    public static final String GET_USER_EMAIL = "SELECT email from user inner join user_order uo on user.id = uo.user_id where uo.id = ? limit 1";

    //Order's queries
    public static final String INSERT_ORDER = "INSERT INTO user_order ( from_city, to_city, time_way, road, baggage_weight, price, user_id, date, status ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 1 )";

    //new query
    public static final String SELECT_ALL_ORDERS_WITH_NAME = "SELECT user_order.id, user_order.from_city, user_order.to_city, user_order.time_way, user_order.road, bw.weight as baggage_weight, user_order.price, user.login as user_id, status.status_order as status, date\n" +
            "FROM user_order join baggage_weight bw on user_order.baggage_weight = bw.id\n" +
            "                join user on user_order.user_id = user.id\n" +
            "                join status  on user_order.status = status.id";
    public static final String SELECT_USER_ORDERS = "SELECT user_order.id, user_order.from_city, user_order.to_city, user_order.time_way, user_order.road, bw.weight as baggage_weight, user_order.price, user.login as user_id, status.status_order as status, date\n" +
            "FROM user_order join baggage_weight bw on user_order.baggage_weight = bw.id\n" +
            "                join user on user_order.user_id = user.id\n" +
            "                join status  on user_order.status = status.id where user_id = ?";
    public static final String ADMIT_ORDER = "UPDATE user_order SET status = 2 where id = ?";
    public static final String DELETE_ORDER = "DELETE FROM user_order where id = ?";
    public static final String SELECT_ORDER_BY_PRICE = "SELECT * FROM user_order order by price DESC";
    public static final String SELECT_ORDER_BY_ROAD = "SELECT * FROM user_order order by road DESC";
    public static final String SELECT_ORDER_BY_TIME= "SELECT * FROM user_order order by date DESC";
    public static final String SELECT_ORDER_BY_ID = "SELECT user_order.id, user_order.from_city, user_order.to_city, user_order.time_way, user_order.road, bw.weight as baggage_weight, user_order.price, user.login as user_id, status.status_order as status, date\n" +
            "            FROM user_order join baggage_weight bw on user_order.baggage_weight = bw.id\n" +
            "                            join user on user_order.user_id = user.id\n" +
            "                            join status  on user_order.status = status.id WHERE user_order.id = ?";

    public static final String SELECT_ORDERS_BY_STATTUS_2 = "SELECT user_order.id, user_order.from_city, user_order.to_city, user_order.time_way, user_order.road, bw.weight as baggage_weight, user_order.price, user.login as user_id, status.status_order as status, date\n" +
            "            FROM user_order join baggage_weight bw on user_order.baggage_weight = bw.id\n" +
            "                            join user on user_order.user_id = user.id\n" +
            "                            join status  on user_order.status = status.id where status = 2";

    public static final String UPDATE_ORDER_TO_PAYED = "UPDATE user_order SET status = 3 where id = ?";
    public static final String INSERT_CODE_TO_ORDER = "UPDATE user_order SET code = ? where id = ?";
    public static final String SELECT_CODE_FROM_ORDER = "SELECT code FROM user_order where id = ?";
    public static final String SELECT_ALL_ORDERS_ = "SELECT * FROM user_order order by road DESC";
    public static final String GET_ORDERS_COUNT = "SELECT count(*) from user_order";
    public static final String GET_ORDERS_BY_LIMIT = "SELECT user_order.id, user_order.from_city, user_order.to_city, user_order.time_way, user_order.road, bw.weight as baggage_weight, user_order.price, user.login as user_id, status.status_order as status, date\n" +
            "FROM user_order join baggage_weight bw on user_order.baggage_weight = bw.id\n" +
            "                join user on user_order.user_id = user.id\n" +
            "                join status  on user_order.status = status.id order by user_order.id limit ? offset ?";
    public static final String GET_ORDERS_STATUS_BY_DAY = "SELECT (SELECT COUNT(date) FROM user_order\n" +
            "                                    join status on user_order.status = status.id\n" +
            "        where status = 1 AND date = ?),\n" +
            "       (SELECT COUNT(date) FROM user_order\n" +
            "                                    join status on user_order.status = status.id\n" +
            "        where status = 2 AND date = ?),\n" +
            "       (SELECT COUNT(date) FROM user_order\n" +
            "                                    join status on user_order.status = status.id\n" +
            "        where status = 3 AND date = ?)";
    public static final String GET_AVG_ROAD_BY_DAT = "SELECT AVG(road) FROM user_order where date = ?";


    public static void main(String[] args) {
        System.out.println(PasswordHash.getInstance().hash("admin"));
    }
}