package com.araz.controller;

import com.araz.entity.Order;
import com.araz.entity.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class CalculateOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
        Order order;
        req.setCharacterEncoding("UTF-8");

        String fromCity = req.getParameter("fromCity");
        String toCity = req.getParameter("toCity");
        String weight = req.getParameter("weight");
        order = calculateDistance(fromCity, toCity);
        //calculate distance and time way
//        order = testMet(fromCity, toCity);
        order.setDate(req.getParameter("calendar"));
        order.setBaggageWeight(weight);

        //calculate price
        order.setCost(calculatePrice(order.getBaggageWeight(), order.getDistance()));
        Order.Time time = order.getTime();
        HttpSession session = req.getSession();
        if(null == session.getAttribute("user")){
            req.setAttribute("order", order);
            req.getRequestDispatcher("view/calculate.jsp").forward(req, resp);
        }
        User user = (User) session.getAttribute("user");
        order.setUserId(String.valueOf(user.getId()));
        req.setAttribute("user", user);
        req.setAttribute("time", time);
        session.setAttribute("order", order);
        req.setAttribute("order", order);

        req.getRequestDispatcher("view/calculate.jsp").forward(req, resp);

    }

    public Order testMet(String fromCity, String toCity){
        Order order = new Order();
        String s = "217 km";
        String s2 = "2 h 12 m";
//        List<Integer> num = new ArrayList<>();
//        for(String part : s2.split("\\D+"))
//            num.add(Integer.valueOf(part));
//        for(Integer i : num){
//            System.out.println(i);
//        }
        String[] temp = s2.split("\\D+");
        order.setFromCity(fromCity);
        order.setToCity(toCity);
        order.setDistance(Integer.parseInt(s.substring(0, s.length()-3)));
        order.setTime(new Order.Time(temp[0], temp[1]));
        return order;
    }

    private Order calculateDistance(String fromCity, String toCity){
        Order order = new Order();
        //dont show a chrom window
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver","D:/Downloads from google/chromedriver.exe");
        String url = "https://flagma.ua/raschet-rasstoyaniy.html";
        WebDriver driver = new ChromeDriver(options);

        driver.get(url);
        driver.findElement(By.id("ct-search-input-from-terr"))
                .sendKeys(fromCity);
        driver.findElement(By.id("ct-search-input-to-terr"))
                .sendKeys(toCity);
        WebElement button = driver.findElement(By.id("ct-search-input-submit"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", button);

        String curentURL = driver.getCurrentUrl();
        driver.get(curentURL);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement value_km = driver.findElement(By.xpath("//span[@class='km']"));
        WebElement value_time = driver.findElement(By.xpath("//span[@class='time']"));
        System.out.println(value_km.getText());
        System.out.println(value_time.getText());
        String[] temp = value_time.getText().split("\\D+");
        order.setFromCity(fromCity);
        order.setToCity(toCity);
        order.setDistance(Integer.parseInt(value_km.getText().substring(0, value_km.getText().length()-3)));
        order.setTime(new Order.Time(temp[0], temp[1]));
        return order;
    }


    private float calculatePrice(String baggageWeight, int way){
        float coast = 0;
        switch (baggageWeight){
            case "1":
                coast = (float) ((10 * way / 100.0) * 28 *2);
                break;
            case "2":
                coast = (float) ((30* way / 100.0) * 28 * 2.5);
                break;
            case "3":
                coast = (float) ((40 * way / 100.0) * 28 *3);
                break;
        }
        return coast;
    }
}
