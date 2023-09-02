package Gun01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _02_Annotations {

    @AfterClass //afterclass test degil calisma duzeni //nerde yazdiginin veya sirasinin onemi yok!
    public void bitisIslemleri(){


        System.out.println("Afterclasscalisti");
    }

    @BeforeClass //test degil calistirma duzeni
    public void baslangicIslemleri(){


        System.out.println("Beforeclass calisti");
    }

    @Test // Annotation : metdoun türünü ve çalışma özelliklerini belirtir
    public void test1(){  // Test1 : test metodunun adı
        System.out.println("test 1 çalıştı");
    }

    @Test // Annotation : metdoun türünü ve çalışma özelliklerini belirtir
    public void test2(){  // Test1 : test metodunun adı
        System.out.println("test 2 çalıştı");
    }


}
