package Day11_052922;

import Hasan_ReuseableLibraries.Reusable_Actions_Hasan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class Hasan_Selenium_USPS_List_WebElements {
    WebDriver driver;
    @BeforeSuite
    public void setDriver (){
        driver = Reusable_Actions_Hasan.setDriver();
    }// end of @before suite
    @Test (priority = 1)
    public void USPS_Tabs_Count (){
        driver.navigate().to("https://www.usps.com");
        WebDriverWait wait = new WebDriverWait(driver,10);
        List<WebElement> tabsCount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
        System.out.println("My tabs count is "+ tabsCount.size());

        for (int i =0; i< tabsCount.size();i++){
            // it needs to be redefined for the loop to run properly
            tabsCount = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
            tabsCount.get(i).click();
        }// end of loop
    } // of @test

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }


}// end of class
