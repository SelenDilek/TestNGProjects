package Gun05;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**

 Daha önceki derslerde yaptğımız Search fonksiyonunu
 mac,ipod ve samsung için Dataprovider ile yapınız.
 */
public class _03_Soru extends BaseDriver {
    @Test (dataProvider = "getData")
    void Test1(String arananKelime) {

        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.clear();
        searchInput.sendKeys(arananKelime + Keys.ENTER); //keys enter eger enter ile search yapabiliyorsa kullanilir

        List<WebElement> captions = driver.findElements(By.cssSelector("[class='caption'] > h4"));
        for (WebElement e : captions) {
            System.out.println("e.getText() = " + e.getText());

            Assert.assertTrue(e.getText().toLowerCase().contains(arananKelime), "aranan kelime bulunamadi");

        }
    }

            @DataProvider
            Object[] getData () {

                Object[] data = {"mac","samsung" ,"ipod"}; //bunlarin her biri test

                return data;
            }

        }

