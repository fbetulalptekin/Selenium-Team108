package practise.myPractise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class S13_MouseActions extends TestBase {

    //  1- https://www.amazon.com/ adresine gidin
    //  2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
    //     mouse’u bu menunun ustune getirin
    //  3- “Create a list” butonuna basin
    //  4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

    @Test
    public void test01() {
        //  1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //  2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //     mouse’u bu menunun ustune getirin
        WebElement accountMenu = driver.findElement(By.xpath("//span[@class='nav-line-2 '] "));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountMenu).perform();
        //  3- “Create a list” butonuna basin
        WebElement createButton = driver.findElement(By.xpath("//span[text()='Create a List']"));
        actions.moveToElement(createButton).perform();
        actions.click().perform();
        //  4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListText = driver.findElement(By.xpath("//div[@role='heading']"));
        Assert.assertTrue(yourListText.isDisplayed());



    }
}
