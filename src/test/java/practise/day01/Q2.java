package practise.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {

    /* ...Exercise2...
 1 - Driver olusturalim
 2 - Java class'imiza chromedriver.exe'yi tanitalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklemesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */

    public static void main(String[] args) {

        // 1 - Driver olusturalim
        // 2 - Java class'imiza chromedriver.exe'yi tanitalim
        // 3 - Driver'in tum ekrani kaplamasini saglayalim
        // 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklemesini
        //     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.

        System.setProperty("Webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 5 - "https://www.otto.de" adresine gidelim
        driver.get("https://www.otto.de");

        // 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
        // 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
        String expectedOttoUrl = "OTTO";
        String actualOttoUrl = driver.getCurrentUrl();

        String expectedOttoTitle = "OTTO";
        String actualOttoTitle = driver.getTitle();

        if (actualOttoUrl.contains(expectedOttoUrl))
            System.out.println("Otto Url testi PASSED");
        else
            System.out.println("Otto Url testi FAILED");

        if (actualOttoTitle.contains(expectedOttoTitle))
            System.out.println("Otto Title testi PASSED");
        else
            System.out.println("Otto Title testi FAILED");

    // 8 - Ardindan "https://wisequarter.com/" adresine gidelim
        driver.get("https://wisequarter.com/");

    //  9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini kontrol edelim
        String expectedWiseTitle = "Quarter";
        String actualWiseTitle = driver.getTitle();

        if (actualWiseTitle.contains(expectedWiseTitle))
            System.out.println("Wise Title testi PASSED");
        else
            System.out.println("Wise Title testi FAILED");

    //  10- Bir onceki web sayfamiza geri donelim
        driver.navigate().back();

    //  11- Sayfayi yenileyelim
        driver.navigate().refresh();

    // 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();
        driver.close();
    // 13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();




        /* **** su sekilde de yapılabilir:

        String ottoTitle = driver.getTitle();
        System.out.println("ottoTitle = " + ottoTitle);

        String ottoUrl= driver.getCurrentUrl();
        System.out.println("ottoUrl = " + ottoUrl);

        if (ottoTitle.contains("OTTO") && ottoUrl.contains("OTTO")){
            System.out.println("OTTO yazisi vardir");
        }else System.out.println("OTTO yazisi icermiyor");

        driver.navigate().to("https://wisequarter.com/");
        String wqTitle = driver.getTitle();
        System.out.println("wqTitle = " + wqTitle);

        boolean isTrue = wqTitle.contains("Quarter");

        if (isTrue)
            System.out.println("TEST PASSED");
        else System.out.println("TEST FAILED");

        // if yerine ternary ile de yapılabilir:
        // System.out.println(isTrue ? "Test Passed" : "Test Failed");

        */








    }
}
