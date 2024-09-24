package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Dependency {

    @Test
    public void StartCar()  {
        System.out.println("StartCar");
        Assert.fail();
    }

    @Test(dependsOnMethods = {"StartCar"})
    public void DriveCar()  {  System.out.println("DriveCar"); }

    @Test(dependsOnMethods = {"StartCar","DriveCar"}) // bağımlılık 1 den fazla verilebilir
    public void ParkCar()  {  System.out.println("ParkCar"); }

    @Test(dependsOnMethods = {"ParkCar"}, alwaysRun = true)  // hatalı olsada sen çalışmaya devam et
    public void StopCar()  {  System.out.println("StopCar"); }

}


//Dependency (bağımlılık):Bir testin diğer bir testin sonucuna veya
//belirli bir duruma bağlı olduğu durumları ifade eder.
//Örneğin, bir testin çalışabilmesi için önce başka bir testin başarılı
//bir şekilde tamamlanması gerekebilir. Bu tür senaryolarda TestNG'nin
// Dependency özelliği devreye girer.
