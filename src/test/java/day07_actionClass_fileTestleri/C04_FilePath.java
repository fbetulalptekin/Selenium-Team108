package day07_actionClass_fileTestleri;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FilePath {

    @Test
    public void test01() {

        // bilgisayarimizin temel dosya yolu --> user.home
        // icinde bulundugumuz projenin temel dosya yolu --> user.dir

        //    /Users/ahmetbulutluoz/IdeaProjects/seleniumTeam108
        //   /Users/ahmetbulutluoz/IdeaProjects/seleniumTeam108/src/test/java/day07_actionsClass_fileTestleri/text.txt
        // C:\Users\sevil\IdeaProjects\seleniumTeam108\src\test\java\day07_actionClass_fileTest\text.txt

        // "C:\Users\fbalp\OneDrive\Masaüstü\TheDelta.docx"

        String dosyaYolu = "C:\\Users\\fbalp\\OneDrive\\Masaüstü\\TheDelta.docx";

        boolean sonuc = Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);

         /*
            Bilgisayarimizda bir dosyanin var oldugunu test etmek icin
            dosya yoluna ihtiyacimiz var

            Ancak herkesin bilgisayarindaki dosya yollari
            farkliliklar gosterir

            herkesin bilgisayarina gore farkli olan kismi
            java'dan bir komut ile elde edebiliriz

         */

        System.out.println(System.getProperty("user.home")); //      C:\Users\fbalp

        dosyaYolu = "C:\\Users\\fbalp\\OneDrive\\Masaüstü";
        dosyaYolu = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\TheDelta.docx";


        System.out.println(System.getProperty("user.dir"));
        // C:\Users\fbalp\OneDrive\Masaüstü\GitHub-Team108\seleniumTeam108

    }


}
