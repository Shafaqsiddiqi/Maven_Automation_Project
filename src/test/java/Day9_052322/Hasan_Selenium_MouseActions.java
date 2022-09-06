package Day9_052322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hasan_Selenium_MouseActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.usps.com");
        Thread.sleep(3000);

        // Mouse Actions
        Actions mouseAction = new Actions(driver);
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        // hoover over this tab
        mouseAction.moveToElement(sendTab).perform();
        Thread.sleep(6000);

        //click on tracking under the Send-Tab.
        WebElement tracking = driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseAction.moveToElement(tracking).click().perform();
        Thread.sleep(3000);

        //enter a tracking number
        WebElement enterNumber = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseAction.moveToElement(enterNumber).click().perform();
        mouseAction.moveToElement(enterNumber).sendKeys("111222333").perform();
        Thread.sleep(3000);

//        WebDriverWait wait = new WebDriverWait(driver,7);
//       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[ '']")));

       driver.close();

    }//end of main
}//end of class
