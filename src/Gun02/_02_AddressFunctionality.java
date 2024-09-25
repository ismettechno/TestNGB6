package Gun02;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En sondaki adresi siliniz.
 */

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class _02_AddressFunctionality extends BaseDriver {

    @Test
    void AddAddress(){
        WebElement addressBook=driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        WebElement newAdress=driver.findElement(By.linkText("New Address"));
        newAdress.click();

        WebElement firstName= driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("İsmet");

        WebElement lastname= driver.findElement(By.id("input-lastname"));
        lastname.sendKeys("Temur");

        WebElement company= driver.findElement(By.id("input-company"));
        company.sendKeys("Techno Study");

        WebElement address1= driver.findElement(By.id("input-address-1"));
        address1.sendKeys("21a London Road");

        WebElement address2= driver.findElement(By.id("input-address-2"));
        address2.sendKeys("RG2 5BJ");

        WebElement city= driver.findElement(By.id("input-city"));
        city.sendKeys("Reading");

        WebElement postCode= driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("12345");

        WebElement webCountry=driver.findElement(By.id("input-country"));
        Select country=new Select(webCountry);
        country.selectByVisibleText("Turkey");

        //wait.until(ExpectedConditions.elementToBeClickable(webCountry)); // ulke tekrar seçilebilir hale gelene kadar bekle

        WebElement webState=driver.findElement(By.id("input-zone"));
        Select state=new Select(webState);
        state.selectByVisibleText("Ankara"); //Anka olarak gözüken yazılı olan seçeneği seç, implictiliy kullanıyor
        //state.selectByIndex(2); bu satır yukarıdaki wait çalışır

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        Tools.SuccessMessageValidation();
    }

    @Test(dependsOnMethods = {"AddAddress"})
    void EditAddress() {
        WebElement addressBook=driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> EditAll=driver.findElements(By.linkText("Edit")); //bütün editler
        WebElement sonEdit=EditAll.get( EditAll.size()-1 ); // en sondaki Edit butonu
        sonEdit.click();

        WebElement firstName= driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("İsmet5");

        WebElement lastname= driver.findElement(By.id("input-lastname"));
        lastname.clear();
        lastname.sendKeys("Temur5");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        Tools.SuccessMessageValidation();
    }

    @Test(dependsOnMethods = {"EditAddress"})
    void DeleteAddress() {
        WebElement addressBook=driver.findElement(By.linkText("Address Book"));
        addressBook.click();

        List<WebElement> DeleteAll=driver.findElements(By.linkText("Delete")); //bütün Delete ler
        WebElement sonDelete=DeleteAll.get( DeleteAll.size()-1 ); // en sondaki Delete butonu
        sonDelete.click();

        Tools.SuccessMessageValidation();
    }
}
