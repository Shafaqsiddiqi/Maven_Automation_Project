package ReusableClasses_Hasan;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class Reusable_Annotations_Hasan {
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest loggers;

    @BeforeSuite
    public void setChromeDriver (){
        driver = Reusable_Actions_loggers_Hasan.setDriver();
        // define the path to the ExtentReports
        reports = new ExtentReports("src/main/java/Hasan_HTML_Report/Automation_Hasan.html",true);
    } // end of before suite


    // set Before method to capture test name for each @test, so it can be added to HTML report
    @BeforeMethod
    public void getTestName (Method testName){
        loggers = reports.startTest(testName.getName());
    }// end of before method

    // set after method for each @Test in your test class
    @AfterMethod
    public void endLogger (){
        reports.endTest(loggers);
    }// end of after method

    @AfterSuite
    public void quitSession (){
        reports.flush();
        driver.quit();

    }// end of the after test suite



}//end of class
