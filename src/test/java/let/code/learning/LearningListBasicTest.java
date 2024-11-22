package let.code.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners({CustomListener.class})
public class LearningListBasicTest extends BaseUtilTest {
    public static WebDriver driver = new ChromeDriver();
    private final Logger log = LogManager.getLogger(LearningListBasicTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    List<String> vegetables = new ArrayList<String>();

    @BeforeClass
    public void setDriver(ITestContext context) {
        log.info("SETTING CONTEXT");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    public void tearDown() {
        but.tearDown(driver);
    }

    @Test(priority = 0)
    public void AddVegetablesList() {

        log.info("Step 1 : Add function in List");
        //add function
        vegetables.add("Tomato");
        vegetables.add("Carrot");
        vegetables.add("Beetroot");
        vegetables.add("Carrot");
        vegetables.add("Apple");

        for (String vegetable : vegetables) {
            log.info("Vegetables List :{}", vegetable);
        }
        log.info(">>>>>>>>>>>>>>>>>>>");
    }

    @Test(priority = 1)
    public void SizeOfVegetablesList() {

        int size = vegetables.size();
        log.info("Step 2 :Size of vegetables List :{}", size);
    }

    @Test(priority = 2)
    public void RemoveVegetableList() {

        log.info("Step 3 : Remove function in List");
        int size = vegetables.size();
        /*//Before Removing Beetroot from the list
        log.info("Before Removing Beetroot");
        for (String vegetable : vegetables) {
            log.info(vegetable);
        }
        log.info(size);
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        Assert.assertEquals(size, 5);*/

        //After removing Beetroot from the List
        log.info("Removing Beetroot from the list");

        boolean remove = vegetables.remove("Beetroot");
        log.info("Is Removed: {}", remove);

        for (String vegetable : vegetables) {
            log.info(vegetable);
        }
        int newSize = vegetables.size();
        log.info(newSize);
        Assert.assertEquals(newSize, 4);
    }

    @Test(priority = 3)
    public void CheckingTheVegetable() {

        log.info("Step 4 : Contains function in List");
        log.info("Contains or not");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>");
        boolean contains = vegetables.contains("Tomato");
        log.info("Has Vegetable: {}", contains);
    }

    @Test(priority = 4)
    public void GettingValues() {

        log.info("Step 5 : get function in List");
        String firstVal = vegetables.getFirst();
        String lastVal = vegetables.getLast();
        String secondVal = vegetables.get(1);

        log.info("Getting Values{}\n{}\n{}", firstVal, lastVal, secondVal);
    }

    @Test(priority = 5)
    public void CheckingEmptyList() {

        log.info("Step 6 : empty function in List");
        boolean empty = vegetables.isEmpty();
        log.info("Is Empty: {}", empty);
    }

    @Test(priority = 6)
    public void clearList() {
        log.info("Step 7: Clearing List");
        vegetables.clear();
        log.info(true);
    }
}
