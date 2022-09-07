package Day5_050822.Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hasan_Selenium_Scrolling {
    public static void main(String[] args) throws InterruptedException {
        //Setting up driver with options
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

//      SCROLLING
        // Lets navigate to our website
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2000);
        // Define Javascript Executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // declare webelement of the variable we want to scroll into
        WebElement ShareButton = driver.findElement(By.xpath("//*[@id='share_button']"));
        // Scroll into this share the calculation button
        jse.executeScript("arguments[0].scrollIntoView(true);",ShareButton);
        Thread.sleep(2000);
        // Click on the share this calculation button
        ShareButton.click();
        Thread.sleep(2000);
        // Scroll back up
        jse.executeScript("scroll(0,-500)");
        Thread.sleep(2000);
        // close the windows for this browser
        driver.quit();

    }//end of main
}//end of class
