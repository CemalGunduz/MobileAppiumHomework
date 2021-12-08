import com.thoughtworks.gauge.Logger;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage extends BaseTest {

    @Step("Click element with that id <selectorId>")
    public void clickById(String selectorId) {
        appiumDriver.findElement(By.id(selectorId)).click();
        System.out.println("Clicked that id element: " + selectorId);
    }

    @Step("Click element with that text <textName>")
    public void clickByClassName(String textName) {
        appiumDriver.findElement(By.xpath("//*[@text='" + textName + "']")).click();
        System.out.println("Click that text: " + textName);
    }


    @Step("Wait <time> seconds")
    public void waitForSeconds(int time) throws InterruptedException {
        TimeUnit.SECONDS.sleep(time);
        System.out.println("Waited " + time + " seconds.");
    }

    @Step("Swipe <number> times the page up")
    public void swipeUp(int number) {
        int startX = 538;
        int startY = 1947;
        int endX = 538;
        int endY = 30;
        for (int i = 0; i < number; i++) {
            (new TouchAction(appiumDriver))
                    .press(point(startX, startY))
                    .moveTo(point(endX, endY))
                    .release()
                    .perform();
        }
        System.out.println("Page swiped up " + number + " times.");
    }


    @Step("Type that <text> to element with that id <selectorId>")
    public void typeTextThatElementWithId(String text, String selectorId) {
        appiumDriver.findElement(By.id(selectorId)).sendKeys(text);
        System.out.println(text + " typed to that id element: " + selectorId);
    }

    @Step("Choose size from product page's id of <sizeListElement>")
    public void chooseSizeFromList(String sizeListElement) {
        int listSize;
        List<MobileElement> mobileElementList = appiumDriver.findElements(By.id(sizeListElement));
        listSize = mobileElementList.size();
        System.out.println("SizeList element count: " + listSize);
        Random random = new Random();
        int randomInt = random.nextInt(listSize);
        mobileElementList.get(randomInt).click();

    }

    @Step("Choose random product from RecyclerView with <resourceId>")
    public void chooseRandomWithResourceId(String resourceId) {
        int resourceListSize;
        List<MobileElement> mobileElementList = appiumDriver.findElements(By.id(resourceId));
        resourceListSize = mobileElementList.size();
        System.out.println("Catalog pictures size: " + resourceListSize);
        Random random = new Random();
        int randomInt = random.nextInt(resourceListSize);
        mobileElementList.get(randomInt).click();
    }

    @Step("Control: Is Application up ?")
    public void controlIsApplicationUp() {
        Assert.assertEquals("Application is not running", true, appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/iv_storeTopLogo")).isDisplayed());
        Logger.info("Application is running!");
    }
}
