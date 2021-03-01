package com.araz.service;

import com.araz.dao.UserDAO;
import com.araz.dbUtil.ConnectionPool;
import com.araz.entity.Role;
import com.araz.entity.User;
import com.araz.util.ApplicationExeption;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    final static Logger log = Logger.getLogger(UserService.class);

    private UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public boolean insert(User user) {
        boolean result = false;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            userDAO.insertUser(connection, user);
            result = true;
            connection.commit();
            log.info("New user insert");
        } catch (SQLException | ApplicationExeption e) {
            log.error("cannot add new user");
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

    public String getUserEmail(int id){
        Connection connection = null;
        String email = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            email = userDAO.getUserEmail(connection, id);
            connection.commit();
            log.info("User email was get");
        } catch (SQLException | ApplicationExeption e) {
            log.error("Can not get user email");
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return email;
    }

    public User getUser (String login, String password){
        Connection connection = null;
        User user = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            user = userDAO.getUser(connection, login, password);
            System.out.println(user.toString());
            connection.commit();
            log.info("User was get");
        } catch (SQLException | ApplicationExeption e) {
            log.error("Can not get user");
            rollbackConnection(connection);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
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
