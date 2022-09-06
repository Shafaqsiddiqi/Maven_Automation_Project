package Day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hasan_Selenium_Practice {
    public static void main(String[] args) throws InterruptedException {
        // 1st automation
        // SETUP
        WebDriverManager.chromedriver().setup();
        // Define driver i will use
        WebDriver driver = new ChromeDriver();
        // Assign a command to my driver and enter URL
        driver.navigate().to("https://www.google.com");
        // Maximize windows upon opening
        driver.manage().window().maximize();
        // end the driver
        // driver.quit(); //we should comment out the quit so it doesnt end our automation
        // locate element for search field and type keyword 'cars'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        //submit on google search 'button'
         driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        // capture the google search and print it but after we write the code we will make it into a string so its easier to call
        String searchResults = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println("Results for cars search is " + searchResults);
        // Now we want to only sprint the number from the String searchResults. The entire is About 11,150,000,000 results (0.78 seconds)
        // to do this we will use split string. String[] splitmessage = message.split("");
       String [] arrayResult = searchResults.split(" ");
       System.out.println("Results for cars search is " + arrayResult[1]);

       // close Window
        Thread.sleep(3000);
        driver.quit();

    }//end of main
} // end of java class
