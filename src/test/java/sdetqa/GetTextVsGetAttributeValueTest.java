package sdetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.practisingDaily.LoginDemoQATest.log;

public class GetTextVsGetAttributeValueTest {

    @Test
    public void getTextCheck() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin-demo.nopcommerce.com/login?returnUrl=%2Flogin");

        WebElement emailElement = driver.findElement(By.id("Email"));
        emailElement.clear();

        emailElement.sendKeys("adm123@gmail.com");

        log.info("Result from getAttribute() method:{}", emailElement.getAttribute("value"));
        log.info("Result from getText() method:{}", emailElement.getText());

        //Login Button
        WebElement loginButtonElement = driver.findElement(By
        .xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div/form/div[3]/button"));
        log.info("Result from getAttribute() method:{}", loginButtonElement.getAttribute("type"));
        log.info("Result from getAttribute() method:{}", loginButtonElement.getAttribute("class"));

        log.info("Result from getText() method:{}", loginButtonElement.getText());
        driver.quit();
    }
}
