package Hasan_POM;


import ReusableClasses_Hasan.Reusable_Actions_loggers_POM_Hasan;
import ReusableClasses_Hasan.Reusable_Annotations_Hasan;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class GoogleSearchResultPage_Hasan extends Reusable_Annotations_Hasan {
    ExtentTest loggers;

    public GoogleSearchResultPage_Hasan (WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.loggers = Reusable_Annotations_Hasan.loggers;
    }

    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement searchResults;

    public void captureResultNumber (){
        String results = Reusable_Actions_loggers_POM_Hasan.getTextAction(driver,searchResults,loggers,"Search Results");
        String[] arrayResults = results.split(" ");
        System.out.println("My search result number is "+ arrayResults[1]);
        loggers.log(LogStatus.INFO,"My search result number is "+ arrayResults[1]);
    }

}// end of class
