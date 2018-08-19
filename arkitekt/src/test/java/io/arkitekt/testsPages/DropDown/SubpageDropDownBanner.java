package io.arkitekt.testsPages.DropDown;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SubpageDropDownBanner extends TestBasePages {

    @Test(priority = 1)
    public void addDropDown() throws Exception {
        pages.getPagesHelper().addPages( "NEW DROPDOWN", 3);
    }

    @Test(priority = 1)
    public void addSubDropDown() throws Exception {
     pages.getPagesHelper().addSubPage(33);
    }

    @Test(priority = 2)
    public void addBanner() throws Exception {
        pages.getBannerHelper().addImage("page-main-banner-section",
                By.xpath("//header[@class='page-main-banner-section']"),"page-main-banner-section",
                By.xpath("//header[@class='page-main-banner-section']"), 33);
    }


    @Test(priority = 9)
    public void deleteDropDown() throws Exception {
        pages.getPagesHelper().deletePages(33, "NEW DROPDOWN");
        pages.getPagesHelper().deletePages(3, "HOME");
    }
    
    
}
