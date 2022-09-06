package Day8_052122;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.text.html.Option;
import java.sql.DriverManager;

public class Hasan_Selenium_GetTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        driver.navigate().to("https://www.google.com");
        String actualTitle = driver.getTitle();
         if (actualTitle.equals("Google"))
             System.out.println("Actual Title Matches");
         else
             System.out.println("Title doesn't match. Actual tile is "+ actualTitle);

            // another way to do this is the following:
//        driver.navigate().to("https://www.google.com");
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Google";
//        System.out.println("Actual title is "+actualTitle+" Expected title is "+ expectedTitle  );

    }// end of main
}//end of class
