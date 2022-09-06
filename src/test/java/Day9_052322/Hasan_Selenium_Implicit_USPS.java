package Day9_052322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Hasan_Selenium_Implicit_USPS {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        //implicit
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.navigate().to("https://www.usps.com");
        //create mouse action to hoover over a tab
        Actions mouseAction = new Actions(driver);
        WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        mouseAction.moveToElement(quickTools).perform();
        //click on track a package element under tab which was hoovered over(quickTOOLS)
        driver.findElement(By.xpath("//*[text()='Track a Package']")).click();
        //enter tracking number
        WebElement trackingPckg = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        trackingPckg.click();
        trackingPckg.sendKeys("000111222333");
        Thread.sleep(5000);
        driver.close();


    }//end of main
}// end of class
