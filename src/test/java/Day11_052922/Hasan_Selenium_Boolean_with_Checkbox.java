package Day11_052922;

import Hasan_ReuseableLibraries.Reusable_Actions_Hasan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Hasan_Selenium_Boolean_with_Checkbox {
    WebDriver driver;
    @BeforeSuite
    public void setDriver (){
        driver = Reusable_Actions_Hasan.setDriver();
    }// of before test
    @Test
    public void Yahoo_Stay_SignedIn_CheckBox_Verfication (){
        driver.navigate().to("https://www.yahoo.com");
        //click on sign in
        Reusable_Actions_Hasan.clickAction(driver,"//*[text()='Sign in']","Sign In");
        //verify is stay signed in box is checked or not
        WebDriverWait wait = new WebDriverWait(driver,10);
        boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='persistent']"))).isSelected();
        System.out.println("sign in box is checked "+elementState);
    }
    @AfterSuite
    public void quitSession (){
        driver.quit();
    }
}// end of class
