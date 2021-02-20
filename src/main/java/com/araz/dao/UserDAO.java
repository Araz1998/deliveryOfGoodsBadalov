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
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO, IResourcesCloseable{
    Logger logger = Logger.getLogger(UserDAO.class);

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
            logger.info("insert done!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't to insert new User");
        } finally {
            close(statement);
        }
        return result;
    }

    @Override
    public List<User> getAllUsers(Connection connection) throws ApplicationExeption {
        List<User> userList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.GET_ALL_USERS);
            rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String login = rs.getString(2);
                String password = rs.getString(3);
                Role role = (Role) rs.getObject(4);
                String email = rs.getString(5);
                User user = new User(id, login, password, role, email);
                userList.add(user);
                logger.info("Getted list of user");
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get all users");
        } finally {
            close(rs, statement);
        }
        return userList;
    }

    @Override
    public boolean deleteUser(Connection connection, User user) throws ApplicationExeption {
        boolean result = false;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(Constant.DELETE_USER);
            statement.setInt(1, user.getId());
            statement.executeUpdate();
            result = true;
            logger.info("User deleted!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't delete user");
        } finally {
            close(statement);
        }
        return result;
    }

    @Override
    public boolean updateUser(Connection connection, User user) {
        return false;
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
            while (rs.next()){
                String login = rs.getString("login");
                String password = rs.getString("password");
                String email = rs.getString("email");
                user = new User(id, login, password, Role.USER, email);
            }
            logger.info("Get user!");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            throw new ApplicationExeption("Can't get user");
        } finally {
            close(rs, statement);
        }
        return user;
    }

    public int checkUserIsExist(Connection connection, String login){
        int id = 0;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.GET_USER_BY_LOGIN);
            statement.setString(1, login);
            rs = statement.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
                logger.info("User is exist");
            } else {
                logger.info("User is not exist!");
            }
            System.out.println("user id is - " + id);
        } catch (SQLException e) {
            logger.error(e.getMessage());
            try {
                throw new ApplicationExeption("Can not get user");
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
        } finally {
            close(statement);
        }
        return id;
    }

    public Role getUserRole(Connection connection, String login, String password){
        Role role = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.GET_USER_ROLE);
            statement.setString(1, login);
            statement.setString(2, password);
            rs = statement.executeQuery();
            while (rs.next()){
                role = Role.valueOf(rs.getString("role"));
            }
            logger.info("User role got");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            try {
                throw new ApplicationExeption("Can not get user role");
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
        } finally {
            close(rs, statement);
        }
        return role;
    }

    public String getUserEmail(Connection connection, int id){
        PreparedStatement statement = null;
        String email = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(Constant.GET_USER_EMAIL);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()){
                email = rs.getString("email");
            }
            logger.info("User email got");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            try {
                throw new ApplicationExeption("Can not get user email");
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
        } finally {
            close(rs, statement);
        }
        return email;
    }

    public User getUser(Connection connection, String login, String password){
        PreparedStatement statement = null;
        String GET_USER = "SELECT * from user where login = ? AND  password = ?";
        String email = null;
        ResultSet rs = null;
        User user = new User();
        try {
            statement = connection.prepareStatement(GET_USER);
            statement.setString(1, login);
            statement.setString(2, password);
            rs = statement.executeQuery();
            while (rs.next()){
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRole(Role.valueOf(rs.getString("role")));            }
            System.out.println(user);
            logger.info("User was get");
        } catch (SQLException e) {
            logger.error(e.getMessage());
            try {
                throw new ApplicationExeption("Can not get user");
            } catch (ApplicationExeption applicationExeption) {
                applicationExeption.printStackTrace();
            }
        } finally {
            close(rs, statement);
        }
        return user;
    }
}
