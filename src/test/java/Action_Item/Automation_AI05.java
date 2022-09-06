package Action_Item;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Automation_AI05 {
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
        //Create an arraylist for destination and iterate through it using for loop
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("Miami Beach");
        destinations.add("Vegas");
        for (int i = 0; i < destinations.size(); i++) {

            //navigate to hotels.com

            driver.navigate().to("https://www.hotels.com");


            //type destination in search field
            try {
                WebElement searchField = driver.findElement(By.xpath("//*[@aria-label='Going to']"));
                searchField.click();
                //searchField.sendKeys("Miami");
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("unable to click search field " + e);
            }//end of searchfield exception


            //enter in location in search field
            try {
                WebElement enterDestination = driver.findElement(By.xpath("//*[@class='uitk-field-input uitk-typeahead-input uitk-typeahead-input-v2']"));
                enterDestination.clear();
                enterDestination.sendKeys(destinations.get(i));
                Thread.sleep(3000);
                driver.findElements(By.xpath("//*[@class='is-subText truncate']")).get(0).click();
            } catch (Exception e) {
                System.out.println("unable to enter destination " + e);
            }//end of enter destination Exception


            //Enter check in date in check in field
            try {
                WebElement checkIndropDown = driver.findElement(By.xpath("//*[@id='date_form_field-btn']"));
                checkIndropDown.click();
            } catch (Exception e) {
                System.out.println("unable to enter in check In date " + e);
            }//end of check In exception


            //enter exception for check in date
            try {
                WebElement checkIndate = driver.findElement(By.xpath("//*[@aria-label='Jul 4, 2022']"));
                checkIndate.click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("unable to enter check in date " + e);
            }//end of check in exception

            //enter exception for check out date
            try {
                WebElement checkOutdate = driver.findElement(By.xpath("//*[@aria-label='Jul 8, 2022']"));
                checkOutdate.click();
                Thread.sleep(3000);
            } catch (Exception e) {
                System.out.println("unable to enter check out date " + e);
            }//end of check out date exception

            //enter exception for done button
            try {
                WebElement doneButton = driver.findElement(By.xpath("//*[text()='Done']"));
                doneButton.click();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("unable to click on it " + e);
            }//end of done button exception

            //Create an arralist for adult num
            ArrayList<Integer> adultNum = new ArrayList<>();
            adultNum.add(3);
            adultNum.add(4);

                //enter exception for travelers
                try {
                        WebElement travelers = driver.findElement(By.xpath("//*[@class='uitk-menu-trigger uitk-fake-input uitk-form-field-trigger']"));
                        travelers.click();
                        Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("unable to click on it " + e);
                }//end of travelers exception

                //enter exception for number of travelers
                try {
                    for (int j = 2; j < adultNum.get(i); j++) {
                        WebElement TravelerDropDown = driver.findElement(By.xpath("//*[@aria-label='Increase the number of adults in room 1']"));
                        TravelerDropDown.click();
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    System.out.println("unable to enter num of travelers " + e);
                }//end of num of travelers exception

                //enter exception for done button
                try {
                    WebElement DoneButton = driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']"));
                    DoneButton.click();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Unable to click on it " + e);
                }//end of exception

                //enter exception for search icon
                try {
                    WebElement SearchIcon = driver.findElement(By.xpath("//*[@id='submit_button']"));
                    SearchIcon.click();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Unable to click on it " + e);
                }//end of search icon exception

                //enter exception for the resorts
                try {
                    WebElement Resorts = driver.findElements(By.xpath("//*[@class='listing__link uitk-card-link']")).get(0);
                    Resorts.click();
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Unable to select from it " + e);
                }//end of exception

                //enter exception for switch tabs and store them as array list
                try {
                    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
                    driver.switchTo().window(tabs.get(1));
                } catch (Exception e) {
                    System.out.println("unable to switch between tabs " + e);
                }//end of exception

                //enter exception for capturing name of resort
                try {
                    String NameofResort = driver.findElement(By.xpath("//*[@class='uitk-heading-3']")).getText();
                    Thread.sleep(2000);
                    System.out.println("Name of the resort is " + NameofResort);
                } catch (Exception e) {
                    System.out.println("unable to capture the name " + e);
                }//end of exception

                //create exception for scrolling down
                try {
                    //declare the java script executor in order to scroll down
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript("scroll(0,1600)");
                    //put some wait
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Unable to scroll down the page " + e);
                }//end of exception

                //create exception for capturing first price of hotel
                try {
                    String CapturePriceofHotel = driver.findElement(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).getText();
                    System.out.println("The price of hotel is " + CapturePriceofHotel);
                } catch (Exception e) {
                    System.out.println("Unable to capture the price " + e);
                }//end of exception

                //enter exception for click on reserve button
                try {
                    WebElement ReserveButton = driver.findElement(By.xpath("//*[text()='Reserve']"));
                    ReserveButton.click();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("Unable to click on it " + e);
                }//end of exception

                //enter exception for click on pay at property
                try {
                    WebElement ClickonPayatProperty = driver.findElement(By.xpath("//*[text()='Pay at property']"));
                    ClickonPayatProperty.click();
                } catch (Exception e) {
                    System.out.println("Unable to click on it " + e);
                }//end of exception

                //enter exception for scrolling down
                try {
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript("scroll(0,800)");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("unable to scroll down " + e);
                }//end of exception

                //enter exception for capturing hotel room info
                try {
                    String HotelroomInfo = driver.findElement(By.xpath("//*[@class=' with-small-icon icon-thin-tick']")).getText();
                    Thread.sleep(1000);
                    System.out.println("Hotel room info is " + HotelroomInfo);
                } catch (Exception e) {
                    System.out.println("Unable to capture text " + e);
                }//end of exception

            }


        //close the current tab
        driver.close();


    }//end of main
}//end of class