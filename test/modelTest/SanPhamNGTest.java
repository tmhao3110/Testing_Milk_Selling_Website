/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelTest;

import java.sql.SQLException;
import java.util.List;
import model.SanPham;
import model.SanPhamModel;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.*;
import org.testng.annotations.*;

/**
 *
 * @author Minh Hao
 */
public class SanPhamNGTest {

    private static WebDriver driver;
    SanPhamModel model = new SanPhamModel();

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

    //TEST ADD NEW PRODUCT
    @Test(priority = 1)
    public void testInsertSP() throws InterruptedException {
        SanPham newSanPham = new SanPham("SP03", "Sữa bịch có đường", 8000, "suaBichCoDuong_220ml.jpg", 2);
        model.deleteSP(newSanPham.getMaSP());
        driver.get("http://localhost:8084/ASM/loginsp.jsp");
        driver.findElement(By.name("txtusername")).sendKeys("minhhao");
        WebElement txtpassword = driver.findElement(By.name("txtpassword"));
        txtpassword.sendKeys("123");
        Thread.sleep(1000);
        txtpassword.sendKeys(Keys.ENTER);
        driver.findElement(By.id("btnInsert")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("txtMASP")).sendKeys(newSanPham.getMaSP());
        Thread.sleep(1000);
        driver.findElement(By.name("txtTENSP")).sendKeys(newSanPham.getTenSP());
        Thread.sleep(1000);
        driver.findElement(By.name("txtGIA")).sendKeys(newSanPham.getGiaSP() + "");
        Thread.sleep(1000);
        driver.findElement(By.name("txtHINH")).sendKeys("C:\\Users\\Minh Hao\\Desktop\\img_Milk\\" + newSanPham.getHinhSP());
        Thread.sleep(1000);
        Select madm = new Select(driver.findElement(By.name("txtMADANHMUC")));
        madm.selectByIndex(1);
        Thread.sleep(1000);
        driver.findElement(By.id("btnSubmit")).click();
        List<WebElement> list = driver.findElements(By.tagName("tr"));
        boolean check = false;
        for (int i = 1; i < list.size() - 1; i++) {
            String src = list.get(i).findElements(By.tagName("td")).get(4).findElement(By.tagName("img")).getAttribute("src");
            if (list.get(i).findElements(By.tagName("td")).get(1).getText().equalsIgnoreCase("SP03")) {
                if (list.get(i).findElements(By.tagName("td")).get(2).getText().equalsIgnoreCase("Sữa bịch có đường")) {
                    if (list.get(i).findElements(By.tagName("td")).get(3).getText().equalsIgnoreCase(8000 + "")) {
                        if (src.substring(src.lastIndexOf("/") + 1).equalsIgnoreCase("suaBichCoDuong_220ml.jpg")) {
                            if (list.get(i).findElements(By.tagName("td")).get(5).getText().equalsIgnoreCase(2 + "")) {
                                check = true;
                            }
                        }
                    }
                }
            }
        }
        assertTrue(check);
        model.deleteSP(newSanPham.getMaSP());
    }
    //TEST UPDATE PRODUCT
    @Test(priority = 2)
    public void updateSP() throws InterruptedException, SQLException {
        SanPham newSanPham = new SanPham("SP03", "Sữa bịch có đường", 8000, "suaBichCoDuong_220ml.jpg", 1);
        model.deleteSP(newSanPham.getMaSP());
        model.insertSP(newSanPham);
        SanPham updateSanPham = new SanPham("SP03", "Sữa hộp có đường", 10000, "Suahop_180ml.jpg", 2);
        driver.get("http://localhost:8084/ASM/loginsp.jsp");
        driver.findElement(By.name("txtusername")).sendKeys("minhhao");
        WebElement txtpassword = driver.findElement(By.name("txtpassword"));
        txtpassword.sendKeys("123");
        Thread.sleep(1000);
        txtpassword.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.id("btnUpdate" + updateSanPham.getMaSP())).click();
        Thread.sleep(1000);
        driver.findElement(By.name("txtTENSP")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("txtTENSP")).sendKeys(updateSanPham.getTenSP());
        Thread.sleep(1000);
        driver.findElement(By.name("txtGIA")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("txtGIA")).sendKeys(updateSanPham.getGiaSP() + "");
        Thread.sleep(1000);
        driver.findElement(By.name("txtHINH")).sendKeys("C:\\Users\\Minh Hao\\Desktop\\img_Milk\\" + updateSanPham.getHinhSP());
        Thread.sleep(1000);
        Select madm = new Select(driver.findElement(By.name("txtMADANHMUC")));
        madm.selectByIndex(1);
        Thread.sleep(1000);
        driver.findElement(By.id("btnSubmit")).click();
        List<WebElement> list = driver.findElements(By.tagName("tr"));
        boolean check = false;
        for (int i = 1; i < list.size() - 1; i++) {
            String src = list.get(i).findElements(By.tagName("td")).get(4).findElement(By.tagName("img")).getAttribute("src");
            if (list.get(i).findElements(By.tagName("td")).get(2).getText().equalsIgnoreCase("Sữa hộp có đường")) {
                if (list.get(i).findElements(By.tagName("td")).get(3).getText().equalsIgnoreCase(10000 + "")) {
                    if (src.substring(src.lastIndexOf("/") + 1).equalsIgnoreCase("Suahop_180ml.jpg")) {
                        if (list.get(i).findElements(By.tagName("td")).get(5).getText().equalsIgnoreCase(2 + "")) {
                            check = true;
                        }
                    }
                }
            }
        }
        assertTrue(check);
        model.deleteSP(newSanPham.getMaSP());
    }

    //TEST DELETE PRODUCT
    @Test(priority = 3)
    public void deleteSP() throws InterruptedException, SQLException {
        SanPham newSanPham = new SanPham("SP03", "Sữa bịch có đường", 8000, "suaBichCoDuong_220ml.jpg", 1);
        model.deleteSP(newSanPham.getMaSP());
        model.insertSP(newSanPham);
        driver.get("http://localhost:8084/ASM/loginsp.jsp");
        driver.findElement(By.name("txtusername")).sendKeys("minhhao");
        WebElement txtpassword = driver.findElement(By.name("txtpassword"));
        txtpassword.sendKeys("123");
        Thread.sleep(1000);
        txtpassword.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.id("btnDelete" + newSanPham.getMaSP())).click();
        WebElement thongbao = driver.findElement(By.xpath("/html/body/div[2]/h1"));
        assertEquals("Thanhcong", thongbao.getText());
    }
}
