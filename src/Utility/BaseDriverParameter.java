package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {
    //driver daki static keywordunu paralel test icin calistirdik
    public  WebDriver driver; // SingletonDriver method
    // paralel test icin static kaldirdik yani her extends oldugunda ayri bir driver calissin diye
    //her browser kendi driverini calistirir.
    public static WebDriverWait wait;

    @BeforeClass

    @Parameters("browserTipi")
    public void baslangicIslemleri(String browserTipi){
        //System.out.println("baslangicIslemleri çalıştı");

        Logger logger= Logger.getLogger(""); // output yapılan logları al.
        logger.setLevel(Level.SEVERE); // sadece ERROR ları göster

        switch (browserTipi.toLowerCase()){ //not : farkli browser larda ayni testi calistirma crossbrowser (sirayla) //paralel test: ayni anda farkli browser
            //paralel testing

            case "chrome" :
                driver= new ChromeDriver();
                break;

            case "firefox" :
                driver= new FirefoxDriver();
                break;

            case "edge" :
                driver= new EdgeDriver();
                break;
            case "safari" :
                driver= new SafariDriver();
                break;

            default:
                driver=new ChromeDriver();
                break;


        }
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginTesti();

    }

    public void loginTesti(){


        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        MyFunc.Bekle(2);
        WebElement myAccount=driver.findElement(By.xpath("//span[text()='My Account']"));
        myAccount.click();
        MyFunc.Bekle(1);
        WebElement loggin=driver.findElement(By.linkText("Login"));
        loggin.click();
        MyFunc.Bekle(1);
        WebElement email=driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("selen@gmail.com");
        WebElement sifre=driver.findElement(By.name("password"));
        sifre.clear();
        sifre.sendKeys("selen");
        WebElement loginButton=driver.findElement(By.cssSelector("[value='Login']"));
        loginButton.click();

        System.out.println("driver.getTitle() = " + driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("My Account"));

    }

    @AfterClass
    public void bitisIslemleri(){ //tearDown
       // System.out.println("bitisIslemleri çalıştı");
        MyFunc.Bekle(5);
        driver.quit();
    }
}
