package practise.myPractise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S1 {

    /*   1. Tarayıcıyı başlatın
         2. 'http://automationexercise.com' URL'sine gidin
         3. Ana sayfanın başarıyla göründüğünü doğrulayın

         4. 'Kaydol / Giriş Yap' düğmesine tıklayın
         5. 'Yeni Kullanıcı Kaydı!' görünür oldugunu doğrulayın!

         6. Adı ve e-posta adresini girin
         7. 'Kaydol' düğmesini tıklayın
         8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
         9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi

         10. 'Bültenimize kaydolun!' onay kutusunu seçin.
         11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
         12. Ayrıntıları doldurun:
             Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
         13. 'Hesap Oluştur düğmesini' tıklayın
         14. 'HESAP OLUŞTURULDU!' yazısının görünür oldugunu doğrulayın!

         15. 'Devam Et' düğmesini tıklayın
         16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın

         17. 'Hesabı Sil' düğmesini tıklayın
         18. 'HESAP SİLİNDİ!' yazısının görünür olduğunu ve 'Devam Et' düğmesini tıklayın

*/
    static WebDriver driver;

    // 1. Tarayıcıyı başlatın
    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    // 2. 'http://automationexercise.com' URL'sine gidin
    // 3. Ana sayfanın başarıyla göründüğünü doğrulayın
    @Test
    public void test01() {
        driver.get("http://automationexercise.com");
        WebElement homePage = driver.findElement(By.xpath("//li/a[@href='/']"));
        Assert.assertTrue(homePage.isDisplayed());
    }

    //  4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //  5. 'Yeni Kullanıcı Kaydı!' görünür oldugunu doğrulayın!
    @Test
    public void test02() {
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        WebElement newUserSignUpText = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(newUserSignUpText.isDisplayed());
    }

    // 6. Adı ve e-posta adresini girin
    // 7. 'Kaydol' düğmesini tıklayın
    // 8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
    @Test
    public void test03() {
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='name']"));
        nameBox.click();
        nameBox.sendKeys("Betül Alptekin");
        WebElement emailBox = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailBox.click();
        emailBox.sendKeys("alpt@gmail.com");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();

        WebElement enterAccountInformationText = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountInformationText.isDisplayed());

        // 9. Ayrıntıları doldurun: Unvan, Parola, Doğum tarihi
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("htydfn");
        driver.findElement(By.xpath("//option[text()='17']")).click();
        driver.findElement(By.xpath("//option[text()='March']")).click();
        driver.findElement(By.xpath("//option[text()='1996']")).click();
    }

    @Test
    public void test04() {
        // 10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        // 11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        // 12. Ayrıntıları doldurun:
        //     Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Betül");

        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Alptekin");

        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("G&A");

        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Odunpazarı");

        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Tepebasi");

        driver.findElement(By.xpath("//option[text()='New Zealand']")).click();

        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Ic Bati Anadolu");

        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Eskisehir");

        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("26100");

        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("5557890067");

        //  13. 'Hesap Oluştur düğmesini' tıklayın
        //  14. 'HESAP OLUŞTURULDU!' yazısının görünür oldugunu doğrulayın!
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
        WebElement accountCreatedText = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(accountCreatedText.isDisplayed());
    }

    // 15. 'Devam Et' düğmesini tıklayın
    // 16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
    @Test
    public void test05() {
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[text()='Continue']")).click();
        //driver.findElement(By.xpath("//span[text()='Close']")).click();

        WebElement loggedInAsUserNameText = driver.findElement(By.xpath("//b[text()='Betül Alptekin']"));
        Assert.assertTrue(loggedInAsUserNameText.isDisplayed());
    }

    // 17. 'Hesabı Sil' düğmesini tıklayın
    // 18. 'HESAP SİLİNDİ!' yazısının görünür olduğunu test edin
    // 'Devam Et' düğmesini tıklayın
    @Test
    public void test06() {
        driver.findElement(By.xpath("(//*[*=' Delete Account'])[2]")).click();
        //   (//li)[5]/a   ---->     bu neden olmadı
        WebElement deletedText = driver.findElement(By.xpath("//p[text()='Your account has been permanently deleted!']"));
        Assert.assertTrue(deletedText.isDisplayed());

        driver.findElement(By.partialLinkText("Continue")).click();
    }


}
