package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
    Hard assert'ler, test koşulunun karşılanmadığını tespit ettiğinde, testin başarısız olmasına neden     olur.
    Bu, testin sonraki adımlarına geçilmesini engeller ve testin hatalı olduğunun hızlı bir şekilde tespit edilmesini sağlar.

    Soft assert'ler, bir test koşulunun karşılanmadığını tespit ettiğinde, testin başarısız olmasına neden olmaz.
    Bunun yerine, hata mesajını bir hata kümesine kaydeder. Bu, testin sonraki     adımlarına geçilmesini sağlar ve
    testin hatalı olduğunun daha ayrıntılı bir şekilde incelenmesini sağlar.
*/

public class _02_SoftAssertVSHardAssert {


    @Test
    public void asserTest() {
        String s1 = "Merhaba";

        System.out.println("Assert oncesi");
        Assert.assertEquals("Merhaba123", s1, "Olusan ile eklenen ayni degil");
        System.out.println("Assert sonrasi");
        //hata verir oncesini yazar sonrasini yazmaz.

    }


    @Test
    public void softAssert() {
        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cardpage";
        String strEditeAccount = "www.facebook.com/editaccountpage";
        SoftAssert _softAssert = new SoftAssert(); //ayni elementi kullancam anlamina geliyor _


        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage); //passed!

        System.out.println("Assert 1");

        _softAssert.assertEquals("www.facebook.com/homepage",strCartPage); //fail
        System.out.println("Assert 2");

        _softAssert.assertEquals("www.facebook.com/homepage",strEditeAccount); //fail
        System.out.println("Assert 3");


        //AssertAll: adimlari biriktir ve isleme koy. Ben dedigimde isleme koyma komutu.
        _softAssert.assertAll(); //butun assert sonuclarini isleme koyuyor. //yukarida islemleri kirmadi
        //assertAll diyince isleme koyuyor bitis noktasini
        //hatalari ben dedigim zaman veriyor.
        System.out.println("soft assertAll : aktiflik sonrasi");


    }
}