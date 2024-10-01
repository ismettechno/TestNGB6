package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _03_SoftAssertVsHardAssert {

    @Test
    public void HardAssert(){
        String s1="Merhaba";

        System.out.println("Assert Öncesi");
        Assert.assertEquals("Merhaba123",s1,"Oluşanla beklene aynı değil"); // hata verdiğinde test sonlanıyor
        System.out.println("Assert Sonrası");
    }

    @Test
    public void SoftAssert() {
        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cartpage";
        String strEditAccount = "www.facebook.com/editaccountpage";

        SoftAssert _softAssert=new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage); //hata yok
        System.out.println("Assert 1");

        _softAssert.assertEquals("www.facebook.com/profile", strCartPage, "oluşanla beklene aynı değil"); //Hata VAR
        System.out.println("Assert 2");

        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount, "oluşanla beklene aynı değil"); //hata VAR
        System.out.println("Assert 3");

        //ben hataları işleme koy deyince , bu noktada hataları aktif etsin, arada kesilmesin
        _softAssert.assertAll();  //softan harda geçir

        System.out.println("soft AssertAll() sonrası");
    }

}








