/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import java.io.*;
import model.AccountModel;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;
import org.testng.annotations.*;

/**
 *
 * @author Minh Hao
 */
public class LoginNGTest {

    private static WebDriver driver;
    AccountModel model = new AccountModel();

    @BeforeClass
    public static void createAndStartService() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                "D:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public static void stopService() {
        driver.quit();
    }

    //TEST INCORRECT PASSWORD LOGIN
    @Test(priority = 1)
    public void TestcheckIncorrectPassword() throws InterruptedException {
        driver.get("http://localhost:8084/ASM/loginql.jsp");
        driver.findElement(By.name("txtusername")).sendKeys("minhhao");
        WebElement txtpassword = driver.findElement(By.name("txtpassword"));
        txtpassword.sendKeys("12zxczxc3");
        Thread.sleep(1000);
        txtpassword.sendKeys(Keys.ENTER);
        WebElement ele1 = driver.findElement(By.id("info"));
        assertEquals("Incorrect Password!", ele1.getAttribute("value"));
        System.out.println("Test Incorrect Password Success!");
        Thread.sleep(1000);
    }

    //TEST INVALID USERNAME
    @Test(priority = 2)
    public void TestcheckInvalidUsername() throws InterruptedException {
        driver.get("http://localhost:8084/ASM/loginql.jsp");
        driver.findElement(By.name("txtusername")).sendKeys("truong");
        WebElement txtpassword = driver.findElement(By.name("txtpassword"));
        txtpassword.sendKeys("123");
        Thread.sleep(1000);
        txtpassword.sendKeys(Keys.ENTER);
        WebElement ele1 = driver.findElement(By.id("info"));
        assertEquals("Invalid Username!", ele1.getAttribute("value"));
        System.out.println("Test Invalid Username Success!");
        Thread.sleep(3000);
    }

    //TEST LOGIN SUCCESS
    @Test(priority = 3)
    public void TestcheckLoginSuccess() throws InterruptedException {
        driver.get("http://localhost:8084/ASM/loginql.jsp");
        driver.findElement(By.name("txtusername")).sendKeys("minhhao");
        WebElement txtpassword = driver.findElement(By.name("txtpassword"));
        txtpassword.sendKeys("123");
        Thread.sleep(1000);
        txtpassword.sendKeys(Keys.ENTER);
        WebElement ele1 = driver.findElement(By.id("info"));
        assertEquals("Login Successfully!", ele1.getAttribute("value"));
        System.out.println("Test Login Success!");
        Thread.sleep(1000);
    }
}
