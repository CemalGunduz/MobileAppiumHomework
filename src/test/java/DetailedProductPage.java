import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DetailedProductPage extends BaseTest {

    @Step("Control: Is Detailed Product Page opened ?")
    public void controlIsDetailedProductPageOpened() {
        Assert.assertEquals("Detailed product page is not opened!", true, appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/tvItemDescription")).isDisplayed());
        Logger.info("Detailed product page is opened!");
    }

}
