package practise.myPractise;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class S12_KeyboardActions extends TestBase {

    //  1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    //  2- Hover over Me First" kutusunun ustune gelin
    //  3- Link 1" e tiklayin
    //  4- Popup mesajini yazdirin
    //  5- Popup'i tamam diyerek kapatin
    //  6- “Click and hold" kutusuna basili tutun
    //  7-“Click and hold" kutusunda cikan yaziyi yazdirin
    //  8- “Double click me" butonunu cift tiklayin

    @Test
    public void test01() {
        //  1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //  2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverBox = driver
                             .findElement(By.xpath("//button[text()='Hover Over Me Second!']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverBox).perform();
        bekle(3);

        //  3- Link 1'e tiklayin
        WebElement link = driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",link);
        bekle(2);

        //  4- Popup mesajini yazdirin
        //  5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        bekle(3);

        //  6- “Click and hold" kutusuna basili tutun
        WebElement clickHold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickHold).perform();

        //  7- “Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickHold.getText());

        //  8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickButton = driver.findElement(By.tagName("h2"));
        actions.moveToElement(doubleClickButton).perform();
        actions.doubleClick(doubleClickButton).perform();



    }
}
