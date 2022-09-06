package Hasan_POM;

import ReusableClasses_Hasan.Reusable_Actions_loggers_POM_Hasan;
import ReusableClasses_Hasan.Reusable_Annotations_Hasan;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Google_HomePage_Hasan extends Reusable_Annotations_Hasan {
    ExtentTest loggers;

    //create a constructor method that will reference the same name as your class, you can make your
    //page object class methods static when you call it in your test class
    public  Google_HomePage_Hasan (WebDriver driver){
        //page factory function for page object
        PageFactory.initElements(driver, this);
        this.loggers = Reusable_Annotations_Hasan.loggers;
    }
    // define web elements using @FindBy concept
    @FindBy(xpath = "//*[@name='q']")
    WebElement searchField;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googleSearchButton;
    @FindBy(xpath = "//*[@name='links']")
    List<WebElement> listLinks;
 
    public void searchUserValue (String userValue){
        Reusable_Actions_loggers_POM_Hasan.sendActions(driver,searchField,userValue,loggers,"Search Field");
    }
    public void submitOnGoogle () {
        Reusable_Actions_loggers_POM_Hasan.submitAction(driver,googleSearchButton,loggers,"Google Search Button");
    }

}//end of class
