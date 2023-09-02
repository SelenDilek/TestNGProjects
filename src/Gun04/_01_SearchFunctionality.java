package Gun04;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _01_SearchFunctionality extends BaseDriver {

    /*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung için de yapınız
    */

    // Not : iki kere yazmak yerine mac ve samsung icin iki ayri test olarak xml de calistirip parametre gonderebiliriz.
    //Not: eger element tiklanmiyorsa gorunmuyorsa javascriptexecutor , veya mouseover ve kapatma

    @Test
    @Parameters("searchText")
    void Test1(String arananKelime){

        WebElement searchInput =driver.findElement(By.name("search"));
        searchInput.sendKeys(arananKelime+ Keys.ENTER); //keys enter eger enter ile search yapabiliyorsa kullanilir

        List<WebElement > captions=driver.findElements(By.cssSelector("[class='caption'] > h4"));
        for(WebElement e : captions){
            System.out.println("e.getText() = " + e.getText());

            Assert.assertTrue(e.getText().toLowerCase().contains(arananKelime),"aranan kelime bulunamadi");

        }


    }

}
