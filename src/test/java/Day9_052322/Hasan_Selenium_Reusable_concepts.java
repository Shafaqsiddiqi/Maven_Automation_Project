package Day9_052322;

import Hasan_ReuseableLibraries.Reusable_Actions_Hasan;
import org.openqa.selenium.WebDriver;

public class Hasan_Selenium_Reusable_concepts {
    public static void main(String[] args) throws InterruptedException {
        // setup driver
        WebDriver driver = Reusable_Actions_Hasan.setDriver();

        driver.navigate().to("https://www.usps.com");

        // hover over quick tools
        Reusable_Actions_Hasan.mouseHover(driver,"//*[text() ='Quick Tools']","Quick Tools");

        //click on calculate a price
        Reusable_Actions_Hasan.clickAction(driver,"//*[text()='Calculate a Price']","Calculate a Price");

        // this was to try and use reusable action of hover 2
//        driver.navigate().to("https://www.shufsd.org/district/pages/central-registration-information");
//        Reusable_Actions_Hasan.mouseHover2(driver,"//*[@class='relative uppercase menu menu-horizontal']",3,"Schools tab");
        // hover2 performed correctly. The reusable action was coded correctly.

        // Capture header text
        String result = Reusable_Actions_Hasan.getTextAction(driver,"//*[text()='Retail Postage Price Calculator']","Header Text");
        System.out.println("My header text is "+ result);
        // Enter zipcode
        Reusable_Actions_Hasan.sendActions(driver,"//*[@id='Origin']","11766","Zip Code");
        Thread.sleep(3000);
        //scroll down
        Reusable_Actions_Hasan.scrollAction(driver,("scroll(0,500)"));
        Thread.sleep(3000);
        //scroll up
        Reusable_Actions_Hasan.scrollAction(driver,("scroll(0,-250)"));
        Thread.sleep(3000);
        // scroll into view for Government Services
        Reusable_Actions_Hasan.scrollView(driver,"//*[text()='Government Services']","Government Services");
        Thread.sleep(3000);
        driver.navigate().to("https:www.usps.com");
        //click on locations
        Reusable_Actions_Hasan.clickAction(driver,"//*[@id='link-locator']","Link locator");
        Thread.sleep(3000);

        // the follow select action didnt work because it was not a select tag.
        //Reusable_Actions_Hasan.selectByVisibleTextAction(driver,"//*[@id='within-select']","50 Miles","With in miles drop down");

        //select the miles and change to 100 miles
        Reusable_Actions_Hasan.selectActionNoTAG(driver,"//*[@id='within-select']","//*[text()='100 Miles']","WithIn Miles dropdown");
        //driver.close();
    }// end of main
}// end of class



