package Gun01;

import org.testng.annotations.Test;

public class _02_Siralama {
    @Test(priority = 1) // öncelik ayarı yapılmazsa alfabetik çalışıyor
    public void DriverStartEdidi(){  System.out.println("Driver Start Edidi"); }

    @Test(priority = 2)  // priority verilmezse default 0 dır
    public void WebsitesiniAc(){ System.out.println("Websitesi Açıldı"); }

    @Test(priority = 3)
    public void LoginTestiniYap(){ System.out.println("Login Testi yapıldı ");  }

    @Test(priority = 4)
    public void SepetTestiniYap() { System.out.println("Sepet Testi yapıldı"); }

    @Test(priority = 5)
    public void DriverKapatildi() { System.out.println("Driver kapatıldı");  }
}
