package Gun02;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _01_Enable {
    public static WebDriver driver;

    public static WebDriverWait wait;
    @Test
    public void test1(){

        System.out.println("Test1 calisti." );}

    @Test(enabled = false)
    public void test2(){

        System.out.println("Test2 calisti." );}

    @Test
    public void test3(){

        System.out.println("Test3 calisti." );}


    @BeforeClass
    public void baslangicIslemleri(){

        System.out.println("baslangicIslemleri calisti");
        Logger logger= Logger.getLogger("");
        logger.setLevel(Level.SEVERE);


        driver = new ChromeDriver();// jenkins deyken : sen head olmadan yani hafızada çalış
        driver.manage().window().maximize(); // Ekranı max yapıyor.

        driver.manage().window().maximize();//ekrani max yapiyor
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));//30 sn muhlet: sayfayi yukleme muhleti/toleransi
        //verilen sn yi asarsa hata verir
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//30 sn muhlet: elementi bulma muhleti/toleransi

        wait=new WebDriverWait(driver,Duration.ofSeconds(20));

    }

    @AfterClass
    public void bitisIslemleri(){

        System.out.println("bitisIslemleri calisti");
        MyFunc.Bekle(3);
        driver.quit();

    }


}
