package com.araz.dao;

import com.araz.ConnectionFactory;
import com.araz.entity.Role;
import com.araz.entity.User;
import com.araz.util.ApplicationExeption;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.sql.Connection;

import static org.junit.Assert.*;

public class UserDAOTest {

    public Connection connection = ConnectionFactory.getConnection();
    public IUserDAO userDAO = new UserDAO();

    @BeforeClass
    public static void beforeTest(){
        try {
            Connection connection = ConnectionFactory.getConnection();
            ScriptRunner sc = new ScriptRunner(connection);
            Reader reader = new BufferedReader(new FileReader("src/sqlTestDb.sql"));
            sc.runScript(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertUser() throws ApplicationExeption {
        User user = new User("Araz", "1234", Role.USER, "test@test");
        assertTrue(userDAO.insertUser(connection, user));
    }

    @Test
    public void getUser() throws ApplicationExeption {
        User user = userDAO.getUser(connection, 1);
        assertEquals(1, user.getId());
    }

    @Test
    public void getUserEmail() throws ApplicationExeption {
        String email = userDAO.getUserEmail(connection, 1);
        assertNotNull(email);
        assertEquals("badalov.araz@gmail.com", email);
    }

    @Test
    public void getUser1() throws ApplicationExeption {
        User user = userDAO.getUser(connection,"Test","098F6BCD4621D373CADE4E832627B4F6");
        assertNotNull(user);
    }
}