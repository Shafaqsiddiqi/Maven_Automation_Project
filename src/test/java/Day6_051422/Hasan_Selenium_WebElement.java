package Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hasan_Selenium_WebElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        // WebElement
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        // Click,clear and enter new data on home value field
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeValue.click();
        homeValue.clear();
        Thread.sleep(2000);
        homeValue.sendKeys("500000");

        Thread.sleep(2000);
        // Switch down payment option from $ to % or vice versa 1st, do the following, THEN switch the amount in the downPay.sendkeys();
        driver.findElement(By.xpath("//*[@value ='percent']")).click();

        //Click, clear and enter new date in down payment field
        WebElement downPay = driver.findElement(By.xpath("//*[@id='downpayment']"));
        downPay.click();
        downPay.clear();
        Thread.sleep(2000);
        downPay.sendKeys("3");



    }//end of main
}//end of class
