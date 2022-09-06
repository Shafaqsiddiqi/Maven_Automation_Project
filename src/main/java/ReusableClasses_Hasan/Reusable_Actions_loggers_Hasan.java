package ReusableClasses_Hasan;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reusable_Actions_loggers_Hasan {

    //set a static timeout variable so it can cover all explicit for all methods
    static int timeout = 20;

    public static WebDriver setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        options.addArguments("start-maximized");
       // options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    } // end of setDriver

    public static void mouseHover (WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,8);
        Actions mouseActions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            mouseActions.moveToElement(element).perform();
        }// of try
        catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName);
        }// end catch
    } // end of mouseHover

    // mousehover for 'ElementS'
    public static void mouseHover2 (WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,8);
        Actions mouseActions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            mouseActions.moveToElement(element).perform();
        }// of try
        catch (Exception e) {
            System.out.println("Unable to hover2 on element " + elementName);
        }// end catch
    } // end of mouseHover2

    public static void clickAction (WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,8);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully click element"+ elementName);
        } // end of try
        catch (Exception e) {
            System.out.println("Unable to click element "+ elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to click element "+ elementName + " " + e);
        } // end of catch
    } // end of clickElement

    public static void clickIndexAction (WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,8);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
        } // end of try
        catch (Exception e) {
            System.out.println("Unable to click index element "+ elementName + " " + e);
        } // end of catch
    } // end of click Index Element

    public static void submitAction(WebDriver driver,String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS,"Successfully submit element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to submit on element " + elementName + " " + e);

        }//end of exception
    }//end of submit

    public static void submitIndexAction(WebDriver driver,String xpath, int indexNumber, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit index on element " + elementName + " " + e);
        }//end of exception
    }//end of submit Index


    public static void sendActions (WebDriver driver, String xpath, String userValue,ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,8);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            element.click();
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS,"Successfully enter user value on element "+elementName);
        } // end of try
        catch (Exception e ) {
            System.out.println("Unable to send output " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to send output for user value on element " + elementName + " " + e);
        }// end of catch
    }// end of sendActions

    public static void sendIndexActions (WebDriver driver, String xpath,int indexNumber, String userValue, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,8);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            element.click();
            element.clear();
            element.sendKeys(userValue);
            logger.log(LogStatus.PASS, "Successfully send index output for user value  on element "+elementName);
        } // end of try
        catch (Exception e ) {
            System.out.println("Unable to send output " + elementName + " " + e);
        }// end of catch
    }// end of sendIndexActions

    // Get Text With Return value
    public static String getTextAction(WebDriver driver,String xpath,ExtentTest logger,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            result = element.getText();
            logger.log(LogStatus.PASS,"Successfully captured text of element "+elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text on element " + elementName + " " + e);
            logger.log(LogStatus.FAIL,"Unable to get text on element " + elementName + " " + e);
        }
        return result;
    }// end of getTextAction

    // Get Text withOut Return value
    public static  void getTextAction2 (WebDriver driver,String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            String errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            System.out.println("The error message is " + errorMessage);
        } catch (Exception e) {
            System.out.println("unable to catch text" +elementName + " " +e);
        }//end of capture text exception
    }//end of getTextAction2

    public static String getTextIndexAction(WebDriver driver,String xpath,int indexNumber,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text on element " + elementName + " " + e);
        }
        return result;
    } // end of get Text Index


    public static void verifyTitleMethod (WebDriver driver, String actualTitle) {
        WebDriverWait wait = new WebDriverWait(driver,8);
        String title = setDriver().getTitle();
        if ( title.equals(actualTitle))
            System.out.println("title matches actualTitle");
        else
            System.out.println("Title doesn't match. Actual title is "+ title);
    } // end of verifyTitleMethod

    // value has select TAG
    public static void selectByVisibleTextAction (WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select selectVariable = new Select(element);
            selectVariable.selectByVisibleText(userValue);
        }
        catch (Exception e) {
            System.out.println("Unable to select from visible text "+ elementName+ ""+ e);
        }
    } // end of select by VISISBLE TEXT

    public static void selectByValueAction (WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select selectVariable = new Select(element);
            selectVariable.selectByValue(userValue);
        }
        catch (Exception e) {
            System.out.println("Unable to select from value "+ elementName+ ""+ e);
        }
    } // end of select by VALUE

    public static void selectByIndexAction (WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select selectVariable = new Select(element);
            selectVariable.selectByIndex(indexNumber);
        }
        catch (Exception e) {
            System.out.println("Unable to select from indexNumber "+ elementName+ ""+ e);
        }
    } // end of select by INDEX NUMBER

    // value DOES NOT have a select tag
    public static void selectActionNoTAG (WebDriver driver, String xpath, String xpath2, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath2))).click();
            // this xpath expression will be ("//*[text()='value of text']")
        }
        catch (Exception e) {
            System.out.println("NOTE: Select method without a select tag: Unable to select from value of text "+ elementName+ ""+ e);
        }
    } // end of select Action NO TAG

    // Scroll action
    public static void scrollAction (WebDriver driver, String scroll) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
        jse.executeScript(scroll);
    }
        catch (Exception e){
            System.out.println("Unable to use scroll action " +e);
        }
    } // end of scrollAction

    // Scroll into View
    public static void scrollView (WebDriver driver, String xpath,  String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);",element);
        }
        catch (Exception e) {
            System.out.println("Unable to scroll into view "+ elementName+ " "+ e);
        }
    }

    // Switching Tabs
    public static void switchTabs (WebDriver driver, int indexNumber) {
        ArrayList <String> tab  = new ArrayList<>(driver.getWindowHandles());
        try {
            driver.switchTo().window(tab.get(indexNumber));
        }
        catch (Exception e) {
            System.out.println("Unable to switch tabs");
        }
    } // end of switch tabs
    
} // end of class
