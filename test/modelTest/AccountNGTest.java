/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import java.util.List;

import java.io.*;
import java.sql.SQLException;
import model.Account;
import model.AccountModel;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import static org.junit.Assert.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

/**
 *
 * @author Minh Hao
 */
public class AccountNGTest {

    private static WebDriver driver;
    AccountModel model = new AccountModel();

    public AccountNGTest() {
    }

    @BeforeClass
    public static void createAndStartService() throws IOException {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Program Files\\Mozilla Firefox\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("headless");
        driver = new FirefoxDriver(options);
    }

    @AfterClass
    public static void stopService() {
        driver.quit();
    }

//    @Before
//    public void createDriver() {
//        driver = new ChromeDriver();
//    }
////
//    @After
//    public void quitDriver() {
//        driver.close();
//    }
    //TEST ADD NEW ACCOUNT
    @Test(priority = 4)
    public void testAddNewAcc() throws InterruptedException {
        Account newAccount = new Account("chuduc", "123");
        model.deleteAccount(newAccount);
        driver.get("http://localhost:8084/ASM/loginql.jsp");
        driver.findElement(By.name("txtusername")).sendKeys("minhhao");
        WebElement txtpassword = driver.findElement(By.name("txtpassword"));
        txtpassword.sendKeys("123");
        Thread.sleep(1000);
        txtpassword.sendKeys(Keys.ENTER);
        driver.findElement(By.id("btnInsert")).click();
        Thread.sleep(500);
        driver.findElement(By.name("txtusername")).sendKeys(newAccount.getUsername());
        Thread.sleep(500);
        driver.findElement(By.name("txtpassword")).sendKeys(newAccount.getPassword());
        Thread.sleep(500);
        driver.findElement(By.id("btnSubmit")).click();
        List<WebElement> list = driver.findElements(By.tagName("tr"));
        boolean check = false;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).findElements(By.tagName("td")).get(1).getText().equalsIgnoreCase("chuduc")) {
                System.out.println("Found chuduc at Row: " + i);
                if (list.get(i).findElements(By.tagName("td")).get(2).getText().equalsIgnoreCase("123")) {
                    System.out.println("Correct password!");
                    check = true;
                }
            }
        }
        assertTrue(check);
        model.deleteAccount(newAccount);
        System.out.println("Test Add New Account Success!");
        Thread.sleep(1000);
    }

    //TEST ADD FALSE ACCOUNT
    @Test(priority = 5)
    public void TestcheckWrongAccountAdded() throws InterruptedException {
        Account newAccount = new Account("*@&^*$&^", "123");
        driver.get("http://localhost:8084/ASM/loginql.jsp");
        driver.findElement(By.name("txtusername")).sendKeys("minhhao");
        WebElement txtpassword = driver.findElement(By.name("txtpassword"));
        txtpassword.sendKeys("123");
        Thread.sleep(1000);
        txtpassword.sendKeys(Keys.ENTER);
        driver.findElement(By.id("btnInsert")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("txtusername")).sendKeys(newAccount.getUsername());
        Thread.sleep(1000);
        driver.findElement(By.name("txtpassword")).sendKeys(newAccount.getPassword());
        Thread.sleep(1000);
        driver.findElement(By.id("btnSubmit")).click();
        WebElement ele1 = driver.findElement(By.id("info"));
        assertEquals("Invalid Username", ele1.getAttribute("value"));
        model.deleteAccount(newAccount);
        System.out.println("Test Add Invalid Username Success!");
        Thread.sleep(1000);
    }

    //TEST UPDATE ACCOUNT
    @Test(priority = 6)
    public void TestupdateAcc() throws InterruptedException, SQLException {
        System.out.println("Updating............");
        Account newAccount = new Account("chuduc", "123");
        model.deleteAccount(newAccount);
        model.insertAccount(newAccount);
        Account updateAccount = new Account("chuduc", "123456");
        driver.get("http://localhost:8084/ASM/loginql.jsp");
        driver.findElement(By.name("txtusername")).sendKeys("minhhao");
        WebElement txtpassword = driver.findElement(By.name("txtpassword"));
        txtpassword.sendKeys("123");
        Thread.sleep(1000);
        txtpassword.sendKeys(Keys.ENTER);
        driver.findElement(By.id("btnUpdate" + updateAccount.getUsername())).click();
        Thread.sleep(1000);
        driver.findElement(By.name("txtpassword")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("txtpassword")).sendKeys(updateAccount.getPassword());
        Thread.sleep(1000);
        driver.findElement(By.id("btnSubmit")).click();
        List<WebElement> list = driver.findElements(By.tagName("tr"));
        boolean check = false;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).findElements(By.tagName("td")).get(1).getText().equalsIgnoreCase("chuduc")) {
                System.out.println("Found chuduc at Row: " + i);
                if (list.get(i).findElements(By.tagName("td")).get(2).getText().equalsIgnoreCase("123456")) {
                    System.out.println("Correct password updated! " + updateAccount.getPassword());
                    check = true;
                }
            }
        }
        assertTrue(check);
        model.deleteAccount(newAccount);
        System.out.println("Test Update Account Success!");
        Thread.sleep(1000);
    }

    //TEST DELETE ACCOUNT
    @Test(priority = 7)
    public void TestdeleteAcc() throws InterruptedException, SQLException {
        Account newAccount = new Account("chuduc", "123");
        model.deleteAccount(newAccount);
        model.insertAccount(newAccount);
        driver.get("http://localhost:8084/ASM/loginql.jsp");
        driver.findElement(By.name("txtusername")).sendKeys("minhhao");
        WebElement txtpassword = driver.findElement(By.name("txtpassword"));
        txtpassword.sendKeys("123");
        Thread.sleep(1000);
        txtpassword.sendKeys(Keys.ENTER);
        driver.findElement(By.id("btnDelete" + newAccount.getUsername())).click();
        List<WebElement> list = driver.findElements(By.tagName("tr"));
        String username1 = null;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i).findElements(By.tagName("td")).get(1).getText().equalsIgnoreCase("chuduc")) {
                System.out.println("Found chuduc at Row: " + i);
                username1 = list.get(i).findElements(By.tagName("td")).get(1).getText();
            }
        }
        assertNull(username1);
        System.out.println("Test Delete Account Success!");
        Thread.sleep(1000);
    }
}
