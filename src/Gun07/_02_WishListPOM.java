package Gun07;

import Utility.BaseDriver;
import Gun06._04_PlaceOrder_Elementleri;
import Utility.MyFunc;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız."ipod" u xml den gönderiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.
 */
public class _02_WishListPOM extends BaseDriver {
    @Test
    @Parameters("searchText")
    public void addToWishList(String aranacakKelime) {

        _04_PlaceOrder_Elementleri poe=new _04_PlaceOrder_Elementleri();
        _03_WishListElements wle=new _03_WishListElements();

        poe.searchBox.sendKeys(aranacakKelime + Keys.ENTER);

        int randomSecim= MyFunc.randomGenerator(wle.productList.size()); // random bir sayı üretildi
        String wishItemText=wle.productList.get(randomSecim).getText(); // random daki ürünün adı alındı
        wle.wishButtons.get(randomSecim).click(); // ilgili Random ürünün wish butonuna tıklandı
        wle.wishListLink.click();

        boolean bulundu=MyFunc.listContainsString(wle.wishList, wishItemText);
        Assert.assertTrue(bulundu,"Wish Liste atanan ürün bulunamadı");
    }


}
