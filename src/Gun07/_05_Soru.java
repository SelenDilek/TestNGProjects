package Gun07;

import Gun06._04_PlaceOrder_Elementleri;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan random birini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Seçilen ürünün sepette olduğunu doğrulayınız.
   6- POM ile çözünüz.
 */
public class _05_Soru extends BaseDriver {

    @Test
    public void addTocard() {


        _04_PlaceOrder_Elementleri poe=new _04_PlaceOrder_Elementleri();
        _03_WishListElements wle=new _03_WishListElements();
        poe.searchBox.sendKeys("ipod" + Keys.ENTER);

        int randomSecim= MyFunc.randomGenerator(wle.productList.size()); // random bir sayı üretildi
        String cartItemText=wle.productList.get(randomSecim).getText(); // random daki ürünün adı alındı

        wle.addToChart.get(randomSecim).click(); // ilgili Random ürünün wish butonuna tıklandı
        wle.shoppingCart.click();

        boolean bulundu=MyFunc.listContainsString(wle.wishList, cartItemText);
        Assert.assertTrue(bulundu,"Sepet Listesinde aranan ürün bulunamadı");
    }
}