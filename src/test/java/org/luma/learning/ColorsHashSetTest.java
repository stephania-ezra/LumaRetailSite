package org.luma.learning;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Listeners({CustomListener.class})
public class ColorsHashSetTest extends BaseUtilTest {

    public final WebDriver driver = new ChromeDriver();
    private final Logger log = LogManager.getLogger(ColorsHashSetTest.class);
    private final BaseUtilTest but = new BaseUtilTest();
    Set<String> colors = new HashSet<String>();

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
    public void AddColorsSet() {

        log.info("Step 1 : Displaying Colors in the Set");
        colors.add("RED");
        colors.add("YELLOW");
        colors.add("GREEN");
        colors.add("BLUE");
        colors.add("ORANGE");
        colors.add("PINK");
        colors.add("PURPLE");

        for (String eachColor : colors) {
            log.info(eachColor);
        }
        log.info("<-------------------------------->");
    }

    @Test(priority = 1)
    public void SizeOfColorsSet() {
        log.info("Step 2 : Printing size of Colors Set");
        int size = colors.size();
        log.info("Size is:{}", size);
    }

    @Test(priority = 2)
    public void RemoveColorsSet() {
        log.info("Step 3: Remove color from the Set");
        boolean remove = colors.remove("YELLOW");
        log.info("Is Removed:{}", remove);

        //checking if yellow color is removed
        for (String eachColor : colors) {
            log.info(eachColor);
        }
        int newSize = colors.size();
        log.info(newSize);
        Assert.assertEquals(newSize, 6);
    }

    @Test(priority = 3)
    public void CheckingTheColor() {
        log.info("Step 4 : Contains Color in Set");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        boolean contain = colors.contains("RED");
        log.info("Has Color:{}", contain);
    }

    @Test(priority = 4)
    public void getFunctionSet() {
        log.info("Step 5 : Contains Color in Set");
        log.info("****************************");
        // create a List and get the values from the set
        //specify the set name ie colors in the constructor
        List<String> myColors = new ArrayList<>(colors);

        for (String eachColor : myColors) {
            log.info(eachColor);
        }
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        String FirstColor = myColors.getFirst();
        String SecondColor = myColors.get(1);
        String ThirdColor = myColors.get(2);
        String FourthColor = myColors.get(3);
        String FifthColor = myColors.get(4);
        String LastColor = myColors.getLast();

        log.info("{}\n{}\n{}\n{}\n{}\n{}", FirstColor, SecondColor, ThirdColor, FourthColor, FifthColor, LastColor);
    }
}