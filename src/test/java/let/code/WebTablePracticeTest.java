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
public class WebTablePracticeTest {
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
        //but.logoutAutomationExercise(driver);
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
        driver.get("https://letcode.in/table");
        WebElement tableElement = driver.findElement(By.id("simpletable"));

        //printing the headers of the table
        List<WebElement> headers = tableElement.findElements(By.tagName("th"));
        log.info("Displaying Headers of the table");
        for (WebElement header : headers) {
            String text = header.getText();
            log.info(text);
        }

        WebElement bodyElement = tableElement.findElement(By
                .xpath("//*[@id=\"simpletable\"]/tbody"));

        List<WebElement> allRows = bodyElement.findElements(By.tagName("tr"));
        int rowSize = allRows.size();
        log.info("Row Count:{}", rowSize);

        for (WebElement row : allRows) {
            List<WebElement> column = row.findElements(By.tagName("td"));
            WebElement firstName = column.get(0);
            String text = firstName.getText();
        }

        for (int i = 0; i < rowSize; i++) {
            List<WebElement> rows = allRows.get(i).findElements(By.tagName("td"));
            WebElement lastname = rows.get(1);
            String text = lastname.getText();
            log.info(text);
            if (text.equals("Raj")) {
                WebElement input = rows.get(3).findElement(By.tagName("input"));
                input.click();
            }
        }
        but.stopTheFlow(3);
    }

    @Test(priority = 5)
    public void step5() {
        log.info("executing step 5");
        driver.get("https://letcode.in/table");
        WebElement tableElement = driver.findElement(By.id("simpletable"));
        WebElement bodyElement = tableElement.findElement(By
                .xpath("//*[@id=\"simpletable\"]/tbody"));

        //printing the first row in the table
        List<WebElement> trElements = bodyElement.findElements(By.tagName("tr"));
        int rowSize = trElements.size();
        log.info("Row Count:{}", rowSize);

        log.info("Displaying rows in the table");
        for (int i = 0; i < rowSize; i++) {
            WebElement trElement = trElements.get(i);
            log.info("rowDetails {}", trElement.getText());
        }

        int row = 1;
        for (WebElement trElement : trElements) {
            List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
            for (WebElement tdElement : tdElements) {
                log.info("row {}, column {}", row, tdElement.getText());
            }
            row++;
        }
    }

    @Test(priority = 6)
    public void step6() {
        log.info("executing step 6");
        driver.get("https://letcode.in/table");
        WebElement tableElement = driver.findElement(By.id("simpletable"));
        WebElement bodyElement = tableElement.findElement(By
                .xpath("//*[@id=\"simpletable\"]/tbody"));

        //Displaying first column elements
        List<WebElement> trElements = bodyElement.findElements(By.tagName("tr"));
        int rowSize = trElements.size();
        log.info("Row Count:{}", rowSize);

        log.info("Displaying first columns in the table");
        int row = 1;
        for (WebElement trElement : trElements) {
            List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
            log.info(tdElements.getFirst().getText());
        }
    }

    @Test(priority = 7)
    public void step7() {
        log.info("executing step 7");
        driver.get("https://letcode.in/table");
        WebElement tableElement = driver.findElement(By.id("simpletable"));
        WebElement bodyElement = tableElement.findElement(By
                .xpath("//*[@id=\"simpletable\"]/tbody"));

        //Displaying first column elements
        List<WebElement> trElements = bodyElement.findElements(By.tagName("tr"));
        int rowSize = trElements.size();
        log.info("Row Count:{}", rowSize);

        log.info("Displaying second column in the table");
        int row = 1;
        for (WebElement trElement : trElements) {
            List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
            log.info(tdElements.get(row).getText());
        }
        row = row + 1;
    }


    @Test(priority = 8)
    public void step8() {
        log.info("executing step 8");
        driver.get("https://letcode.in/table");
        WebElement tableElement = driver.findElement(By.id("simpletable"));
        WebElement bodyElement = tableElement.findElement(By
                .xpath("//*[@id=\"simpletable\"]/tbody"));

        //Displaying first column elements
        List<WebElement> trElements = bodyElement.findElements(By.tagName("tr"));
        int rowSize = trElements.size();
        log.info("Row Count:{}", rowSize);

        log.info("Displaying all columns in the table");
        for (int row = 2; row <= rowSize; row++) {
            for (WebElement trElement : trElements) {
                List<WebElement> tdElements = trElement.findElements(By.tagName("td"));
                log.info(tdElements.get(row).getText());
            }
            row = row + 1;
        }
    }
}
