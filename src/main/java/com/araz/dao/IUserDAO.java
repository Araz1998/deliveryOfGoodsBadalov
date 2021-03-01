package com.araz.dao;

import com.araz.entity.User;
import com.araz.util.ApplicationExeption;

import java.sql.Connection;
import java.util.List;

public interface IUserDAO {
     boolean insertUser(Connection connection, User user) throws ApplicationExeption;
     User getUser(Connection connection, int id) throws ApplicationExeption;
     String getUserEmail(Connection connection, int id) throws ApplicationExeption;
     User getUser(Connection connection, String login, String password) throws ApplicationExeption;

}
