package practise.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3_Homework1 {

    /* ...Exercise3...
    go to url : https://www.techlistic.com/p/selenium-practice-form.html
    fill the firstname
    fill the lastname
    check the gender
    check the experience
    fill the date
    choose your profession -> Automation Tester
    choose your tool -> Selenium Webdriver
    choose your continent -> Antartica
    choose your command  -> Browser Commands
    click submit button
 */

    static WebDriver driver;

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

    @Test
    public void test01() {
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.findElement(By.xpath("//a[text()='Tamam']")).click(); // cookie atlama

        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameBox.sendKeys("Defne");
        WebElement lastNameBox = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameBox.sendKeys("Güven");

        WebElement genderRadioButton = driver.findElement(By.xpath("//input[@value='Female']"));
        genderRadioButton.click();
        WebElement experienceRadioButton = driver.findElement(By.cssSelector("#exp-1"));
        experienceRadioButton.click();

        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
        datePicker.sendKeys("17/02/2023");

        WebElement professionCheckBox = driver.findElement(By.id("profession-1"));
        professionCheckBox.click();
        WebElement toolCheckBox = driver.findElement(By.id("tool-2"));
        toolCheckBox.click();

        WebElement continentSelectBox = driver.findElement(By.id("continents"));
        continentSelectBox.click();
        WebElement continentChoose = driver.findElement(By.xpath("(//option[@style='margin: 0px; padding-bottom: 0px; padding-left: 0px; padding-right: 0px;'])[7]"));
        continentChoose.click();

        WebElement seleniumCommandsBox = driver.findElement(By.id("selenium_commands"));
        seleniumCommandsBox.click();
        WebElement seleniumCommandsChoose = driver.findElement(By.xpath("//option[text()='Browser Commands']"));
        seleniumCommandsChoose.click();

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();


    }


}

