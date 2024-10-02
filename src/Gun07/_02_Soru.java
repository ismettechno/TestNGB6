package Gun07;


/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */


import Gun06._05_PlaceOrder_Elementleri;
import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.tools.Tool;

public class _02_Soru extends BaseDriver {

    @Test
    @Parameters("searchText")
    public void addToWishList(String aranacakKelime) {
        _05_PlaceOrder_Elementleri poe = new _05_PlaceOrder_Elementleri();
        _01_Elements sre = new _01_Elements();

        poe.searchInput.sendKeys(aranacakKelime + Keys.ENTER);

        int randomSecim= Tools.randomGenerator(sre.productListCaption.size());

        String tiklatilacakUrununAdi=sre.productListCaption.get(randomSecim).getText();
        sre.productListAddWish.get(randomSecim).click();

        sre.wishList.click();

        boolean urunBulundu= Tools.listContainsString(sre.productListWish, tiklatilacakUrununAdi);
        Assert.assertTrue(urunBulundu, "Seçtiğiniz Wish Listte bulunamadı");
    }


}













