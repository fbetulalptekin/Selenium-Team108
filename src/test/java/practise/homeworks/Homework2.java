package practise.homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework2 {

    /* ...Exercise4...
        Navigate to  https://testpages.herokuapp.com/styled/index.html
        Click on  Calculater under Micro Apps
        Type any number in the first input
        Type any number in the second input
        Click on Calculate
        Get the result
        Print the result

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
    public void teardown(){
        System.out.println();
        driver.close();
    }

    @Test
    public void test01(){
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//h2[text()='Micro Apps']"));
        driver.findElement(By.id("calculatetest")).click();

        WebElement inputBox1 = driver.findElement(By.id("number1"));
        inputBox1.sendKeys("34");
        WebElement inputBox2 = driver.findElement(By.id("number2"));
        inputBox2.sendKeys("28");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
        WebElement result = driver.findElement(By.id("answer"));
        result.getText();
        System.out.println(result.getText());


    }
}
