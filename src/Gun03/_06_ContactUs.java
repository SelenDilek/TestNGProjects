package Gun03;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */

public class _06_ContactUs extends BaseDriver {

    @Test
    public void Test(){

        driver.navigate().to("https://opencart.abstracta.us/index.php?route=account/account");
        WebElement contactUs=driver.findElement(By.linkText("Contact Us"));
        contactUs.click();

       WebElement yourName = driver.findElement(By.xpath("//input[@name='name']"));
       yourName.clear();
       yourName.sendKeys("Ahmet");

        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.clear();
        email.sendKeys("selen@gmail.com");

        WebElement enquiry = driver.findElement(By.xpath("//input[@name='enquiry']"));
        enquiry.clear();
        enquiry.sendKeys("MESSAGE WAS SENT");

        driver.findElement(By.xpath("//textarea[@name='enquiry']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("success"));









    }
}
