package let.code;

import com.automationexercise.AddProductCartPageTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

@Listeners({CustomListener.class})
public class WebTableTest {
    public final Logger log = LogManager.getLogger(AddProductCartPageTest.class);
    public WebDriver driver = new ChromeDriver();
    BaseUtilTest but = new BaseUtilTest();

    @BeforeClass
    public void setDriver(ITestContext context) {
        System.out.println("setting context");
        context.setAttribute("WebDriver", driver);
    }

    @AfterClass
    void tearDown() {
        but.logoutAutomationExercise(driver);
    }

    @Test(priority = 1)
    public void step1() {
        log.info("executing step 1");
        driver.manage().window().maximize();
    }

    @Test(priority = 2)
    public void step2() {
        log.info("executing step 2");
        driver.get("https://letcode.in/table");
    }

    @Test(priority = 3)
    public void step3() {
        log.info("executing step 3");
        assertEquals(driver.getTitle(), "LetCode with Koushik");
        log.info("Home Page is visible");
    }

    @Test(priority = 4)
    public void step4() {
        log.info("executing step 4");
        WebElement tableElement = driver.findElement(By.id("simpletable"));

        //printing the headers of the table
        List<WebElement> headers = tableElement.findElements(By.tagName("th"));
        log.info("Displaying Headers of the table");
        for (WebElement header : headers) {
            String text = header.getText();
            log.info(text);
        }

        //Printing the first row Elements
        List<WebElement> allrows = tableElement.findElements(By.cssSelector("tbody tr"));
        int size = allrows.size();
        log.info("Rows size:{}", size);
        if (size == 3) {
            log.info("pass");
        } else log.info("fail");
        /*for (WebElement row : allrows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            WebElement firstColumn = columns.getFirst();
            log.info(firstColumn.getText());

            WebElement secondColumn = columns.get(1);
            log.info(secondColumn.getText());

            WebElement thirdColumn = columns.getLast();
            log.info(thirdColumn.getText());
        }*/
        for (int i = 0; i < size; i++) {
            List<WebElement> rows = allrows.get(i).findElements(By.tagName("td"));
            WebElement lastname = rows.get(1);
            String text = lastname.getText();
            log.info(text);
            if (text.equals("Raj")) {
                WebElement input = rows.get(3).findElement(By.tagName("input"));
                input.click();
                break;
            }
        }
    }
}
