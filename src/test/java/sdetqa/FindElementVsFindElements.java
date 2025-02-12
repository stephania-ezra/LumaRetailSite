package sdetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static com.practisingDaily.LoginDemoQATest.log;

public class FindElementVsFindElements {

    @Test
    public void findingElement(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        // findElement()
        //1. Return type and Access
        /*WebElement searchBoxElement = driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
        searchBoxElement.sendKeys("Ethan");

        //2.Multiple WebElements
        WebElement element = driver.findElement(By.xpath("//div[@class='footer-upper']//a"));
        log.info(element.getText());

        //3. No Such Element Exception
        WebElement searchButtonElement = driver.findElement(By.xpath("//button[normalize-space()='login']"));*/

        //findElements()
        //1.Return type
        List<WebElement> links = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        log.info("Number of Footer Elements captured:{}", links.size());

        //2.locator is pointing to single webElement
       List<WebElement> logoElement = driver.findElements(By.
                xpath("//img[@alt='nopCommerce demo store']"));
        log.info(logoElement.size());

        //3.Access
       List<WebElement> linksElement = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
        log.info("Number of Footer Elements are:{}", linksElement.size());

        for(WebElement link: linksElement){
            log.info(link.getText());
        }

        //4.returns 0 when we try to find an element which is not present
        List<WebElement> imgElement = driver.findElements(By.
                xpath("//img[contains(title,'Electronics')]"));
        log.info(imgElement.size());

        driver.quit();
    }
}
