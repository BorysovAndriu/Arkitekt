package io.arkitekt.testsPages.Container;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ContainerBanner extends TestBasePages {

    @Test(priority = 1)
    public void addContainer() throws Exception {
        app.getPagesHelper().addPages("NEW CONTAINER", 2);
    }

    @Test(priority = 2)
    public void addBanner() throws Exception {
        app.getBannerHelper().addImage("page-main-banner active_banner",
                By.xpath("//header[@class='page-main-banner active_banner']"),
                "page-main-banner", By.xpath("//header[@class='page-main-banner']"), 2);
    }

    @Test(priority = 3)
    public void addBannerText() throws Exception {
        app.getBannerHelper().addBannerText(2);
    }

    @Test(priority = 4)
    public void minBannerHeight() throws Exception {
        app.getBannerHelper().moveBannerHeight(2);
    }

    @Test(priority = 5)
    public void addBannerButtonContent() throws Exception {
        app.getBannerHelper().insertContentHyperlink(2,"/new-container", "New Container - Marathon");
    }

    @Test(priority = 6)
    public void addBannerButtonFile() throws InterruptedException, FileNotFoundException {
        app.getBannerHelper().insertFileHyperlink(2);
    }

    @Test(priority = 7)
    public void addBannerButtonExternal() throws InterruptedException {
        app.getBannerHelper().insertExtrenalHyperlink( "Google",2);
    }

    @Test(priority = 8)
    public void addBannerOffButton() throws InterruptedException {
        app.getBannerHelper().insertNoneHyperlink(2);
    }

    @Test(priority = 9)
    public void deleteBannerText() throws Exception {
        app.getBannerHelper().deleteBannerText(2);
    }

    @Test(priority = 10)
    public void deleteBanner() throws Exception {
        app.getBannerHelper().deleteImage(2);
    }

    @Test(priority = 11)
    public void deleteContainer() throws Exception {
        app.getPagesHelper().deletePages(2, "HOME");
    }
}

