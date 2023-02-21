package practise.myPractise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class S3_JsAlerts extends TestBase {

    // Gerekli ayarlamalari yapip
    // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin

    // 3 test method'u olusturup her method'da bir JsAlert'e basin
    // Ilgili method'lari kullanin

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        // 1.alert'e tiklayalim
        // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim
        // OK tusuna basip alert'i kapatalim

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(1);

        String expectedText = "I am a JS Alert";
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText, actualText);
        bekle(2);
        driver.switchTo().alert().accept();
    }

    @Test
    public void test02() {
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        // 2.alert'e tiklayalim
        // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        bekle(1);

        driver.switchTo().alert().dismiss();
        bekle(2);

        String expectedResultText = "You clicked: Cancel";
        String actualResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedResultText, actualResultText);

    }

    @Test
    public void test03() {
        // https://the-internet.herokuapp.com/javascript_alerts  adresine gidin
        // 3.alert'e tiklayalim
        // Cikan prompt ekranina "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        // Cikan sonuc yazisinin Abdullah icerdigini test edelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        bekle(2);
        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();
        bekle(2);
        String expectedResultText = "Abdullah";
        String actualResultText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertTrue(actualResultText.contains(expectedResultText));

    }


}
