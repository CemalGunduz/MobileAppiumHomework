import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class StorePage extends BaseTest{

    @Step("Control: Is Store opened ?")
    public void controlStoreIsOpened() {
        Assert.assertEquals("Store is not opened!", true, appiumDriver.findElement(By.xpath("//*[@text='Yeni Gelenler']")).isDisplayed());
        Logger.info("Store is opened!");
    }

}
