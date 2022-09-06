package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Hasan_Selenium_SELECT {
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


        // navigate to mortgagecalculator.org
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);
        // Scroll into View of See Melvilles Best Rates (I did this on my own just so i dont have to manually scroll to see the results for the upcoming stuff)
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement seeBestRate = driver.findElement(By.xpath("//*[@name='ratebutton']"));
        jse.executeScript("arguments[0]. scrollIntoView(true);",seeBestRate);
        Thread.sleep(2000);

        //select start month from dropdown
        //WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        // define select command
        //Select dropDown = new Select(startMonth);
        // Select the visible text
        //dropDown.selectByVisibleText("Jun");
        //Thread.sleep(2000);

        //Clicking on dropdown and its value if the dropdown tag is not under select tag or even if does have a select tag you can use this process. This is a safer process while the other one is more dynamic process as it allows you multiple ways to select.
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        // click on the value of the start month
        startMonth.click();
        // click value in dropdown
        driver.findElement(By.xpath("//*[text()='Apr']")).click();
        Thread.sleep(2000);

        // select Loan Type from drop down
        WebElement loanType = driver.findElement(By.xpath("//*[@name='param[milserve]']"));
        // define select command
        Select loanDropDown = new Select(loanType);
        // select by visible text
        loanDropDown.selectByVisibleText("USDA");
        Thread.sleep(2000);

        // select Buy or Refi:
        WebElement buyRefi = driver.findElement(By.xpath("//*[@name='param[refiorbuy]']"));
        // define select command
        Select buyRefiDropDown = new Select(buyRefi);
        // Select by visible text
        buyRefiDropDown.selectByVisibleText("Buy");
        Thread.sleep(5000);
        driver.quit();

    }//end of main
}//end of class
