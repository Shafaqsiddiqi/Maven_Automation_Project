package Day9_052322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

public class Hasan_Selenium_Explicit_USPS {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);


//        //Exploring Explicit wait but using mouse actions
//        driver.navigate().to("https://www.usps.com");
//        //add mouse actions so we can hoover
//        Actions mouseActions = new Actions(driver);
//        //setting up the explicit wait
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        //hoover over quick tools
//        mouseActions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Quick Tools']")))).perform();
//        //click on track a package
//        mouseActions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']")))).click().perform();
//        // click and give input of tracking number. We need to click first bc the TAG is 'textarea' and not 'search'
//        mouseActions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-input']")))).click().perform();
//        mouseActions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-input']")))).sendKeys("6315041868").perform();
//        //click on track to see if tracking number exists
//        mouseActions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track']")))).click().perform();
//        Thread.sleep(5000);
//        driver.quit();


        //Exploring Explicit Wait not restricted to mouse actions
        driver.navigate().to("https://www.usps.com");
        //add mouse actions so we can hoover
        Actions mouseActions = new Actions(driver);
        //setting up the explicit wait
        WebDriverWait wait = new WebDriverWait(driver,8);
        //hoover over quick tools
        mouseActions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Quick Tools']")))).perform();
        //click on track a package
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();
        // click and give input of tracking number. We need to click first bc the TAG is 'textarea' and not 'search'
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-input']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-input']"))).sendKeys("6315041868");
        //click on track to see if tracking number exists
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track']"))).click();
        Thread.sleep(5000);
        driver.close();

    }//end of main
}//end of class
