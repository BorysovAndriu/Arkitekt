package io.arkitekt.testsPages.DropDown;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SubpageDropDownBanner extends TestBasePages {

    @Test(priority = 1)
    public void addDropDown() throws Exception {
        app.getPagesHelper().addPages(By.xpath("//a[@id='add_new_folder']"), "NEW DROPDOWN");
    }

    @Test(priority = 1)
    public void addSubDropDown() throws Exception {
     app.getPagesHelper().addSubDropDown(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]//a"), "NEW PAGE");
    }

    @Test(priority = 2)
    public void addBanner() throws Exception {
        app.getBannerHelper().addImage("page-main-banner-section",
                By.xpath("//header[@class='page-main-banner-section']"),"page-main-banner-section",
                By.xpath("//header[@class='page-main-banner-section']"), 33);
    }


    @Test(priority = 9)
    public void deleteDropDown() throws Exception {
        app.getPagesHelper().deleteDropDown(By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]"),
                By.xpath("//button[@id=\"menu_item_remove\"]"));
    }
    
    
}
