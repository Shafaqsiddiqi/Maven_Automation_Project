package Day12_060422;

import ReusableClasses_Hasan.Reusable_Actions_loggers_Hasan;
import ReusableClasses_Hasan.Reusable_Annotations_Hasan;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Hasan_Selenium_Reusable_Annotations_GoogleSearch extends Reusable_Annotations_Hasan {

    @Test (priority = 1)
    public void googleSearch_result (){
        driver.navigate().to("https://google.com");
        Reusable_Actions_loggers_Hasan.sendActions(driver,"//*[@name='q']","BMW",loggers,"Search Input" );
        Reusable_Actions_loggers_Hasan.submitAction(driver,"//*[@name='btnK']",loggers,"Search Button");
        //reports.endTest(logger);
    }
    @Test(dependsOnMethods = "googleSearch_result" )
    public void googleCaptureResultNumbers (){
        //logger = reports.startTest("capture result number");
        String resultNumber = Reusable_Actions_loggers_Hasan.getTextAction(driver,"//*[@id='result-stats']",loggers,"Capture Search Result");
        String[] arrayResult = resultNumber.split(" ");
        System.out.println("My search result number "+ arrayResult[1]);
        //reports.endTest(logger);
        loggers.log(LogStatus.INFO,"My search number is "+arrayResult[1]);
    }


}// end class



