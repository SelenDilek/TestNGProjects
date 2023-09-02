package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _05_Dependency {
    //Arabanin hareket sirasi : start , drive , park , stop

    //Not priorty ile siralayabilirdik ama Assert.Fail() olursa veya ilki calismadan digerlerinin calismasinin anlami yok.
    @Test
    public void startCar() {
        System.out.println("startCar");
        //Assert.fail();
    }

    @Test(dependsOnMethods = {"startCar"})// bu testin çalışması, startCar ın hatasız çalışmasına bağımlı
    public void driveCar() {
        System.out.println("driveCar");
    }

    @Test(dependsOnMethods = {"driveCar", "startCar"})
    public void parkCar() {
        System.out.println("parkCar");
    }

    //alwaysRun = true,  sırasını bekler, bağımlılıkları var ama hata çıkarsa da yine çalıştır.
    @Test(dependsOnMethods = {"parkCar"}, alwaysRun = true) //MUTLAKA CALIS (ne olursa olsun calis alwaysRun=true)
    public void stopCar() {
        System.out.println("stopCar");
    }

    // aynı seviyedeki testleri için priority verilebilir.


    // bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
// 1 üste kadar otomatik çağırıp çalışabilir.


//Dependency (bağımlılık):Bir testin diğer bir testin sonucuna veya
//belirli bir duruma bağlı olduğu durumları ifade eder.
//Örneğin, bir testin çalışabilmesi için önce başka bir testin başarılı
//bir şekilde tamamlanması gerekebilir. Bu tür senaryolarda TestNG'nin Dependency özelliği devreye girer.

}
