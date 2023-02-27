package practise.myPractise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class S10_WindowHandle extends TestBase {

    // ************** Test 01 ****************
    //    1. "http://webdriveruniversity.com/" adresine gidin
    //    2. "Login Portal" a kadar asagi inin
    //    3. "Login Portal" a tiklayin
    //    4.  Diger window'a gecin
    //    5. "username" ve "password" kutularina deger yazdirin
    //    6. "login" butonuna basin
    //    7. Popup'ta cikan yazinin "validation failed" oldugunu test edin
    //    8. Ok diyerek Popup'i kapatin
    //    9. Ilk sayfaya geri donun
    //    10.Ilk sayfaya donuldugunu test edin

    @Test
    public void test01() {
        //    1. "http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        String firstPageWHD = driver.getWindowHandle();
        //    2. "Login Portal"a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle(3);
        //    3. "Login Portal"a tiklayin
        WebElement loginPortalLink = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        actions.click(loginPortalLink).perform();
        bekle(3);
        //    4.  Diger window'a gecin
        String secondWHD = "";
        Set<String> windowHandles = driver.getWindowHandles();

        for (String eachWHD : windowHandles
        ) {
            if (!eachWHD.equals(firstPageWHD))
                secondWHD = eachWHD;
        }
        driver.switchTo().window(secondWHD);

        //    5. "username" ve "password" kutularina deger yazdirin
        WebElement userNameButton = driver.findElement(By.id("text"));
        actions.moveToElement(userNameButton).perform();
        actions.click(userNameButton).sendKeys("Nevra").perform();
        actions.sendKeys(Keys.TAB).sendKeys("parola").perform();

        //    6. "login" butonuna basin
        WebElement loginButton = driver.findElement(By.id("login-button"));
        actions.click(loginButton).perform();
        bekle(3);

        //    7. Popup'ta cikan yazinin "validation failed" oldugunu test edin
        //    8. Ok diyerek Popup'i kapatin
        String expectedPopupText = "validation failed";
        String actualPopupText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedPopupText, actualPopupText);
        bekle(3);
        driver.switchTo().alert().accept();

        //    9. Ilk sayfaya geri donun
        //    10.Ilk sayfaya donuldugunu test edin
        driver.switchTo().window(firstPageWHD);
        String actualWHD = driver.getWindowHandle();
        Assert.assertEquals(firstPageWHD,actualWHD);
    }
}
