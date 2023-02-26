package practise.myPractise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class S9_WebTable extends TestBase {

    //  1."https://www.amazon.com" adresine gidin
    //  2.Sayfanin en altina inin
    //  3.Web table tum body’sini yazdirin
    //  4.Web table’daki satir sayisinin 9 oldugunu test edin
    //  5.Tum satirlari yazdirin
    //  6. Web table’daki sutun sayisinin 13 olduğunu test edin
    //  7. 5.sutunu yazdirin
    //  8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
    //    döndüren bir method olusturun
    //  9. 7.satirin,9.datasinin "Shoes" icerdigini test edin

    @Test
    public void test01() {

        //  1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

        //  2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //  3.Web table tum body’sini yazdirin
        WebElement webTableBody = driver.findElement(By.xpath("//tbody"));
        System.out.println("tüm body: " + webTableBody.getText());

        //  4.Web table’daki satir sayisinin 10 oldugunu test edin
        List<WebElement> actualRowCount = driver.findElements(By.xpath("//tr"));
        Assert.assertEquals(10, actualRowCount.size());

        //  5.Tum satirlari yazdirin

        int count = 1;
        for (WebElement eachRow : actualRowCount
        ) {
            System.out.println("Tum satirlar: " + count + "-" + eachRow.getText());
            count++;
        }

        //  6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> dataCount = driver.findElements(By.xpath("//tr[3]/td")); // 1.satırla yapınca doğru soonuç vermedi
        Assert.assertEquals(13, dataCount.size());

        //  7. 5.sutunu yazdirin
        List<WebElement> fifthData = driver.findElements(By.xpath("//td[5]"));

        count = 1;
        for (WebElement eachData : fifthData
        ) {
            System.out.println( "5.sütun: " + count + "-" + eachData.getText());
            count++;
        }
        System.out.println("===================================================");

        //  8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren
        //    bir method olusturun

        System.out.println("istenen data: \n" + getCelleData(1,5));

        // 9 - 7.satirin,9.datasinin "Shoes" icerdigini test edin

        String actualContent = getCelleData(7,9);
        Assert.assertTrue(actualContent.contains("Shoes"));

    }

    public String getCelleData (int satirNo, int sutunNo) {

        // herhangi bir hücre datasının xpath'i:
        //     //tr[3]/td[5]

        String celleDataXpath = "//tr[" + satirNo + "]/td[" + sutunNo + "]";
        String getCelleData = driver.findElement(By.xpath(celleDataXpath)).getText();

        return getCelleData;
    }


}
