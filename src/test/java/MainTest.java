import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    List<String> list = new ArrayList<>();


    public List<String> calculateDistance(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver","D:/Downloads from google/chromedriver.exe");
        String url = "https://flagma.ua/raschet-rasstoyaniy.html";
        WebDriver driver = new ChromeDriver(options);

        driver.get(url);
        driver.findElement(By.id("ct-search-input-from-terr"))
                .sendKeys("Харьков");
        driver.findElement(By.id("ct-search-input-to-terr"))
                .sendKeys("Днепр");
//        WebElement element = driver.findElement(By.id("ct-search-input-submit"));

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

        list.add(value_time.getText());
        list.add(value_km.getText());

        return list;
    }

    @Test
    public void get(){
        list = calculateDistance();
        for(String s : list){
            System.out.println(s);
        }
    }
}
