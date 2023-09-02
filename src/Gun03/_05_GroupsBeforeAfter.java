package Gun03;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class _05_GroupsBeforeAfter {

    @Test(groups = {"Smoke Test"})
    public void Test1(){
        System.out.println("Test1");
    }
    @Test(groups = {"Regression Test"})
    public void Test3(){
        System.out.println("Test3");
    }

    @Test(groups = {"Regression Test"})
    public void Test5(){
        System.out.println("Test5");
    }

    @Test(groups = {"Regression Test"})
    public void Test2(){
        System.out.println("Test2");
    }
    @Test(groups = {"Smoke Test"})
    public void Test4(){
        System.out.println("Test4");
    }
    @Test(groups = {"Smoke Test"})
    public void Test6(){
        System.out.println("Test6");
    }

    @Test
    public void Test7(){
        System.out.println("Test7");
    }

    @BeforeGroups(groups = {"Smoke Test"}) //smoke tag eklemezsen ve xml de sadece smoke test calissin yazarsan bunu calistirmaz

    public void bGroups(){
        System.out.println("Before Groups");
    }

    @AfterGroups(groups = {"Smoke Test"})

    public void aGroups(){
        System.out.println("After Groups");
    }


}
