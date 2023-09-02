package Gun03;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
  Senaryo
  1- Siteyi açınız.
  2- Edit Account sayfasına ulaşınız.
  3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
 */

public class _01_Ornek extends BaseDriver {

    @Test
    public void editAccount(){

        driver.findElement(By.linkText("Edit Account")).click();
        WebElement firstname=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstname.clear();
        firstname.sendKeys("kml");

        WebElement lastname=driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastname.clear();
        lastname.sendKeys("lmk");

        WebElement email01=driver.findElement(By.xpath("//input[@id='input-email']"));
        email01.clear();
        email01.sendKeys("selen@gmail.com");

        WebElement phone=driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.clear();
        phone.sendKeys("045678399");

        //
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();


        MyFunc.successMessageValidation();







    }
}
