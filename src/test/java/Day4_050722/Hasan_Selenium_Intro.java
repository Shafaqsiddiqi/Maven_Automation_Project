package Day4_050722;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hasan_Selenium_Intro {
    public static void main(String[] args) {
        //SELENIUM WEBDRIVER with JAVA
         // Selenium webdriver allows you to perform web testing using different browsers such as Firefox, Internet Explorer, Safari & Chrome.
        // Firefox is a default browser for Selenium Webdriver
        // However, Chrome is a better option as its better
        // If you are using a browser like chrome or firefox then "WebDriverManager" needs to be called to set the path for the driver.
        // Example : ---- WebDriverManager.chromedriver().setup(); ---- THIS Command is CASE Sensitive
        // Next, lets define the WebDriver
        // ---- WebDriver driver = new ChromeDriver(); ----
        // The above code sets a user defined variable for a WebDriver and defines a new driver to be used as a Chrome driver.

        // Since the WebDriver is defined as "driver", lets move to opening a web browser/driver.
        // The command to navigate to the web driver/browser is: ---- driver.navigate().to("your URL"); ----
        // For example lets i want to navigate to google.com so i would define the URL by putting the entire URL in the code including the "https://..."
        // driver.navigate().to ("https://www.google.com");   --- this will navigate within same tab on a blank browser that was initially opened by selenium automation

        // The command to close is : ---- driver.close(); ----
        // You can also use ---- driver.quit(); ---- which will quit your chrome drivers that is opened and clear the driver from task manager.
        // ---- driver.close(); ---- will only close the browser that was opened by automation but will not clear your driver from task manager...
        // driver.quit(); is the better choice

        //How to maximize
        // ---- driver.manage().window().maximize();----
        // ---- driver.manage().window().fullscreen();----

        //How to locate an element
        // driver.findElement(By.xpath...
        // Some common actions used on a page are
        // ---- .sendKeys() ---- this is to type something a field
        // ---- .click()---- to click on an element
        // ---- .submit()---- sometime click doesn't work when there is a pop up and its blocking the element to click on, so you can use submit which is like hitting 'Enter' key on your keyboard.

        //xpath
        //In the web page at times an element doesnt have id or name properly and class name might not be unique so in that case we can use xpath to use any additional unique property.

        // There are two ways we can identify xpath which are 1. 'relative' represented by ' // ' and 2. ' absolute '
        // We will be using relative . examples upcoming

        // driver.findElement(By.xpath("//*[@value='MyAccount']")).click();
        // -- //* -- represents relative way to define a tag name so either you can say for instance.
        // -- //* -- the asterisk is basically ignores a specific tag name and refers to any tag name within a page.
        // the @ symbol needs to be added before defining any property name followed by the value.

        // But now if i'm trying to locate an element with text then we can't use @ symbol so it would be more like ---- //*[text()='abc']
        // If it doesnt have any property, but it has a text. Any text you can see with the word in the code, you can use the text property.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
       // driver.close();
        // driver.quit();
        driver.manage().window().maximize();
        //WebElement element = driver.findElement(By.xpath("//*[@value='MyAccount']"));
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
    }//end of main
} //end of class
