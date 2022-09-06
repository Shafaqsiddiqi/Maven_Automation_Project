package Day11_052922;

import ReusableClasses_Hasan.Reusable_Actions_loggers_Hasan;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Hasan_Selenium_HTML_GoogleSearch {

        WebDriver driver;
        ExtentTest loggers;
        ExtentReports reports;
        @BeforeSuite
        public void SetDriver (){
            driver = Reusable_Actions_loggers_Hasan.setDriver();
            reports = new ExtentReports("src/main/java/Hasan_HTML_Report/Automation_Hasan.html",true);
        }
        @Test(priority = 1)
        public void googleSearchResult (){
            loggers = reports.startTest("search for Key word");
            driver.navigate().to("https://www.google.com");
            Reusable_Actions_loggers_Hasan.sendActions(driver,"//*[@name='q']","BMW", loggers,"Search Input");
            Reusable_Actions_loggers_Hasan.submitAction(driver,"//*[@name='btnK']", loggers,"Search Button");
            reports.endTest(loggers);
        }
        @Test(dependsOnMethods = "googleSearchResult" )
        public void googleCaptureResultNumbers (){
            loggers = reports.startTest("capture result number");
            String resultNumber = Reusable_Actions_loggers_Hasan.getTextAction(driver,"//*[@id='result-stats']", loggers,"Capture Search Result");
            String[] arrayResult = resultNumber.split(" ");
            System.out.println("My search result number "+ arrayResult[1]);
            reports.endTest(loggers);
            loggers.log(LogStatus.INFO,"My search number is "+arrayResult[1]);
        }
        @AfterSuite
        public void quitSession (){
            driver.quit();
            reports.flush();
        }

        //NOTE: WE CAN ALSO USE DEPENDS ON METHOD = "NAME" instead of PRIORITY = 2. THIS WILL skip the @TEST which has depends on method. IF @TEST priority = 1 fails. THIS SAVES TIME.



        //"//*[@name='q']" google search
        //"//*[@name='btnK']" google search button
        //"//*[@id='result-stats']" search result stats
    }// end of class

