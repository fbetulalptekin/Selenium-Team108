package practise.myPractise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class S8_Iframe extends TestBase {

    // 1. "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
    //2. "Our Products" butonuna basin
    //3. "Cameras product"i tiklayin
    //4. Popup mesajini yazdirin
    //5. "close" butonuna basin
    //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
    //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin

    @Test
    public void test01(){
        // 1. "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. "Our Products" butonuna basin
        // bunun icin once "Our Products"in bulundugu iframe'e gecis yapmaliyiz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframe);

        WebElement ourProductsButton = driver.findElement(By.xpath("(//li/a)[2]"));
        ourProductsButton.click();

        //3. "Cameras product"i tiklayin
        driver.findElement(By.xpath("(//p[@class='sub-heading'])[2]")).click();

        // 4. Pop-up mesajini yazdirin
        // !!! burda hemen açılmadığı için explicitly wait kullanmalıyız !!!
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));

        String popUpMessage = popUp.getText();

        System.out.println("Pop-up mesaji : " + popUpMessage);
        bekle(3);

        //5. "close" butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);




    }
}
