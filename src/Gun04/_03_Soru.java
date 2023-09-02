package Gun04;

import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
   bu örneği istediğin aşamada sorabilirsin, ister burda ister paralel testten sonra
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun lerde (bütün ürünlerde indirim var mı eski fiyat yeni fiyattan büyük mü)
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
      yüksek olduğunu doğrulayınız.
   5- Yukarıdaki işlemi 2 farklı browserda ve paralel şekilde test ediniz.
*/

public class _03_Soru extends BaseDriverParameter {

    @Test
    public void Test1(){

        WebElement specials=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("/html/body/footer/div/div/div[3]/ul/li[4]/a")));
        //
        specials.click();
        System.out.println("tiklama yapildi");

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='caption']//h4"));

        for (int i = 1; i < list.size(); i++) {
           WebElement newPrice=
                   driver.findElement(By.xpath("(//div[@class='caption']//p[@class='price']//span[@class='price-new']["+i+"])"));


           Double newPriceDouble = Double.parseDouble(newPrice.getText().trim().replace("$",""));
            System.out.println("newPriceDouble = " + newPriceDouble);

         WebElement oldPrice=
                 driver.findElement(By.xpath("(//div[@class='caption']//p[@class='price']//span[@class='price-old']["+i+"])"));

            Double olduPriceDouble = Double.parseDouble(oldPrice.getText().trim().replace("$",""));
            System.out.println("olduPriceDouble = " + olduPriceDouble);

          Assert.assertTrue(newPriceDouble<olduPriceDouble,"Yeni fiyat eskisinden buyuktur indirim yapilmamistir!");

            System.out.println("Test basarili !");


        }

    }
}
