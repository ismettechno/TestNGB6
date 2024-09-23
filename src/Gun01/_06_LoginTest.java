package Gun01;

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _06_LoginTest extends BaseDriver {
//  Senaryo
//  1- Siteye Login olunuz
//  2- Login olduğunuzu Title ile Assert yapınız.

    @Test
    public void Test1() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        Tools.Bekle(2);

        WebElement email=driver.findElement(By.id("input-email"));
        email.sendKeys("testng1@gmail.com");

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("123qweasd");

        WebElement loginBtn=driver.findElement(By.xpath("//input[@value='Login']"));
        loginBtn.click();

        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertTrue(driver.getTitle().equals("My Account"), "Login olunamadı");
    }


}
