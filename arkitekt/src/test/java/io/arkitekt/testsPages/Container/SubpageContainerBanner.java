package io.arkitekt.testsPages.Container;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class SubpageContainerBanner extends TestBasePages {

       @Test(priority = 1)
    public void addSubpageContainer() throws Exception {
        app.getPagesHelper().addPages("NEW CONTAINER", 2);
        app.getPagesHelper().addSubPage(22);
    }

    @Test(priority = 2)
    public void addBanner() throws Exception {
        app.getBannerHelper().addImage("page-main-banner-section",
                By.xpath("//header[@class='page-main-banner-section']"),"page-main-banner-section",
                By.xpath("//header[@class='page-main-banner-section']"), 22);
    }

    @Test(priority = 3)
    public void addBannerText() throws Exception {
        app.getBannerHelper().addBannerText(22);
    }

    @Test(priority = 4)
    public void minBannerHeight() throws Exception {
        app.getBannerHelper().moveBannerHeight(22);
    }

    @Test(priority = 5)
    public void addBannerButtonContent() throws Exception {
        app.getBannerHelper().insertContentHyperlink(22, "/new-container", "New Container - Marathon");
    }

    @Test(priority = 6)
    public void addBannerButtonFile() throws InterruptedException, FileNotFoundException {
        app.getBannerHelper().insertFileHyperlink(22);
    }

    @Test(priority = 7)
    public void addBannerButtonExternal() throws InterruptedException {
        app.getBannerHelper().insertExtrenalHyperlink( "Google",22);
    }

    @Test(priority = 8)
    public void addBannerOffButton() throws InterruptedException {
        app.getBannerHelper().insertNoneHyperlink(22);
    }

    @Test(priority = 9)
    public void deleteBannerText() throws Exception {
        app.getBannerHelper().deleteBannerText(22);
    }

    @Test(priority = 10)
    public void deleteBanner() throws Exception {
        app.getBannerHelper().deleteImage(22);
    }

    @Test(priority = 11)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deletePages(22, "CONT");
        app.getPagesHelper().deletePages(2, "HOME");
    }
}

