/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import java.util.List;
import model.HoaDonModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Minh Hao
 */
public class ItemNGTest {

    public ItemNGTest() {
    }

    private static WebDriver driver;
    HoaDonModel model = new HoaDonModel();

    @BeforeClass
    public static void createAndStartService() {
        System.setProperty("webdriver.chrome.driver",
                "D:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public static void stopService() {
        driver.quit();
    }

    @Test(priority = 1)
    public void addNewCart() throws InterruptedException {
        driver.get("http://localhost:8084/ASM/clientsp.jsp");
        int count = 0;
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/table/tbody/tr[5]/td/a")).click();
        count++;
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/a[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/table/tbody/tr[5]/td/a")).click();
        count++;
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.tagName("tr"));
        int soluong = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            soluong += Integer.parseInt(list.get(i).findElements(By.tagName("td")).get(4).getText());
        }
        assertEquals(count, soluong);
    }

    @Test(priority = 2)
    public void Thanhtoan() {
        driver.get("http://localhost:8084/ASM/clientsp.jsp");
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/table/tbody/tr[5]/td/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/a[3]/input")).click();
        WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/h1"));
        assertEquals(ele.getText(), "Dat hang thanh cong, ma Hoa Don la: " + model.getMaHDlastest());
    }
}
