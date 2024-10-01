package Gun06;

import Utlity.BaseDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

// Bu sayfadaki bütün elemanların driverlar bağlantısı gerekiyor
// bunun için aşağıdaki consructor eklendi ve için PageFatory ile
// driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
// Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
// anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
// aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
// gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.
// Faydaları: kod düzeni daha rahat, aynı locatorlar için tek bir tanımlama, kullanıldığı anda bulma, ve agile için
// tam kolay çalışma yani developer başlamadan veya bitirmesini beklemeden sen kodları yazabilir, ve kolaylıkla
// değişiklik yapabilirsin.

public class _05_PlaceOrder_POM extends BaseDriver {

    @Test
    public void ProceedToCheckout(){
        _05_PlaceOrder_Elementleri elements=new _05_PlaceOrder_Elementleri();

        elements.searchInput.sendKeys("ipod" + Keys.ENTER);
        elements.addToChart.click();
        elements.shoppingChart.click();
        elements.checkOut.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.continue1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue3)).click();

        elements.agree.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.continue4)).click();
        elements.confirm.click();

        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals(elements.ekranYazi.getText(), "Your order has been placed!", "Oluşan Mesajlar Eşleşmiyor");


    }

}
