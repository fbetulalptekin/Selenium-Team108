package day02_webelements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElements {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // arama kutusunu locate edip bir web elementi olarak kaydedelim
        // id'si twotabsearchtextbox olan webelement şeklinde locate edeceğiz


        /*
           Driver a webelementi tarif etme islemine 'locate',
           bu tarifi yapabilmek icin kullanabilecegimiz degiskenlere de LOCATOR denir

           8 tane locator vardir
           Locator'larin 6 tanesi webelement'in özelliklerine baglidir
             -  id
             -  classname
             -  name
             -  tagname
             -  tagname
             -  linkText
             -  partialLinkTest
          Geriye kalan 2 locator ise her turlu webelementi locate etmek için kullanilabilir
             -  xpath
             -  cssSelector

         */
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
                                  // esitligin sağındaki bu işleme 'locate' denir

        // arama kutusuna "nutella" yazıp aratalım

        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        Thread.sleep(3000);
        driver.close();
    }
}
