package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_DriverMethodlari {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // gittiğimiz sayfadaki title ve Url'i yazdıralım
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Baslik: " + driver.getTitle());

        // amazon anasayfaya gittigimizi test edelim

        // < Test, expected ile actual result'ın karşılaştırılmasıdır >
        // örneğin 'url, amazon içeriyorsa' diyebiliriz

        String expectedIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.contains(expectedIcerik)){ // amazon anasayfaya gittiysek
            System.out.println("Test PASSED");
        }else {//gidemediysek
            System.out.println("Test FAILED");
        }





    }
}
