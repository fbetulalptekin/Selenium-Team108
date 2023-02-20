package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_DriverNavigateMethodlari {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // amazon anasayfaya gidelim
        driver.get("https://amazon.com");


        // sonra wisequarter anasayfaya gidelim
        driver.get("https://wisequarter.com");


        // yeniden amazon anasayfaya gidelim
        driver.navigate().back();

        // wisequarter anasayfaya dönelim
        driver.navigate().forward();

        //navigate().to(),  driver.get() ile aynı işlemi yapar
        driver.navigate().to("https://www.youtube.com");

        driver.navigate().refresh();
    }
}
