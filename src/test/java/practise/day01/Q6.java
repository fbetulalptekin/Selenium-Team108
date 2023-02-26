package practise.day01;

import org.junit.*;

public class Q6 {

    @BeforeClass
    public static void setUp(){
        System.out.println("Before Class");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("After Class");
    }

    @Before
    public void before(){
        System.out.println("Before");
    }

    @After
    public void after(){
        System.out.println("After");
    }
    @Test
    public void ahmet(){

        System.out.println("Ahmet");
    }

    @Test
    public void bekir(){

        System.out.println("Bekir");
    }

    @Test
    public void cengiz(){

        System.out.println("Cengiz");
    }


}
