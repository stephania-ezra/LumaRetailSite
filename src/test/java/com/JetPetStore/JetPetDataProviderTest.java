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
import org.testng.annotations.*;

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

    @Test(dataProvider = "JetPetLoginData")
    public void JetPetCreateUser(String UserId, String NewPassword, String RepeatPassword
            , String FirstName, String LastName, String Email
            , String Phone, String Address1, String Address2
            , String City, String State, String Zip
            , String Country, String Language, String Category) {

        log.info("Step1 : Launching URL");
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");

        log.info("Step 2: On Clicking SignIn");
        WebElement SignInElement = driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]"));
        SignInElement.click();

        log.info("Step 3 : Clicking Register Now");
        WebElement RegisterNowElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/a"));
        RegisterNowElement.click();
        but.stopTheFlow(3);

        log.info("Step 4: User Information");
        WebElement UserInformationTitleElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/h3[1]"));
        Assert.assertTrue(UserInformationTitleElement.isDisplayed());
        log.info("User Information:{}", UserInformationTitleElement.getText());

        log.info("Step 5 : Displaying User Information Details");

        WebElement UserIdElement = driver.findElement(By.name("username"));
        UserIdElement.sendKeys(UserId);

        WebElement NewPasswordElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[2]/td[2]/input"));
        NewPasswordElement.sendKeys(NewPassword);

        WebElement RepeatPasswordElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[3]/td[2]/input"));
        RepeatPasswordElement.sendKeys(RepeatPassword);

        log.info("Step 5: Account Information");
        WebElement AccountInformationTitleElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/h3[2]"));
        Assert.assertTrue(AccountInformationTitleElement.isDisplayed());
        log.info("Account Information Title :{}", AccountInformationTitleElement.getText());

        log.info("Step 6 : Displaying Account Information Details");
        but.stopTheFlow(3);

        WebElement FirstNameElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[1]/td[2]/input"));
        FirstNameElement.sendKeys(FirstName);

        WebElement LastNameElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[2]/td[2]/input"));
        LastNameElement.sendKeys(LastName);

        WebElement EmailElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[3]/td[2]/input"));
        EmailElement.sendKeys(Email);

        WebElement PhoneElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[4]/td[2]/input"));
        PhoneElement.sendKeys(Phone);

        WebElement Address1Element = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[5]/td[2]/input"));
        Address1Element.sendKeys(Address1);

        WebElement Address2Element = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[6]/td[2]/input"));
        Address2Element.sendKeys(Address2);

        WebElement CityElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[7]/td[2]/input"));
        CityElement.sendKeys(City);

        WebElement StateElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[8]/td[2]/input"));
        StateElement.sendKeys(State);

        WebElement ZipElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[9]/td[2]/input"));
        ZipElement.sendKeys(Zip);

        WebElement CountryElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[10]/td[2]/input"));
        CountryElement.sendKeys(Country);

        but.stopTheFlow(3);

        log.info("Step 7: Displaying Profile Information");
        Select language = new Select(driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select")));
        language.selectByValue(Language);

        Select category = new Select(driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[2]/td[2]/select")));
        category.selectByValue(Category);

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

    @DataProvider
    public Object[][] JetPetLoginData() {
        Object[][] data = new Object[1][15];
        data[0][0] = "Vincent";
        data[0][1] = "V@21*89";
        data[0][2] = "V@21*89";
        data[0][3] = "Vincent";
        data[0][4] = "Kumar";
        data[0][5] = "Vinc@gmail.com";
        data[0][6] = "2345612901";
        data[0][7] = "abghstreet";
        data[0][8] = "sdfgstreet";
        data[0][9] = "Ooty";
        data[0][10] = "TamilNadu";
        data[0][11] = "703100";
        data[0][12] = "India";
        data[0][13] = "japanese";
        data[0][14] = "DOGS";
        return data;
    }
}
