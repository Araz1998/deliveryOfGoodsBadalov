package com.araz.dao;

import com.araz.entity.User;
import com.araz.util.ApplicationExeption;

import java.sql.Connection;
import java.util.List;

public interface IUserDAO {
     boolean insertUser(Connection connection, User user) throws ApplicationExeption;
     List<User> getAllUsers(Connection connection) throws ApplicationExeption;
     boolean deleteUser(Connection connection, User user) throws ApplicationExeption;
     boolean updateUser(Connection connection, User user);
     User getUser(Connection connection, int id) throws ApplicationExeption;

}
