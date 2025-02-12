package sdetqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NavigationTest {
    @Test
    public void navigationCheck(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.snapdeal.com/");
        //driver.get("https://www.amazon.com/");

        driver.navigate().to("https://www.amazon.com/");

        driver.navigate().back();// go back to snapdeal page

        driver.navigate().forward(); // go forward to amazon page

        driver.navigate().refresh(); // refresh / reload the page

    }
}
