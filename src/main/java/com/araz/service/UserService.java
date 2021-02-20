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
            try {
                userDAO.insertUser(connection, user);
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

    public List<User> userList() throws ApplicationExeption, SQLException {
        List<User> users = null;
        Connection connection = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            userDAO.getAllUsers(connection);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackConnection(connection);
        } finally {
            connection.close();
        }
        return users;
    }

    public int checkUserIsExist(String login){
        Connection connection = null;
        int id = 0;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            id = userDAO.checkUserIsExist(connection, login);
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
        return id;
    }

    public Role getUserRole(String login, String password){
        Connection connection = null;
        Role role = null;
        try {
            if(connection == null || connection.isClosed()){
                connection = ConnectionPool.getConnection();
            }
            role = userDAO.getUserRole(connection, login, password);
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
        return role;
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
