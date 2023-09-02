package Gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

//Github -> vcs->gitenable -> class Add. -> commit -> git share projemi paylas.
public class _01_Giris {


//    public static void main(String[] args) {
//        driverIslemleriniYap();
//        websitesiniAc();
//        LoginTestiniYap()
//    }

//      @Test JUnit Test i
//      public void Test1()
//      {
//          driverIslemleriniYap();
//          websitesiniAc();
//          LoginTestiniYap()
//      }

    //Default olarak alfabetik sıraya göre çalışır.

    @Test(priority = 1)// default : 0, aynı sevilere yine alfabetik çalışır
    public void driverIslemleriniYap(){

        System.out.println("driverIslemleriniYap yapıldı");

    }

    @Test(priority = 2)
    public void webSitesiniAc(){
        System.out.println("websitesiniAc işlemi yapıldı");

    }

    @Test(priority = 3)
    public void LoginTestiniYap(){

        System.out.println("loginTestiniYap işlemi yapıldı");
    }

    @Test(priority = 4)
    public void driverKapat(){
        System.out.println("driverKapat işlemi yapıldı");

    }

    //boyle calistirinca sirasi ile calistirmiyor. //herhangi bir sey vermezsek alfabetik sirasiya gore methidlar calisir.
    //ciktiya gore anlariz output un sag tarafinda cikan yazilara gore.
}
