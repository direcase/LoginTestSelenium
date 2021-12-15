package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest {
    public static ChromeDriver chromeDriver;

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\chromedriver\\chromedriver.exe");
        chromeDriver= new ChromeDriver();

    }

    @Test
    public void loginTest() {
        chromeDriver.get("https://moodle.astanait.edu.kz/login/index.php");
        chromeDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("dbigabulova");
        chromeDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("020905Da!");
        chromeDriver.findElement(By.xpath("//*[@id=\"loginbtn\"]")).click();
        String expected="Astana IT University";
        String actual=chromeDriver.getTitle();
        Assert.assertEquals(expected,actual);
    }
    @AfterClass
    public static void tearDown() {
        chromeDriver.quit();
    }
}
