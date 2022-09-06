package Day10_052822;

import Hasan_ReuseableLibraries.Reusable_Actions_Hasan;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Hasan_Selenium_TestNG_Example {
    WebDriver driver;
    @BeforeSuite
    public void SetDriver (){
        driver = Reusable_Actions_Hasan.setDriver();
    }
    @Test (priority = 1)
    public void searchResult (){
        driver.navigate().to("https://www.google.com");
        Reusable_Actions_Hasan.sendActions(driver,"//*[@name='q']","BMW","Search Input");
        Reusable_Actions_Hasan.submitAction(driver,"//*[@name='btnK']","Search Button");
    }
    @Test(priority = 2)
    public void captureResultNumbers (){
        String resultNumber = Reusable_Actions_Hasan.getTextAction(driver,"//*[@id='result-stats']","Capture Search Result");
        String[] arrayResult = resultNumber.split(" ");
        System.out.println("My search result number "+ arrayResult[1]);
    }
    @AfterSuite
    public void quitSession (){
        driver.quit();
    }

    //NOTE: WE CAN ALSO USE DEPENDS ON METHOD = "NAME" intstead of PRIORITY = 2. THIS WILL skip the @TEST which has depends on method. IF @TEST priority = 1 fails. THIS SAVES TIME.



    //"//*[@name='q']" google search
    //"//*[@name='btnK']" google search button
    //"//*[@id='result-stats']" search result stats
}// end of class
