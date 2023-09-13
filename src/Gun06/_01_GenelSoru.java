package Gun06;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

/*
  Senaryo;
  1- Brands menusune gidiniz.
  2- Burada her bir markanın üstünde yer alan harf ile başladığını doğrulayınız
*/
public class _01_GenelSoru extends BaseDriver {
    //elemntin altinda elementler bulma yontemi :

    @Test
    public void brandValidation(){

        WebElement brandsLink = driver.findElement(By.linkText("Brands"));
        brandsLink.click();

        List<WebElement> harfler =driver.findElements(By.cssSelector("[id='content'] > h2")); //harkler
        List<WebElement> markalarSatirlari =driver.findElements(By.cssSelector("[id='content'] > div")); //marka satirlari(her satir icinde bir veya birden cok marka tutuyor)

        for (int i = 0; i <harfler.size() ; i++) {


            List<WebElement> markalar = markalarSatirlari.get(i).findElements(By.tagName("div"));//markalar buunun icinde
            //By.cssSelector("[class='col-sm-3']")
            //element icinde element arnirken xpath kullanilmaz cunku o tum sayfaya bakar.

            for(WebElement marka : markalar){

                System.out.println(harfler.get(i).getText()+" " + marka.getText().charAt(0)+" " + marka.getText());

                Assert.assertEquals(harfler.get(i).getText().charAt(0),marka.getText().charAt(0));
            }
        }


//TODO : aynı soruyu  https://www.ebay.com/n/all-brands bu siteden testedebilir.













//        driver.findElement(By.linkText("Brands")).click();
//        List<WebElement> letters = driver.findElements(By.xpath("//div[@id='content']//p//a"));
//        List<WebElement> brandss=driver.findElements(By.xpath("//*[@id=\"content\"]/div/div"));
//
//        for(WebElement e : brandss){
//
//            System.out.println("e.getText() = " + e.getText());
//        }
//
//        for(WebElement l : letters){
//
//            System.out.println("l.getText() = " + l.getText());
//        }

//        String ilkHarf="";
//        for (int i = 0; i <6 ; i++) {
//
//            ilkHarf = brandss.get(i).getText().toUpperCase().substring(0, 1);
//            System.out.println("ilkHarf = " + ilkHarf);
//            for (int j = 0; j < letters.size(); j++) {
//
//                Assert.assertEquals(ilkHarf,letters.get(j).getText());
//
//
//            }
//        }



        }

        }




