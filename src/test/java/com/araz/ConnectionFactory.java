package com.araz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory instance;

    private ConnectionFactory(){}

    public static synchronized ConnectionFactory getInstance(){
        if(instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver").newInstance();
            connection =  DriverManager.getConnection("jdbc:h2:~/test", "root", "");
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
