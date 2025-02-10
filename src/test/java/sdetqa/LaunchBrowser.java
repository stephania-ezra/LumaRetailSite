package sdetqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class LaunchBrowser {

@Test

public void launchUrl() {

    //Launch Chrome Browser
    //WebDriver driver = new ChromeDriver();

    //Launch Firefox Browser
    //WebDriver driver = new FirefoxDriver();

    //Launch Edge Browser
    WebDriver driver = new SafariDriver();
    driver.get("https://www.nopcommerce.com/en/demo?srsltid=AfmBOoo_90mk-Wqi-NLBKqRWx_AkGAeb16kGx3HcSMQHj_lL4ujluTe5");
}
}
