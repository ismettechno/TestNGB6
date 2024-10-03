package Gun07;

/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan random birini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Seçilen ürünün sepette olduğunu doğrulayınız.
   6- POM ile çözünüz.


   ihtiyaç olacak ise:

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public List<WebElement> addToChartLAR;
 */


import Gun06._05_PlaceOrder_Elementleri;
import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Soru extends BaseDriver {


    @Test
    public void addToCart()
    {
        BaseDriver.logEkle.info("addToCart testi başladı");
        _05_PlaceOrder_Elementleri poe=new _05_PlaceOrder_Elementleri();
        _01_Elements sre= new _01_Elements();

        poe.searchInput.sendKeys("ipod"+ Keys.ENTER);

        int randomSecim= Tools.randomGenerator(sre.productListAddCart.size()); // 0,1,2,3
        System.out.println(randomSecim);

        //tıkaltmadan önce ürürnün ismini saklayalım
        String tiklatilacakUrununAdi=sre.productListCaption.get(randomSecim).getText();
        sre.productListAddCart.get(randomSecim).click(); // Add chart a tıklandı

        poe.shoppingChart.click();

//        boolean urunBulundu=false;
//        for(WebElement urun : sre.productListBasket)
//        {
//            if (urun.getText().equals(tiklatilacakUrununAdi)) {
//                urunBulundu = true;
//                break;
//            }
//        }

        boolean urunBulundu=Tools.listContainsString(sre.productListBasket, tiklatilacakUrununAdi); // yukarıdaki döngü metod yapıldı
        Assert.assertTrue(urunBulundu,"Eklediğiniz sepette bulunamadı");


    }


}
