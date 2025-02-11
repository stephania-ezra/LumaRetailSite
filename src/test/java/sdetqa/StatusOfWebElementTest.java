package sdetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.practisingDaily.LoginDemoQATest.log;

public class StatusOfWebElementTest {

    @Test
    public void checkWebElementStatus(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");

        WebElement searchElement = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
        log.info("Search Element Displayed: {}", searchElement.isDisplayed());

        log.info("Search Element Enabled: {}", searchElement.isEnabled());

        WebElement maleElement = driver.findElement(By
        .xpath("//*[@id=\"gender-male\"]"));
        log.info("Male is Selected :{}", maleElement.isSelected());

        WebElement femaleElement = driver.findElement(By.xpath("//*[@id=\"gender-female\"]"));
        log.info("Female is selected:{}", femaleElement.isSelected());

        maleElement.click();
        log.info("Male is Selected :{}", maleElement.isSelected());

        femaleElement.click();
        log.info("Female is selected:{}", femaleElement.isSelected());
        
        driver.quit();
    }
}
