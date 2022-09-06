package Day12_060422;

import Hasan_POM.BaseClass_Hasan;
import ReusableClasses_Hasan.Reusable_Annotations_Hasan;
import org.testng.annotations.Test;

public class Hasan_GoogleSearch_POM  extends Reusable_Annotations_Hasan {

    @Test(priority = 1)
    public void SearchForKeyWordOnGoogle(){
        driver.navigate().to("https://www.google.com");
        BaseClass_Hasan.google_homePage_hasan().searchUserValue("BMW");
        BaseClass_Hasan.google_homePage_hasan().submitOnGoogle();
    }

    @Test(dependsOnMethods = "SearchForKeyWordOnGoogle")
    public void CaptureSearchNumber (){
        BaseClass_Hasan.googleSearchResultPage_hasan().captureResultNumber();
    }
}
