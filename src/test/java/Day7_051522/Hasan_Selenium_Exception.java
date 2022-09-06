package Day7_051522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Hasan_Selenium_Exception {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(3000);

        // Clear Price and add new
        try {
            WebElement price = driver.findElement(By.xpath("//*[@name='ma']"));
            price.clear();
            price.sendKeys("450000");
        }catch (Exception e)  {
            System.out.println("unable to locate purchase price "+ e);
        }

        //click advance button option
        try {
            driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();

        }catch (Exception e) {
            System.out.println("Unable to locate advance option button "+ e);
        }
       Thread.sleep(3000);

        // Click start month for a dropdown and select October
        try {
            Select selectMonth = new Select(driver.findElement(By.xpath("//*[@name='sm']")));
            selectMonth.selectByValue("10");
        }catch (Exception e ) {
            System.out.println("Unable to find select month " +e);
        }
        Thread.sleep(3000);

        // Click calculate button
        try {
            driver.findElement(By.xpath("//*[@value='Calculate']")).click();
        }
        catch (Exception e){
            System.out.println("NO CALCULATE BUTTON FOUND "+e);
            Thread.sleep(3000);
        }
        try {
           String entire = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(1).getText();
            System.out.println("My entire payment is "+ entire);
        } catch (Exception e){
            System.out.println("Unable to print AMOUNT "+ e);
        }

        driver.close();

    }//end of main
}//end of class



