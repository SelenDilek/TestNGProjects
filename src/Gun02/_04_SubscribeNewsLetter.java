package Gun02;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe işlemini abone lunuz(YES)  , işlemin başarılı olduğunu kontrol ediniz.
  3- Ayrı bir test ile Newsletter  Subscribe işlemini abonelikten çıkınız(NO)
4- Ayrı bir test ile Newsletter  Subscribe durumunu kontrol ediniz YES ise NO, NO ise YES yapınız.

 */
public class _04_SubscribeNewsLetter extends BaseDriver {

    By link=By.linkText("Newsletter");
    By subYes=By.xpath("//input[@value='1']");
    By subNo=By.xpath("//input[@value='0']");
    By cntBtn=By.xpath("//input[@value='Continue']");


    @Test(priority = 1)
    public void subscribeFunctionYes(){


        WebElement newsLetterLink=driver.findElement(link);
        newsLetterLink.click();

        WebElement subscribeYes=driver.findElement(subYes);
        subscribeYes.click();

        WebElement continueButton=driver.findElement(cntBtn);
        continueButton.click();

//        WebElement msgLabel=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));
        MyFunc.successMessageValidation();


        //Benim cozumum

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement newsLetter=driver.findElement(By.linkText("Newsletter"));
//
//        //("arguments[0].scrollIntoView(true);", element)
//        //("arguments[0].click();", element)
//        js.executeScript("arguments[0].scrollIntoView(true);", newsLetter);
//        js.executeScript("arguments[0].click();", newsLetter);
//
//        WebElement yesButton=driver.findElement(By.cssSelector("[value='1']"));
//        yesButton.click();
//
//        WebElement contunieButton=driver.findElement(By.cssSelector("[value='Continue']"));
//        contunieButton.click();
//
//        String expected="Success: Your newsletter subscription has been successfully updated!";
//
//        WebElement actual=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//        System.out.println("actual.getText() = " + actual.getText());
//
//        Assert.assertEquals(expected,actual.getText());
//

    }


    @Test(priority = 2)
    public void subscribeFunctionNo() {


        WebElement newsLetterLink = driver.findElement(link);
        newsLetterLink.click();

        WebElement subscribeNo = driver.findElement(subNo);
        WebElement subscribeYes=driver.findElement(subYes);

        //eğer yes seçili ise noyu tıkla else yes i tıkla
        if(subscribeYes.isSelected()){

            subscribeNo.click();
            MyFunc.Bekle(1);
        }
        else
            subscribeYes.click();
        MyFunc.Bekle(1);

        WebElement continueButton = driver.findElement(cntBtn);
        continueButton.click();
//
//        WebElement msgLabel = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//        Assert.assertTrue(msgLabel.getText().toLowerCase().contains("success"));

        MyFunc.successMessageValidation();

    }

    @Test(priority = 3)
    public void subscribeFunctionForBoth() {


        WebElement newsLetterLink = driver.findElement(link);
        newsLetterLink.click();



        WebElement subscribeNo = driver.findElement(subNo);
        subscribeNo.click();

        WebElement continueButton = driver.findElement(cntBtn);
        continueButton.click();

        MyFunc.successMessageValidation();


    }









    }
