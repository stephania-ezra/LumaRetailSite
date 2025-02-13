package sdetqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.practisingDaily.LoginDemoQATest.log;



public class DropDownNormalAndMultipleTest {

    WebDriver driver;

    @Test
    public void dropDownCheck(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
        log.info("Step 1 : URL is launched");

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
        UserIdElement.sendKeys("Michael");

        WebElement NewPasswordElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[2]/td[2]/input"));
        NewPasswordElement.sendKeys("MW@21*89");

        WebElement RepeatPasswordElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[3]/td[2]/input"));
        RepeatPasswordElement.sendKeys("OP@21*89");

        log.info("Step 5: Account Information");
        WebElement AccountInformationTitleElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/h3[2]"));
        Assert.assertTrue(AccountInformationTitleElement.isDisplayed());
        log.info("Account Information Title :{}", AccountInformationTitleElement.getText());

        log.info("Step 6 : Displaying Account Information Details");
        WebElement FirstNameElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[1]/td[2]/input"));
        FirstNameElement.sendKeys("Ethan");

        WebElement LastNameElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[2]/td[2]/input"));
        LastNameElement.sendKeys("Calvin");

        WebElement EmailElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[3]/td[2]/input"));
        EmailElement.sendKeys("EC@gmail.com");

        WebElement PhoneElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[4]/td[2]/input"));
        PhoneElement.sendKeys("9876543210");

        WebElement Address1Element = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[5]/td[2]/input"));
        Address1Element.sendKeys("kannanStreet");

        WebElement Address2Element = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[6]/td[2]/input"));
        Address2Element.sendKeys("MumbaiMainRoad");

        WebElement CityElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[7]/td[2]/input"));
        CityElement.sendKeys("Sydney");

        WebElement StateElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[8]/td[2]/input"));
        StateElement.sendKeys("Australia");

        WebElement ZipElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[9]/td[2]/input"));
        ZipElement.sendKeys("833800");

        WebElement CountryElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[2]/tbody/tr[10]/td[2]/input"));
        CountryElement.sendKeys("Australia");

        log.info("Step 7: Displaying Profile Information");

        WebElement languageDropDownElement = driver.findElement(By.xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select"));
        Select language = new Select(languageDropDownElement);
        language.selectByVisibleText("japanese");

        //language.selectByVisibleText("japanese");
        //language.selectByIndex(0);

        //method 1
        /*WebElement categoryDropDownElement = driver.findElement(By.
                xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[2]/td[2]/select"));
        Select category = new Select(categoryDropDownElement);
       // category.selectByVisibleText("CATS");

        //method 2
        List<WebElement> categoryList = category.getOptions();

        for(WebElement categories :categoryList ) {
            if (categories.getText().equals("CATS")) {
                categories.click();
            }
        }*/

        //category.selectByValue("CATS");
        //category.selectByVisibleText("CATS");
        //category.selectByIndex(4);

        //method 3  Handling multiple dropdowns by using generic method
       WebElement languageElement =driver.findElement(By.
                xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[1]/td[2]/select"));
        selectOptionsFromDropDown(languageElement,"english");

        WebElement categoryElement = driver.findElement(By.
                xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[2]/td[2]/select"));
        selectOptionsFromDropDown(categoryElement,"FISH");



        WebElement EnableMyListElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[3]/td[2]/input"));
        EnableMyListElement.click();

        WebElement EnableMyBannerElement = driver.findElement(By
                .xpath("//*[@id=\"Catalog\"]/form/table[3]/tbody/tr[4]/td[2]/input"));
        EnableMyBannerElement.click();

        WebElement SaveAccountInformationElement = driver.findElement(By
                .cssSelector("#Catalog > form > input[type=submit]"));
        SaveAccountInformationElement.click();

        driver.quit();
    }

    //method for selecting multiple dropdowns
    public void selectOptionsFromDropDown(WebElement element , String value){
        Select dropdown = new Select(element);
        List<WebElement> allOptions = dropdown.getOptions();

        for(WebElement option :allOptions ) {
            if (option.getText().equals(value)) {
                option.click();
            }
        }
    }
}
