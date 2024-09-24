package Gun01;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES)  , işlemin başarılı olduğunu kontrol ediniz.
  3-
  4-
 */

import Utlity.BaseDriver;
import Utlity.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _08_SubscribeNewsLetter extends BaseDriver {

    @Test
    public void SubscribeFunctionYes() {
        WebElement  newsLetterLink=driver.findElement(By.xpath("(//a[text()='Newsletter'])[1]"));
        newsLetterLink.click();

        WebElement  subscribeYes=driver.findElement(By.xpath("//input[@value='1']"));
        subscribeYes.click();

        WebElement  continueButton=driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        Tools.SuccessMessageValidation();
    }


}
