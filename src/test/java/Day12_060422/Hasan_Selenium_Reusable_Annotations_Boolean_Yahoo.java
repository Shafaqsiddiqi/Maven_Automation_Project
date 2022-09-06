package Day12_060422;

import ReusableClasses_Hasan.Reusable_Actions_loggers_Hasan;
import ReusableClasses_Hasan.Reusable_Annotations_Hasan;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Hasan_Selenium_Reusable_Annotations_Boolean_Yahoo extends Reusable_Annotations_Hasan {

    @Test (priority = 1)
    public void Yahoo_Stay_SignedIn_CheckBox_Verification (){
        driver.navigate().to("https://www.yahoo.com");
        //click on sign in
        Reusable_Actions_loggers_Hasan.clickAction(driver,"//*[text()='Sign in']",loggers,"Sign In");
        //verify is stay signed in box is checked or not
        WebDriverWait wait = new WebDriverWait(driver,10);
        boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='persistent']"))).isSelected();
        if (elementState == true){
            System.out.println("sign in box is checked "+elementState);
            loggers.log(LogStatus.PASS,"sign in box is checked "+elementState);
        }
        else {
            System.out.println("sign in box is  not checked "+elementState);
            loggers.log(LogStatus.FAIL,"sign in box is  not checked "+elementState);
        }
    }// end of test

    @Test (dependsOnMethods = "Yahoo_Stay_SignedIn_CheckBox_Verification")
    public void NavigateToYahooHomePage (){
        loggers.log(LogStatus.INFO,"Navigating to Home Page");
        driver.navigate().to("https://www.yahoo.com");
    }
}// end of class
