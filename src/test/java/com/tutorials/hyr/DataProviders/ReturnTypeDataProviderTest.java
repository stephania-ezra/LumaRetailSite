package com.tutorials.hyr.DataProviders;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners({CustomListener.class})
public class ReturnTypeDataProviderTest extends BaseUtilTest {

    private final Logger log = LogManager.getLogger(ReturnTypeDataProviderTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    public WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("SETTING CONTEXT");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }

    //changing data provider name as per return type and changing the parameter
    //of the test method, passing the value as single dimensional array

    /*@Test(dataProvider = "TwoDimensionalArrayData")
    public void ReturnTypeTest(String[] s) {
        log.info("String Two dimensional array Return Type dataProvider");
        log.info(s[0] + "," + s[1]);
    }*/

    //u can also directly specify the parameters in Test Method
    /*@Test(dataProvider = "TwoDimensionalArrayData")
    public void ReturnTypeTest(String actress, String movies) {
        log.info("String Two dimensional array Return Type dataProvider");
        log.info(actress + "," + movies);
    }*/

    @Test(dataProvider = "JaggedArrayCheck")
    public void ReturnTypeTest(Object[] s) {
        log.info("Jagged array Return Type dataProvider");
        for (Object object : s) {
            log.info(object);
        }
        log.info(">>>>>>>>");
    }

    //when passing many values in the array
    /*@Test(dataProvider = "SingleDimensionalArrayCheck")
    public void ReturnTypeTest(String[] s) {
        log.info("String Two dimensional array Return Type dataProvider");
        log.info(s[0] + "," + s[1] + "," +
                s[2] + "," + s[3] + "," +
                s[4] + "," + s[5]);
    }*/

    @DataProvider
    //using String Array
    public String[] StringReturnTypeData() {
        log.info("Return Type data");
        //u can write like this or like the one below
        /*String[] actors = new String[5];
        actors[0] = "Vijay";
        actors[1] = "Rajini";
        actors[2] = "Ajith";
        actors[3] = "KamalHasan";
        actors[4] = "Surya";*/

        String[] actors = new String[]{
                "Vijay",
                "Ajith",
                "Rajini",
                "KamalHasan",
                "VijaySethupathi"
        };
        return actors;
    }


    @DataProvider
    //using Integer Array
    public Integer[] IntegerReturnTypeData() {
        Integer[] numbers = new Integer[]{
                12,
                21,
                42,
                65,
                89,
                98
        };
        return numbers;
    }

    @DataProvider
    //Using Integer and String Datatypes
    public Object[] ObjectDataTypeData() {
        Object[] data = new Object[]{
                1,
                "Hello",
                12,
                "Welcome",
                13,
                "India"
        };
        return data;
    }

    @DataProvider
    //Using TwoDimensional Array ie (for every row column count will be the same)
    public String[][] TwoDimensionalArrayData() {
        String[][] actress = new String[][]{
                {"Nayanthara", "50"},
                {"Namitha", "13"},
                {"Tamanah", "30"}
        };
        return actress;
    }

    //passing many values in the array
    //Using Jagged Array (each rows will have different number of columns)
   /* @dataProvider
    public String[][] JaggedArrayCheck() {
        String[][] movies = new String[][]{
                {"Nayanthara", "50", "AR Rahman", "Aniruth", "Swetha Mohan", "Spb", "Chitra"},
                {"Namitha", "13", "Janaki", "Vikram", "Vishal", "Malgudi Subha", "Karthik", "Mano",},
                {"Tamanah", "30", "Srinivas", "Anuratha Sriram", "Sainthavi"}
        };
        return movies;
    }*/


    //Array consists of integer and String
    @DataProvider
    public Object[][] JaggedArrayCheck() {
        Object[][] movies = new Object[][]{
                {"Nayanthara", 50, "AR Rahman", "Aniruth", "Swetha Mohan", "Spb", "Chitra"},
                {"Namitha", 13, "Janaki", "Vikram", "Vishal", "Malgudi Subha", "Karthik", "Mano",},
                {"Tamanah", 30, "Srinivas", "Anuratha Sriram", "Sainthavi"}
        };
        return movies;
    }
}
