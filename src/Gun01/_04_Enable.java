package Gun01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _04_Enable {
    @Test
    public void Test1(){
        System.out.println("Test 1 çalıştı");
        driver.get("https://www.facebook.com/");
     }

    @Test(enabled = false) // şimdilik çalışma
    public void Test2(){ System.out.println("Test 2 çalıştı");  }

    @Test
    public void Test3(){ System.out.println("Test 3 çalıştı");
        driver.get("https://www.google.com/");
    }

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void BaslangicIslemleri(){
        System.out.println("Başlangıç işlemleri yapılıyor");

        driver=new ChromeDriver();

        //driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterClass
    public void KapanisIslemleri(){
        System.out.println("Kapanis işlemleri yapılıyor");

        //Tools.Bekle(3);
        driver.quit();
    }



}
