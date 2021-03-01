package com.araz.dao;

import com.araz.ConnectionFactory;
import com.araz.entity.Order;
import com.araz.util.ApplicationExeption;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.io.*;
import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;


public class OrderDAOTest {

    public ByteArrayOutputStream output = new ByteArrayOutputStream();
    public IOrderDAO orderDAO = new OrderDAO();
    public Connection connection = ConnectionFactory.getConnection();

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
    public void insertOrder() throws ApplicationExeption {
        Order order = new Order(2, "Kh", "Lv", 1223, new Order.Time("12", "23"), "1", 233.3f, "1" , "1");
        Assert.assertTrue( orderDAO.insertOrder(connection, order));
    }

    @Test
    public void getUserOrder() throws ApplicationExeption {
        Assert.assertNotNull(orderDAO.getUserOrder(connection, 1));
    }

    @Test
    public void getAllOrders() throws ApplicationExeption {
        Assert.assertNotNull(orderDAO.getAllOrders(connection));
    }

    @Test
    public void admitUserOrder() throws ApplicationExeption {
        Assert.assertTrue(orderDAO.admitUserOrder(connection, 2));
    }

    @Test
    public void deleteOrder() throws ApplicationExeption {
        assertTrue(orderDAO.deleteOrder(connection, 2));
    }

    @Test
    public void getOrderByPrice() throws ApplicationExeption {
        Order order = new Order("Kia", "Tu", 432, new Order.Time("3", "43"), "1", 233f, "1", "1", "2012-12-1" );
        Assert.assertTrue( orderDAO.insertOrder(connection, order));
        assertNotNull(orderDAO.getOrderByPrice(connection));
    }

    @Test
    public void getOrderById() throws ApplicationExeption {
        Order order = orderDAO.getOrderById(connection, 1);
        assertEquals(1, order.getId());
    }

    @Test
    public void getOrderByStatusConfirmed() throws ApplicationExeption {
        List<Order> orderList = orderDAO.getOrdersByStatusConfirmed(connection);
        for (Order p : orderList){
            System.out.println(p);
        }
        assertNotNull("tru" ,output.toString() );
        assertNotNull(orderList);
    }

    @Test
    public void updateOrderToStatusPayed() throws ApplicationExeption {
        assertTrue(orderDAO.updateOrderToStatusPayed(connection, 1));
        Order order = orderDAO.getOrderById(connection,1);
        assertEquals("paid", order.getStatus()  );
    }

    @Test
    public void insertCodeToOrder() throws ApplicationExeption {
        assertTrue(orderDAO.insertCodeToOrder(connection, 123, 1));
    }

    @Test
    public void getOrderCode() throws ApplicationExeption {
        assertTrue(orderDAO.insertCodeToOrder(connection, 123, 1));
        int code = orderDAO.getOrderCode(connection, 1);
        assertEquals(123, code);
    }

    @Test
    public void getOrdersNumber() throws ApplicationExeption {
        int count = orderDAO.getOrdersNumber(connection);
        assertEquals(1, count);
    }
}