package Gun06;

/*
  TODO: Ödev
  Senaryo;
  1- Brands menusune gidiniz.
  2- Burada her bir markanın üstünde yer alan harf ile başladığını doğrulayınız
*/

import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _01_Soru extends BaseDriver {
//    harfler  [id='content'] h2
//    markalar bölgesi(markaların olduğu html bloğu) [id='content'] > div
//
//0.harfin ne harfi olduğunu alıcam A harfi
//0.markalar bloğundaki markaları alıcam ve A harfiyle başlıyormu
//    onu kontrol edicem

    @Test
    public void BrandsValidation()
    {
        WebElement brandsLink = driver.findElement(By.linkText("Brands"));
        brandsLink.click();

        List<WebElement> harfler=driver.findElements(By.cssSelector("[id='content'] h2")); //A C H
        List<WebElement> markalarSatiri=driver.findElements(By.cssSelector("[id='content'] > div")); // Hav Htc

        for (int i = 0; i < harfler.size(); i++) {
            String harf= harfler.get(i).getText(); // A
            WebElement harfinAltindakiSatir= markalarSatiri.get(i); // Apple Apple2

            List<WebElement> markalar= harfinAltindakiSatir.findElements(By.tagName("div"));  //Apple Apple2

            for (WebElement marka: markalar) {
                System.out.println(harf+" "+marka.getText());
                Assert.assertTrue(harf.charAt(0)==marka.getText().charAt(0), "Başlık ve marka uyumlu değil");
            }
                //MArkanın ilk harfi Harf ile başlıyor mu?
                //Assert.assertTrue(marka.startsWith(harf)
        }




    }


}


//<div class="row">
//
//    <div class="col-sm-3"><a href="http://openp;manufacturer_id=7">Hewlett-Packard</a></div>
//    <div class="col-sm-3"><a href="http://openp;manufacturer_id=5">HTC</a></div>
//
//</div>
//
//List<WebElemnt> markalar= driver.findElement   Tüm sayafada ara
//List<WebElemnt> markalar= markalarSatiri.findElement(By.tagName('div'));
//                                                    (By.className('col-sm-3')
//Elementin içinde Element/ler   arama