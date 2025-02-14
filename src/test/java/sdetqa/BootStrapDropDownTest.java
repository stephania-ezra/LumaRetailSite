package sdetqa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class BootStrapDropDownTest {

    public final Logger log = LogManager.getLogger(BootStrapDropDownTest.class);
    BaseUtilTest but = new BaseUtilTest();
    WebDriver driver;

    @Test
    public void dropDownCheck() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.key.com/personal/financial-wellness/index.html");

        WebElement openAccountElement = driver.findElement(By.
                xpath("//*[@id=\"landing-page-697ae939a2\"]/div[1]/header/div[1]" +
                        "/section/div[2]/nav/ul[1]/li/a"));
        openAccountElement.click();

        WebElement divElement = driver.findElement(By
                .xpath("//*[@id=\"landing-page-697ae939a2\"]/div[1]/header/div[1]" +
                        "/section/div[2]/nav/ul[1]/li/div"));
        String isOpen = divElement.getAttribute("class");
        assertTrue(isOpen.contains("open"));

       WebElement ulWebElement = divElement.findElement(By.tagName("ul"));
       List<WebElement> liWebElements = ulWebElement.findElements(By.tagName("li"));
       log.info("Number of Account options:{}", liWebElements.size());


//        WebElement aWebElement = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/section/div[2]" +
//                "/nav/ul[1]/li/div/ul/li[1]/a"));
//        log.info("aWebElement :{}", aWebElement.getAttribute("innerHTML"));

        for(WebElement liElement : liWebElements) {

            WebElement aWebElement = liElement.findElement(By.tagName("a"));
            String text = aWebElement.getAttribute("innerHTML").trim();
            log.info("aWebElement :{}", text);

            if(text.equals("CD")) {
                log.info("I found CD");
                aWebElement.click();
                but.stopTheFlow(5);
                break;
            }
        }
        driver.quit();
    }
}
