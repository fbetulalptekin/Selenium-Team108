package practise.myPractise;

import utilities.TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class S7_Actions_Iframe extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video'yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        //4- videoyu izlemek icin Play tusuna basin

        WebElement videoElement = driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(videoElement);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"))
                .click();

        //5- videoyu calistirdiginizi test edin
        WebElement pauseButton = driver.findElement(By.xpath("//button[@title='Duraklat (k)']"));
        actions.moveToElement(pauseButton).perform();

        Assert.assertTrue(pauseButton.isEnabled());
        Thread.sleep(3000);


    }
}
