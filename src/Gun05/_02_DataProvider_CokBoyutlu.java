package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_CokBoyutlu {

    @Test(dataProvider = "UserData")
    public void userTest(String usurname , String password){
        //username , password
        /*
        ismet,1234
        mehmet,sifre5
        ayse,benimsifrem1

         */
        System.out.println(usurname + " " + password);
    }


    @DataProvider
    public Object[][] UserData(){ //2 boyutlu dizi mantigi , key-value gibi dusun
        //DataProvider olarak kullanilacak methodun tipi Object olmak zorunda.

        Object[][] data = {
                {"ihsan" , "123445"},
                {"selen" , "selen17"},
                {"murat" , "27"},
                {"zeynep" ,"12345"}
        };

        return data;
    }
    /**

     Aşağıdaki ikili ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
     data sayısı kadar test çalıştırılır, dataların olduğu yere DataProvider annottion ı konur.
     çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
     Dataprovider bir testi birden fazla DATA ile çok çalıştırmak için kullanılır.
     XML file ise file gruplama, pararalel, ve farklı tesleri koordine edip birarada çalıştırmak için kullanılır.
     */






}
