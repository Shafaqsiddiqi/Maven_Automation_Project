package Day10_052822;

import Hasan_ReuseableLibraries.Reusable_Actions_Hasan;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Hasan_Selenium_TestNG_ForLoop {
    WebDriver driver;
    @BeforeSuite
    public void setDriver (){
        driver = Reusable_Actions_Hasan.setDriver();
    }
    @Test
    public void ForLoopSearchResults() {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Tesla");
        ArrayList<Integer> yearMade = new ArrayList<Integer>();
        yearMade.add(2020);
        yearMade.add(2021);
        yearMade.add(2022);
        ArrayList<String> price = new ArrayList<>();
        price.add("100k");
        price.add("150k");
        price.add("200k");
//        price.add("250k");
//        price.add("300k");
//        price.add("350k");


        for (int i = 0; i < cars.size(); i++) {
            driver.navigate().to("https://www.google.com");
            Reusable_Actions_Hasan.sendActions(driver, "//*[@name='q']", cars.get(i), "Search");
            Reusable_Actions_Hasan.submitAction(driver,"//*[@name='btnK']","Search Button");
            String captureResult = Reusable_Actions_Hasan.getTextAction(driver,"//*[@id='result-stats']","Search Result");
            String[] arrayList = captureResult.split(" ");
            Reusable_Actions_Hasan.clickAction(driver,"//*[@aria-label='Page 2']","Search page 2");
            String captureResultPg2 = Reusable_Actions_Hasan.getTextAction(driver,"//*[@id='result-stats']","Search Result page 2");
            String[] arrayListPg2 = captureResultPg2.split(" ");
            System.out.println(" My search result for page 1 "+cars.get(i)+" is "+ arrayList[1]+ " and my search results for page 2 are "+arrayListPg2[4]);

        }
    }// en of test
   @AfterSuite
    public void quitSession (){
        driver.quit();
    }

    //"//*[@name='q']" google search
    //"//*[@name='btnK']" google search button
    //"//*[@id='result-stats']" search result stats
   // "//*[@aria-label='Page 2']"
}
