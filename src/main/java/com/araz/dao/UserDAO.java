package com.araz.dao;

import com.araz.entity.Role;
import com.araz.entity.User;
import com.araz.util.ApplicationExeption;
import com.araz.util.Constant;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO, IResourcesCloseable {
    public static final Logger log = Logger.getLogger(UserDAO.class);

    @Override
    public boolean insertUser(Connection connection, User user) throws ApplicationExeption {
        boolean result = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Constant.INSERT_USER);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, String.valueOf(user.getRole()));
            statement.setString(4, user.getEmail());
            statement.executeUpdate();
            result = true;
            log.info("insert done!");
        } catch (SQLException e) {
            log.error("Can not inset user, dublicate ");
            throw new ApplicationExeption("Can't to insert new User");
        } finally {
            close(statement);
        }
        return result;
    }

    @Override
    public User getUser(Connection connection, int id) throws ApplicationExeption {
        PreparedStatement statement = null;
        ResultSet rs = null;
        User user = null;
        try {
            statement = connection.prepareStatement(Constant.GET_USER);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                String login = rs.getString("login");
                String password = rs.getString("password");
                String email = rs.getString("email");
                user = new User(id, login, password, Role.USER, email);
            }
            log.info("Get user!");
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ApplicationExeption("Can't get user");
        } finally {
            close(rs, statement);
        }
        return user;
    }

    @Override
    public String getUserEmail(Connection connection, int id) throws ApplicationExeption {
        PreparedStatement statement = null;
        String email = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.GET_USER_EMAIL);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                email = rs.getString("email");
            }
            log.info("User email got");
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ApplicationExeption("Can not get user email");
        } finally {
            close(rs, statement);
        }
        return email;
    }

    @Override
    public User getUser(Connection connection, String login, String password) throws ApplicationExeption {
        PreparedStatement statement = null;
        final String GET_USER = "SELECT * from user where login = ? AND  password = ?";
        String email = null;
        ResultSet rs = null;
        User user = new User();
        try {
            statement = connection.prepareStatement(GET_USER);
            statement.setString(1, login);
            statement.setString(2, password);
            rs = statement.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRole(Role.valueOf(rs.getString("role")));
            }
            log.info("User was get");
        } catch (SQLException e) {
            log.error(e.getMessage());
            throw new ApplicationExeption("Can not get user");
        } finally {
            close(rs, statement);
        }
        return user;
    }
}
