package Day5_050822.Day6_051422;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hasan_Selenium_FindElementS {
    public static void main(String[] args) throws InterruptedException {
        // setup
        WebDriverManager.edgedriver().setup();
        // define driver
        WebDriver driver = new EdgeDriver();
        // assign driver a command
        driver.navigate().to("https://www.bing.com");
        // wait three second
        Thread.sleep(3000);
        // maximize screen
        driver.manage().window().maximize();
        // we want to go to the images in bing
    //driver.findElement(By.xpath("//*[@class,'scope']")).click();
        // so if you execute the last command it wont take you to images because the properties and values are shared
        //fyi the next code
    //driver.findElement(By.xpath("//*[@data-h='ID=HpApp,9107.1']")).click();
        // NOTE: so if we execute the last command it WILL take you to images bc i was able to locate its specific property
        // USING findElements (with an "S")
        // we must use findElements bc the properties of images video shopping are shared
        // we must use contain for the name all them share in common
    // driver.findElements(By.xpath("//*[contains(@class,'scope')]")).get(1).submit();
        // the previous code might not work because we may need to replace * with the exact parent tag
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();


    }//end of main
}//end of java class
