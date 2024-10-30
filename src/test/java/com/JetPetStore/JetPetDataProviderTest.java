package com.JetPetStore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.luma.BaseUtilTest;
import org.luma.listeners.CustomListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomListener.class})
public class JetPetDataProviderTest extends BaseUtilTest {
    private final BaseUtilTest but = new BaseUtilTest();
    private final Logger log = LogManager.getLogger(JetPetDataProviderTest.class);
    public WebDriver driver = new ChromeDriver();

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
    public void LaunchApp() {
        but.stopTheFlow(3);
        log.info("Step1 : Launching URL");
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        but.stopTheFlow(3);
    }

    @Test(priority = 1)
    public void ClickSignIn() {
        but.stopTheFlow(3);
        log.info("Step 2: On Clicking SignIn");
        WebElement SignInElement = driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]"));
        SignInElement.click();
        but.stopTheFlow(3);
    }

    @Test(priority = 2)
    public void ClickingRegisterNow() {
        but.stopTheFlow(3);
        log.info("Step 3 : Clicking Register Now");
        WebElement RegisterNowElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/a"));
        RegisterNowElement.click();
        but.stopTheFlow(3);
    }

    @Test(priority = 3)
    public void UserInformationTitle() {
        but.stopTheFlow(3);
        log.info("Step 4: User Information");
        WebElement UserInformationTitleElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/h3[1]"));
        Assert.assertTrue(UserInformationTitleElement.isDisplayed());
        log.info("User Information:{}", UserInformationTitleElement.getText());
        but.stopTheFlow(3);
    }

    @Test(priority = 4)
    public void UserInformationDetails() {
        but.stopTheFlow(3);
        log.info("Step 5 : Displaying User Information Details");
        but.stopTheFlow(3);
        WebElement UserIdElement = driver.findElement(By.name("username"));
        UserIdElement.sendKeys("Ethan");
        but.stopTheFlow(3);

        WebElement NewPasswordElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[2]/td[2]/input"));
        NewPasswordElement.sendKeys("123ABC");

        WebElement RepeatPasswordElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[3]/td[2]/input"));
        RepeatPasswordElement.sendKeys("123ABC");
        but.stopTheFlow(3);
    }

    @Test(priority = 5)
    public void AccountInformationTitle() {
        but.stopTheFlow(3);
        log.info("Step 5: Account Information");
        WebElement AccountInformationTitleElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/h3[2]"));
        Assert.assertTrue(AccountInformationTitleElement.isDisplayed());
        log.info("Account Information Title :{}", AccountInformationTitleElement.getText());
        but.stopTheFlow(3);
    }

    @Test(priority = 6)
    public void AccountInformationDetails() {
        but.stopTheFlow(3);
        log.info("Step 6 : Displaying Account Information Details");
        but.stopTheFlow(3);

        WebElement FirstNameElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[1]/td[2]/input"));
        FirstNameElement.sendKeys("David");

        WebElement LastNameElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[2]/td[2]/input"));
        LastNameElement.sendKeys("Peter");

        WebElement EmailElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[3]/td[2]/input"));
        EmailElement.sendKeys("collins.einstein@gmail.com");

        WebElement PhoneElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[4]/td[2]/input"));
        PhoneElement.sendKeys("0987654321");

        WebElement Address1Element = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[5]/td[2]/input"));
        Address1Element.sendKeys("DubaiKurukuSandu");

        WebElement Address2Element = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[6]/td[2]/input"));
        Address2Element.sendKeys("DubaiMainRoad");

        WebElement CityElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[7]/td[2]/input"));
        CityElement.sendKeys("Chennai");

        WebElement StateElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[8]/td[2]/input"));
        StateElement.sendKeys("TamilNadu");

        WebElement ZipElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[9]/td[2]/input"));
        ZipElement.sendKeys("600900");

        WebElement CountryElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[10]/td[2]/input"));
        CountryElement.sendKeys("India");

        but.stopTheFlow(3);
    }

    @Test(priority = 7)
    public void ProfileInformation() {

        log.info("Step 7: Displaying Profile Information");
        Select Language = new Select(driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select")));
        Language.selectByValue("english");

        Select Category = new Select(driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[2]/td[2]/select")));
        Category.selectByValue("FISH");

        WebElement EnableMyListElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[3]/td[2]/input"));
        EnableMyListElement.click();

        WebElement EnableMyBannerElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[4]/td[2]/input"));
        EnableMyBannerElement.click();

        WebElement SaveAccountInformationElement = driver.findElement(By
                .cssSelector("#Catalog > form > input[type=submit]"));
        SaveAccountInformationElement.click();

        but.stopTheFlow(3);
    }
}
