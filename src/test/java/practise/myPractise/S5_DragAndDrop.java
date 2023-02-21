package practise.myPractise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class S5_DragAndDrop extends TestBase {
    //1- https://demoqa.com/droppable adresine gidelim
    //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test01(){
        driver.get("https://demoqa.com/droppable");

        WebElement dragMeElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHereElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMeElement,dropHereElement).perform();

        String actualText = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        String expectedText = "Dropped!";

        Assert.assertEquals(expectedText,actualText);


    }
}
