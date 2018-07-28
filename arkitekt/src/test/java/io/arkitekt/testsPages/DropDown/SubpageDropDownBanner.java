package io.arkitekt.testsPages.DropDown;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SubpageDropDownBanner extends TestBasePages {

    @Test(priority = 1)
    public void addDropDown() throws Exception {
        app.getPagesHelper().addPages( "NEW DROPDOWN", 3);
    }

    @Test(priority = 1)
    public void addSubDropDown() throws Exception {
     app.getPagesHelper().addSubPage(33);
    }

    @Test(priority = 2)
    public void addBanner() throws Exception {
        app.getBannerHelper().addImage("page-main-banner-section",
                By.xpath("//header[@class='page-main-banner-section']"),"page-main-banner-section",
                By.xpath("//header[@class='page-main-banner-section']"), 33);
    }


    @Test(priority = 9)
    public void deleteDropDown() throws Exception {
        app.getPagesHelper().deletePages(33, "NEW DROPDOWN");
        app.getPagesHelper().deletePages(3, "HOME");
    }
    
    
}
