package Gun07;

import Utility.BaseDriver;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;


/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */

public class _01_WishList extends BaseDriver {

    @Test
    @Parameters("searchText")
    public void addToWishList(String aranacakKelime) {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(aranacakKelime + Keys.ENTER);

        List<WebElement> wishButtons=driver.findElements(  // ürünlerin wish butonları
                By.xpath("//button[@data-original-title='Add to Wish List']"));

        List<WebElement> productList=driver.findElements( // ürünlerin başlıkları
                By.xpath("//div[@class='caption']//h4"));

        int randomSecim= MyFunc.randomGenerator(productList.size()); // random bir sayı üretildi
        String wishItemText=productList.get(randomSecim).getText(); // random daki ürünün adı alındı
        System.out.println("wishItemText = " + wishItemText); //kontrol için yazıldı

        wishButtons.get(randomSecim).click(); // ilgili Random ürünün wish butonuna tıklandı

        WebElement wishListLink= driver.findElement(By.xpath("//span[contains(text(),'Wish List')]"));
        wishListLink.click();


        //  Wish List e gidildi
        List<WebElement> wishList=driver.findElements(By.xpath("//td[@class='text-left']/a"));

        //aradığımız ürün listede var mı yok mu?
        boolean bulundu=MyFunc.listContainsString(wishList, wishItemText);

        Assert.assertTrue(bulundu,"Wish Liste atanan ürün bulunamadı");
    }





}
