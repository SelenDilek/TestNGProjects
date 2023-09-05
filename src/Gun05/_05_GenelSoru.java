package Gun05;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/*
  Senaryo
  1- Siteyi açınız.
  2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.(menuValidation)
  3- Desktops, Laptops & Notebooks, Components, Tablets, Software, Phones & PDAs, Cameras, MP3 Players
 */

public class _05_GenelSoru extends BaseDriver {

@Test
    public void menuValidation(){

        List<String> menuExpectedList=new ArrayList<>();
        menuExpectedList.add("Desktops");
        menuExpectedList.add("Laptops & Notebooks");
        menuExpectedList.add("Components");
        menuExpectedList.add("Tablets");
        menuExpectedList.add("Software");
        menuExpectedList.add("Phones & PDAs");
        menuExpectedList.add("Cameras");
        menuExpectedList.add("MP3 Players");


        List<WebElement> menuActualList=driver.findElements(By.cssSelector("[class='nav navbar-nav'] > li"));

        for (int i = 0; i <menuActualList.size() ; i++) {

            Assert.assertEquals(menuActualList.get(i).getText(),menuExpectedList.get(i),"Menu beklendigi gibi degil");

            //Assert ta TestNG ye ait ya        da Junit e ait
            //Actual,Expected,Mesaj             Mesaj,Actual,Expected
        }



    }










//    @Test(dataProvider = "getData")
//    void Test1(String kelime) {
//
//        WebElement searchInput = driver.findElement(By.name("search"));
//        searchInput.clear();
//        searchInput.sendKeys("samsung" + Keys.ENTER); //keys enter eger enter ile search yapabiliyorsa kullanilir
//
//        List<WebElement> liste = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));
//        for (WebElement item : liste)
//
//            Assert.assertEquals(item.getText(),kelime,"Kelimeler esit degildir");
//        }
//
//
//    @DataProvider
//    public Object[] getData() { //DataProvider da yazilan her eleman bir testtir. O yuzden tumlu islemlerde bu kullanilmaz.
//
//        Object[] data = {"Desktops","Laptops & Notebooks" ,"Components","Tablets" ,"Software","Phones & PDAs","Cameras" ,"MP3 Players"};
//
//        return data;
//    }

}
