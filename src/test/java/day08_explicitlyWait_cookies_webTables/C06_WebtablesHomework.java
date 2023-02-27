package day08_explicitlyWait_cookies_webTables;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_WebtablesHomework extends TestBase {

    //1. "https://demoqa.com/webtables" sayfasina gidin
    //2. Headers'da bulunan basliklari yazdirin
    //3. 3.sutunun basligini yazdirin
    //4. Tablodaki tum datalari yazdirin
    //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
    //6. Tablodaki satir sayisini yazdirin
    //7. Tablodaki sutun sayisini yazdirin
    //8. Tablodaki 3.kolonu yazdirin
    //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
    //sayisini girdigimde bana datayi yazdirsin

    @Test
    public void test01() {
        //1. "https://demoqa.com/webtables" sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        // tum tablo verileri //div[@class='rt-td']
        // 1. satir index satirlar (//div[@class='rt-tr-group'])[1]
        // 1. satir (//div[@class='rt-tr-group'])[1]//div[@class='rt-td']

        // 3. satirin 1. datasi ((//div[@class='rt-tr-group'])[3]//div[@class='rt-td'])[1]
        // tum veri hucreleri (//div[@class='rt-tr-group'])|(//div[@class='rt-td'])

        // 2. Headers'da bulunan basliklari yazdirin,

        WebElement headers = driver.
                findElement(By.xpath("//div[@class='rt-thead -header']"));
        System.out.println("Headers'da bulunan başlıklar: " + headers.getText());

       /*
        int siraNo = 1;
        for (WebElement headerEach : headers
        ) {
            System.out.println("Headers'da bulunan başlıklar: " + siraNo + "--" + headerEach.getText());
            siraNo++;
        } */
        System.out.println("*************************");

        // 3. 3.sutunun basligini yazdirin
        //System.out.println("3.sutunun basligini yazdirin: " + headers.get(2).getText());  // alternatif

        WebElement ucuncuSutunBaslik = driver
                .findElement(By.xpath("(//div[@class='rt-th rt-resizable-header -cursor-pointer'])[3]"));
        System.out.println("3.sutunun basligi: " + ucuncuSutunBaslik.getText());
        System.out.println("*************************");

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDataList = driver.findElements(By.xpath("//div[@class='rt-td']"));

        int siraNo = 1;

        for (WebElement eachData : tumDataList
        ) {
            System.out.println(siraNo + "-" + eachData.getText());
            siraNo++;
        }
        System.out.println("*************************");

        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("Boş olmayan hücreler / 1.yöntem");
        siraNo = 1;

        for (WebElement eachCell : tumDataList
        ) {
            if (!eachCell.getText().equals(" ") && !eachCell.getText().equals("")) {
                System.out.println(siraNo++ + "-->" + eachCell.getText());
            }
        }

        System.out.println("Boş olmayan hücreler / 2.yöntem");
        siraNo = 1;

        for (WebElement eachElement : tumDataList
        ) {
            if (!eachElement.getText().isBlank()) {  //isEmpty() methodu boslukları dolu olarak kabul edıyor.o yuzden isBlank()
                System.out.println(siraNo++ + "-->" + eachElement.getText());
            }
        }

        // 6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisiList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki satir sayisi: " + satirSayisiList.size());

        // 7. Tablodaki sutun sayisini yazdirin
        List<WebElement> sutunSayisiList = driver
                        .findElements(By.xpath("(//div[@class='rt-tr-group'])[1]//div[@class='rt-td']"));
        System.out.println("Tablodaki sutun sayisi:" + sutunSayisiList.size());

        // alternatif xpath -->  //div[@class='rt-th rt-resizable-header -cursor-pointer']

        // 8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuKolonData = driver
                .findElements(By.xpath("//div[@class='rt-td'][3]"));

        siraNo = 1;
        for (WebElement eachElement : ucuncuKolonData) {
            System.out.println("Tablodaki 3.kolon dataları : " + siraNo++ + "-" + eachElement.getText());
        }

        // 9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        for (int i = 0; i < tumDataList.size(); i++) {
            if (tumDataList.get(i).getText().equals("Kierra")) {
                System.out.println("Istenen kisinin maasi : " + tumDataList.get(i + 4).getText());
            }
        }
        //10. Page sayfasinda bir method olusturun,
        // Test sayfasindan satir ve sutun sayisini girdigimizde bize datayi yazdirsin
        findCellOfTable(2, 2);    // ilk çözüm

        System.out.println("Mehmet Bey metod : " + dataYazdir(2, 2)); // 2.çözüm

    }

    public void findCellOfTable(int satir, int sutun) {  // duygu
        //div[@class='rt-tbody']/div[3]/div[1]/div[5]
        System.out.println("Metod : " + driver
                .findElement(By.xpath(" //div[@class='rt-tbody']/div[" + satir + "]/div[1]/div[" + sutun + "]"))
                .getText());
    }

    public String dataYazdir(int satirNo, int sutunNo) { // m erden

        String dinamikXpath = "(//div[@class='rt-tr-group'])[" + satirNo + "]//div[@class='rt-td'][" + sutunNo + "]";

        return driver.findElement(By.xpath(dinamikXpath)).getText();
    }

}

