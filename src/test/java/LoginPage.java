import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest{

    @Step("Control: Is Login Page opened ?")
    public void controlIsApplicationUp() {
        Assert.assertEquals("Login page is not opened!", true, appiumDriver.findElement(By.xpath("//*[@text='Giriş Yap']")).isDisplayed());
        Logger.info("Login page is opened!");
    }

}
