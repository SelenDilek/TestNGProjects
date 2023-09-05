package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*

 */

public class _01_DataProvider {

    @Test(dataProvider = "datalarim")
    public void  searchTest(String aranacakText){

        System.out.println("aranacakText = " + aranacakText);
    }


    //Dongu yok ama dongu gibi yazdiriyor. (makinali tufek gibi asagidaki sarjoru)


    @DataProvider
    Object[] datalarim(){

        Object[] aranacaklar = {"mac","samsung","laptop"}; //Object her seyin ustunde demek


        return aranacaklar;
    }
    
    /***************************************************************************************************************/
    
    //2. ornek
    @Test(dataProvider = "datalar") //buraya "getData" da diyebilirdik
    public void Test2(int veri){
        System.out.println("veri = " + veri);

    }
    
    @DataProvider(name="datalar") //sen veri saglayicisin test degilsin. //kendisini cagirabiliriz ya da kendimiz isim verip cagirabiliriz,
    Object[] getData(){
        
        Object[] data= {1,2,3,4,5,6};
        
        
        return data;
    }
}
