package Utility;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static final org.apache.logging.log4j.Logger logger4j= LogManager.getLogger(); //yukarida bi tane daha log oldugu icin karismasin
    //diye kendisi uzunca ekletiyor.

    public static WebDriver driver; // SingletonDriver method
    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemleri(){
        //System.out.println("baslangicIslemleri çalıştı");

        Logger logger= Logger.getLogger(""); // output yapılan logları al.
        logger.setLevel(Level.SEVERE); // sadece ERROR ları göster

        driver = new ChromeDriver(); // jenkins deyken : sen head olmadan yani hafızada çalış
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

    @BeforeMethod
    public void beforeMethod(){
        //System.out.println("Test methodu basladi"); //eger logger i bilmiyor olsaydim boyle yazardim.
        logger4j.info("Test methodu basladi"); //ama nereye yazacak dosyaya mi yoksa ekrana mi? Ayar dosyasindan yapacaz.
        //XML dosyasi var onun icine yazilir.
        logger4j.warn("warning mesaj test basladi.");


    }

    //ITestRult -> TestNg

    @AfterMethod
    public void afterMethod(ITestResult sonuc){ //testin sonuc ve isim bilgisinin oldugu degiskeni vereyim mi.(testin genel bilgisini)
        // testin genel bilgisi icin buraya yazilir cunku test biter bilgi gelir.
        //System.out.println("Test methodu bitti"); //eger logger i bilmiyor olsaydim boyle yazardim.
        logger4j.info(sonuc.getName() + "Test methodu bitti" + sonuc.getStatus());
        logger4j.warn(sonuc.getName() +"warning mesaj test bitti."+ (sonuc.getStatus()==1 ? "passed" : "fail"));

        //excel ve dosyaya yazabilecegiz.
    }
}
