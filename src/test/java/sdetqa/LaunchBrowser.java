package sdetqa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import static com.practisingDaily.LoginDemoQATest.log;

public class LaunchBrowser {

@Test

    public void launchUrl() {

    //Launch Chrome Browser
    //WebDriver driver = new ChromeDriver();

    //Launch Firefox Browser
    //WebDriver driver = new FirefoxDriver();

    //Launch Edge Browser
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("https://www.nopcommerce.com/en/demo?srsltid=AfmBOoo_90mk-Wqi-NLBKqRWx_AkGAeb16kGx3HcSMQHj_lL4ujluTe5");
    log.info("Title:{}", driver.getTitle());
    log.info("CurrentUrl{}", driver.getCurrentUrl());
    //get html format of the page
    log.info("CurrentUrl{}", driver.getPageSource());
    driver.quit();
}
}
