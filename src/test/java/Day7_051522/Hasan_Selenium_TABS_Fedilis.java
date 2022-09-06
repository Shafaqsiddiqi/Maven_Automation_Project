package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Hasan_Selenium_TABS_Fedilis {
    public static void main(String[] args) throws InterruptedException {
        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        //options.addArguments("full-screen");
        //define the webdriver i am going to use
        WebDriver driver = new ChromeDriver(options);


        //go to nba.com
        driver.navigate().to("https://www.nba.com");
        Thread.sleep(5000);
        //WebElement games = driver.findElement(By.xpath("//*[@class='NavItem_item__3UN5f NavItem_has-dropdown__1jYlo']"));
        //Click on NBA store
        driver.findElement(By.xpath("//*[@href='https://global.nba.com/store-link-handler']")).click();
        //Store all currently open tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(6000);
        // Go back to NBA home page
        driver.switchTo().window(tabs.get(0));

        Thread.sleep(6000);
        // Click on games and see schedule
        driver.findElements(By.xpath("//*[@class='NavItem_item__3UN5f NavItem_has-dropdown__1jYlo']")).get(0).click();
        Thread.sleep(6000);
        // Go back to NBA store
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(10000);
        //End session, close all tabs
        driver.quit();

    }//end of main
}// end of class

