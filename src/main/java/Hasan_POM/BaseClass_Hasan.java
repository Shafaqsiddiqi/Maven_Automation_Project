package Hasan_POM;

import ReusableClasses_Hasan.Reusable_Annotations_Hasan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass_Hasan  extends Reusable_Annotations_Hasan {

    // set up constructor as help
    public BaseClass_Hasan (WebDriver driver) {
        PageFactory.initElements(driver,this);
    } // end of constructor

    public static Google_HomePage_Hasan google_homePage_hasan(){
        Google_HomePage_Hasan google_homePage_hasan = new Google_HomePage_Hasan(driver);
        return google_homePage_hasan;
    }

    public static GoogleSearchResultPage_Hasan googleSearchResultPage_hasan (){
        GoogleSearchResultPage_Hasan googleSearchResultPage_hasan = new GoogleSearchResultPage_Hasan(driver);
        return googleSearchResultPage_hasan;
    }

}// end of class
