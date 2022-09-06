package Action_Item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class Automation_AIWeightWatchers {
    public static void main(String[] args) {

        //setup your chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //set chrome options arguments
        ChromeOptions options = new ChromeOptions();
        //set the condition to incognito mode
        options.addArguments("incognito");
        //set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //for mac use full screen
        options.addArguments("full-screen");
        //define the webdriver i am going to use
        WebDriver driver = new ChromeDriver(options);

        //create an ArrayList to store zipcodes
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11746");
        zipCodes.add("11220");
        zipCodes.add("10462");

        //create a for loop to iterate through it
        for (int i = 0; i< zipCodes.size(); i++) {

        //navigate to weight watchers
        driver.navigate().to("https://www.weightwatchers.com");


            //click on find a workshop
            try {
                WebElement FindAWorkshop = driver.findElement(By.xpath("//*[text()='Find a Workshop']"));
                FindAWorkshop.click();
            } catch (Exception e) {
                System.out.println("Unable to click on it " + e);
            }//end of exception

            //click on In person
            try {
                WebElement InPerson = driver.findElement(By.xpath("//*[text()='In-Person']"));
                InPerson.click();
            } catch (Exception e) {
                System.out.println("Unable to click on it " + e);
            }//end of exception

            //enter your zipcode on search field
            try {
                WebElement SearchField = driver.findElement(By.xpath("//*[@id='location-search']"));
                SearchField.clear();
                //SearchField.sendKeys("11746");
                SearchField.sendKeys(zipCodes.get(i));
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println("unable to enter zipcode " + e);
            }//end of exception

            //click on search arrow
            try {
                WebElement SearchArrow = driver.findElement(By.xpath("//*[@aria-label='Submit']"));
                SearchArrow.click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("unable to click on it " + e);
            }//end of exception

            //click on studio link
            try {
                ArrayList<WebElement> searchResult = new ArrayList<>(driver.findElements(By.xpath("//*[@class='linkContainer-1NkqM']")));
               if (i == 0) {
                 searchResult.get(1).click();
                }
               else if (i == 1) {
                    searchResult.get(2).click();
                }
               else if (i == 2) {
                   searchResult.get(0).click();
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Unable to click on it " + e);
            }//end of exception

            //print studio address
            try {
                String studioAddress = driver.findElement(By.xpath("//*[@class='infoContainer-12kv1']")).getText();
                Thread.sleep(2000);
                System.out.println("The address for the studio is " + studioAddress);
            } catch (Exception e) {
                System.out.println("unable to print the address " + e);
            }//end of exception

            //scroll to the bottom
            try {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("scroll(0,500)");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Unable to scroll down " + e);
            }//end of exception

            //capture and print out the table for studio
            try {
                String studioTable = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                Thread.sleep(1000);
                System.out.println("Entire table for the studio is " + studioTable);
            } catch (Exception e) {
                System.out.println("Unable to print the statement " + e);
            }//end of exception

        }//end of loop

        //Quit the driver
        driver.quit();


    }//end of main
}//end of class
