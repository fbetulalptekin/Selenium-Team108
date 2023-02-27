package practise.myPractise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class S14_HandleWindows extends TestBase {

    // ● Amazon anasayfa adresine gidin.
    // ● Sayfa’nin window handle degerini String bir degiskene atayin
    // ● Sayfa title’nin “Amazon” icerdigini test edin
    // ● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
    // ● Sayfa title’nin “wisequarter” icerdigini test edin
    // ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    // ● Sayfa title’nin “Walmart” icerdigini test edin
    // ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin

    @Test
    public void test01() {
        // ● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");
        // ● Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWHD = driver.getWindowHandle();
        // ● Sayfa title’nin “Amazon” icerdigini test edin
        String actualAmazonTitle = driver.getTitle();
        Assert.assertTrue(actualAmazonTitle.contains("Amazon"));
        // ● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.wisequarter.com");
        driver.navigate().refresh();
        // ● Sayfa title’nin “wisequarter” icerdigini test edin
        String wiseActualTitle = driver.getTitle();
        Assert.assertFalse(wiseActualTitle.contains("wisequarter"));
        // ● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");
        // ● Sayfa title’nin “Walmart” icerdigini test edin
        String walmartActualTitle = driver.getTitle();
        Assert.assertTrue(walmartActualTitle.contains("Walmart"));
        // ● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazonWHD);
        String amazonActualUrl = driver.getCurrentUrl();
        Assert.assertTrue(amazonActualUrl.contains("amazon"));


    }

}
