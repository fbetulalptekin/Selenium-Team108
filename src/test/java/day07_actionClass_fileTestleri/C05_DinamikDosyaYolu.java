package day07_actionClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DinamikDosyaYolu {

    @Test
    public void test01() {

        // Masaustumuzde theDelta.docx isimli bir dosya bulundugunu test edin

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\TheDelta.docx";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
