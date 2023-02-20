package practise.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework3 {
    // .......Exercise5........
    /*
    Navigate to website https://testpages.herokuapp.com/styled/index.html
    Under the ORIGINAL CONTENTS
    click on Alerts
    print the URL
    navigate back
    print the URL
    Click on Basic Ajax
    print the URL
    enter value 20 and ENTER
    and then verify Submitted Values is displayed open page
    close driver
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test(){
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//h2[text()='Original Contents']"));

        driver.findElement(By.xpath("//a[text()='Alerts']")).click();
        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[text()='Basic Ajax']")).click();
        System.out.println(driver.getCurrentUrl());

        WebElement valueBox = driver.findElement(By.xpath("//input[@id='lteq30']"));
        valueBox.sendKeys("20" + Keys.ENTER);

        WebElement submittedValuesYazisi = driver.findElement(By.xpath("//p[text()='Submitted Values']"));

        boolean isTrue = submittedValuesYazisi.isDisplayed();
        System.out.println((isTrue ? "Test PASSED" : "Test FAILED"));




    }
}
