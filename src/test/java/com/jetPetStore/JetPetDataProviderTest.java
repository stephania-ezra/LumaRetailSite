package com.jetPetStore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JetPetDataProviderTest {

    private final Logger log = LogManager.getLogger(JetPetDataProviderTest.class);

    @Test(dataProvider = "jetPetLoginData")
    /*public void JetPetCreateUser(String UserId, String NewPassword, String RepeatPassword
            , String FirstName, String LastName, String Email
            , String Phone, String Address1, String Address2
            , String City, String State, String Zip
            , String Country, String Language, String Category) {*/

    //instead of passing multiple string values in parameter , by passing String[]
    //as parameter and calling the values String[0] like that is much nice :)
    public void jetPetCreateUser(String[] s) throws InterruptedException {

        log.info("Step1 : Launching URL");
        WebDriver driver = new ChromeDriver();

        //Create WebDriver for the Browser(chrome) here .like above
        //because while running parallel the browser should be created each time

        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");

        log.info("Step 2: On Clicking SignIn");
        WebElement SignInElement = driver.findElement(By.xpath("//*[@id=\"MenuContent\"]/a[2]"));
        SignInElement.click();

        log.info("Step 3 : Clicking Register Now");
        WebElement RegisterNowElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/a"));
        RegisterNowElement.click();

        log.info("Step 4: User Information");
        WebElement UserInformationTitleElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/h3[1]"));
        Assert.assertTrue(UserInformationTitleElement.isDisplayed());
        log.info("User Information:{}", UserInformationTitleElement.getText());

        log.info("Step 5 : Displaying User Information Details");
        WebElement UserIdElement = driver.findElement(By.name("username"));
        UserIdElement.sendKeys(s[0]);

        WebElement NewPasswordElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[2]/td[2]/input"));
        NewPasswordElement.sendKeys(s[1]);

        WebElement RepeatPasswordElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[3]/td[2]/input"));
        RepeatPasswordElement.sendKeys(s[2]);

        log.info("Step 5: Account Information");
        WebElement AccountInformationTitleElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/h3[2]"));
        Assert.assertTrue(AccountInformationTitleElement.isDisplayed());
        log.info("Account Information Title :{}", AccountInformationTitleElement.getText());

        log.info("Step 6 : Displaying Account Information Details");
        WebElement FirstNameElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[1]/td[2]/input"));
        FirstNameElement.sendKeys(s[3]);

        WebElement LastNameElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[2]/td[2]/input"));
        LastNameElement.sendKeys(s[4]);

        WebElement EmailElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[3]/td[2]/input"));
        EmailElement.sendKeys(s[5]);

        WebElement PhoneElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[4]/td[2]/input"));
        PhoneElement.sendKeys(s[6]);

        WebElement Address1Element = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[5]/td[2]/input"));
        Address1Element.sendKeys(s[7]);

        WebElement Address2Element = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[6]/td[2]/input"));
        Address2Element.sendKeys(s[8]);

        WebElement CityElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[7]/td[2]/input"));
        CityElement.sendKeys(s[9]);

        WebElement StateElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[8]/td[2]/input"));
        StateElement.sendKeys(s[10]);

        WebElement ZipElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[9]/td[2]/input"));
        ZipElement.sendKeys(s[11]);

        WebElement CountryElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[10]/td[2]/input"));
        CountryElement.sendKeys(s[12]);

        log.info("Step 7: Displaying Profile Information");
        Select language = new Select(driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select")));
        language.selectByValue(s[13]);
        //language.selectByVisibleText("japanese");
        //language.selectByIndex(0);

        Select category = new Select(driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[2]/td[2]/select")));
        category.selectByValue(s[14]);
        //category.selectByVisibleText("CATS");
        //category.selectByIndex(4);

        WebElement EnableMyListElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[3]/td[2]/input"));
        EnableMyListElement.click();

        WebElement EnableMyBannerElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[4]/td[2]/input"));
        EnableMyBannerElement.click();

        WebElement SaveAccountInformationElement = driver.findElement(By
                .cssSelector("#Catalog > form > input[type=submit]"));
        SaveAccountInformationElement.click();

        driver.close();
    }

    //checking with data type as String
    //previously worked for Object Data type

    @DataProvider(parallel = true)
    public String[][] jetPetLoginData() {
        String[][] data = new String[2][15];
        data[0][0] = "JohnAbraham";
        data[0][1] = "A@21*89";
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

        data[1][0] = "Michael";
        data[1][1] = "MW@21*89";
        data[1][2] = "OP@21*89";
        data[1][3] = "Jacob";
        data[1][4] = "Job";
        data[1][5] = "Jac@gmail.com";
        data[1][6] = "2468013579";
        data[1][7] = "DubaiKurukuSandu";
        data[1][8] = "DubaiMainRoad";
        data[1][9] = "Dubai";
        data[1][10] = "TamilNadu";
        data[1][11] = "733100";
        data[1][12] = "India";
        data[1][13] = "japanese";
        data[1][14] = "DOGS";

        return data;
    }
}
