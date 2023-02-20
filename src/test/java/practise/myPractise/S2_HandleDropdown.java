package practise.myPractise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseClass;

public class S2_HandleDropdown extends TestBaseClass {


      /*
      1. http://zero.webappsecurity.com/ Adresine gidin
      2. Sign in butonuna basin
      3. Login kutusuna “username” yazin
      4. Password kutusuna “password.” yazin
      5. Sign in tusuna basin
      6. Pay Bills sayfasina gidin
      7. “Purchase Foreign Currency” tusuna basin
      8. “Currency” drop down menusunden Eurozone’u secin
      9. “amount” kutusuna bir sayi girin
      10. “US Dollars” in secilmedigini test edin
      11. “Selected currency” butonunu secin
      12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
      13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
           kontrol edin.
       */

    @Test
    public void test01() {
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        // 3. Login kutusuna “username” yazin
        // 4. Password kutusuna “password” yazin
        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        bekle(2);
        //  6. Online Banking --> Pay Bills sayfasina gidin
        //  7. “Purchase Foreign Currency” tusuna basin
        driver.navigate().back();
        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
        bekle(3);
        //  8. “Currency” drop down menusunden Eurozone’u secin
        //  9. “amount” kutusuna bir sayi girin
        WebElement ddm = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddm);

        select.selectByVisibleText("Eurozone (euro)");
        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("600");
        bekle(2);
        // 10. “US Dollars” in secilmedigini test edin
        // 11. “Selected currency” butonunu secin
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='pc_inDollars_true']")).isSelected());
        driver.findElement(By.xpath("//input[@id='pc_inDollars_false']")).click();
        bekle(2);
    }

    @Test
    public void test02() {
        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
        driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();
        bekle(2);
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String expectedText = "Foreign currency cash was successfully purchased.";
        String actualText = driver.findElement(By.id("alert_content")).getText();
        Assert.assertEquals(expectedText, actualText);
        bekle(2);

    }


}
