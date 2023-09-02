package Gun01;
  /*
        @BeforeClass      -->   Class ın başında çalışacak   (driver işlemleri)

           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak

           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak

        @AfterClass       -->   Class ın çalışmasının sonunda çalışacak (driver kapat)

beforeClass

beforeMethod
test1
afterMethod

beforeMethod
test2
afterMethod

afterClass
     */

import org.testng.annotations.*;

public class _03_Annotations {



    @Test
    public void test1() { System.out.println("test 1 çalıştı"); }

    @Test
    public void test2() { System.out.println("test 2 çalıştı"); }

    @BeforeClass
    public void beforeClass() { System.out.println("beforeClass çalıştı"); }

    @AfterClass
    public void afterClass() { System.out.println("afterClass çalıştı"); }

    @BeforeMethod
    public void beforeMethod() { System.out.println("beforeMethod çalıştı"); }

    @AfterMethod
    public void afterMethod() { System.out.println("afterMethod çalıştı"); }















}
