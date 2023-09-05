package Gun05;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;
/**

 Bir önceki taskı PARAMETERDRIVER ile yapınız
 sonrasında farklı tarayıcılar ile çalıştırınız. (crossbrowser)
 sonrasında paralel çalıştırınız.(parallel)
 */
public class _04_Soru extends BaseDriverParameter {

    @Parameters("browserTipi")
    @Test(dataProvider = "getData")
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

        Object[] data = {"mac","samsung" ,"ipod"};

        return data;
    }





}
