package Gun02;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Ornek extends BaseDriver {




    @Test
    public void logginTest(){

        System.out.println("Testim calisti" );
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
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
}
