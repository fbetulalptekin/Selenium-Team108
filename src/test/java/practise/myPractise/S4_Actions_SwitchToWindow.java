package practise.myPractise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class S4_Actions_SwitchToWindow extends TestBase {
    @Test
    public void test01() {

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals(expectedText, actualText);
        bekle(2);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        // --> Bu linke tiklamadan sayfanin Window handle degerini almaliyiz
        // cünkü tiklayinca biz istemeden yeni link açılacak
        String herokuAppWHD = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

        Set<String> allWHD = driver.getWindowHandles();
        String elementalSeleniumWHD = "";

        for (String each : allWHD
        ) {
            if (!each.equals(herokuAppWHD))
                elementalSeleniumWHD = each;
        }

        driver.switchTo().window(elementalSeleniumWHD);
        bekle(2);


        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        expectedText = "Elemental Selenium";
        actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedText, actualText);
        bekle(2);


    }

}



