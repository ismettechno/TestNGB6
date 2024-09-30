package Gun05;

/*

   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun lerde (bütün ürünlerde indirim var mı, eski fiyat yeni fiyat var mı)
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
      yüksek olduğunu doğrulayınız.
   5- Yukarıdaki işlemi 2 farklı browserda ve paralel şekilde test ediniz.

*/

import Utlity.BaseDriver;
import Utlity.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _01_Soru extends BaseDriverParameter {

    @Test
    public void Specials() {
        WebElement specials = driver.findElement(By.linkText("Specials"));
        specials.click();

        List<WebElement> newPrices = driver.findElements(By.cssSelector("[class='price-new']"));
        List<WebElement> oldPrices = driver.findElements(By.cssSelector("[class='price-old']"));

        Assert.assertTrue(newPrices.size() == oldPrices.size(), "Bütün ürünlerde indirim yok");

        for (int i = 0; i < newPrices.size(); i++) {
            double newPrice=Double.parseDouble(newPrices.get(i).getText().replaceAll("[^0-9.,]", ""));
            double oldPrice=Double.parseDouble(oldPrices.get(i).getText().replaceAll("[^0-9.,]", ""));

            System.out.println(newPrice+" "+oldPrice);
            Assert.assertTrue(newPrice < oldPrice, "Yeni Eski fiyattan küçük değil");
        }
    }

}
