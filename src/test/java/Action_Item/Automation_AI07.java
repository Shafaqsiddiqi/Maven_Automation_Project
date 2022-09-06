package Action_Item;

import ReuseableLibraries.Reusable_Actions;
import ReusableClasses.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Automation_AI07 {

    //define the driver outside so it can be reusable with other annotation methods
    WebDriver driver;
    //declare the logger
    ExtentTest logger;
    //declare the report
    ExtentReports reports;

    //before suite will set the driver we are going to use
    @BeforeSuite
    public void SetChromeDriver(){
        driver = Reusable_Actions.setDriver();
        //define the path to report
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_AI07",true);
    }//end of before suite annotation


    @Test(priority = 1)
    public void ClickShopForplans(){
    //Use Case; To be able to click on find a doctor
    logger = reports.startTest("Shop For Plans");
    driver.navigate().to("https://www.humana.com");
    //click on shop for plans
    Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Shop for Plans']",logger,"Shop for Plans");
    //from the dropdown, click on shop dental plan
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Shop dental plans']",logger,"Shop Dental Plan");
        //select state from the drop down
        Select state = new Select(driver.findElement(By.xpath("//*[@name='State']")));
        state.selectByVisibleText("New York");
        //Enter age in age field
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='Age']","23",logger,"Age field");
        reports.endTest(logger);
    }//end of test 1

    @Test(priority = 2)
    public void PaymyPremium() {
        //Use case; Find a doctor
        logger = reports.startTest("PaymyPremium");
        driver.navigate().to("https://www.humana.com");
        //click on member resources
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Member Resources']",logger,"Member Resources");
        //click on find a doctor
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Pay my premium']",logger,"pay my premiumr");
        //click on sign in
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='adjust-height adj-background-teal']",logger,"Sign in");
        //switch to new tab at index 1
      //first we have to store new tabs in an arraylist
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //switch to new tab at index 1
        driver.switchTo().window(tabs.get(1));
        //switch to default tab at index 0
        driver.switchTo().window(tabs.get(0));
    }//end of test 2

   @Test(priority = 3)
    public void ViewIdCard () {
        //Use case; enter credentials to capture error message
        logger = reports.startTest("CaptureErrorMessage");
        driver.navigate().to("https://www.humana.com");
       //click on member resources
       Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Member Resources']",logger,"Member Resources");
       //click on view id card
       Reusable_Actions_Loggers.clickAction(driver,"//*[text()='View ID card']",logger,"View id card");
       //Enter value on username field
       Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='Username']","1122",logger,"UserValue");
       //Enter password
       Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='Password']","11223",logger,"Password");
       //click on sign in
    Reusable_Actions_Loggers.clickAction(driver,"//*[@class='adj-button-underline']",logger,"Sign in");
       //capture the error message
       String errorMessage = Reusable_Actions_Loggers.getTextAction(driver,"//*[@class='nc-form-error-summary nu-mb-5 nu-px-4 md:nu-font-lg']",logger,"error message");
       System.out.println("Error message is " + errorMessage);
       reports.endTest(logger);
    }//end of test 3



}//end of class
