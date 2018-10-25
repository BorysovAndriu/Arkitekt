package io.arkitekt.testsPages.Container;

import io.arkitekt.testsPages.TestBasePages;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ContainerBanner extends TestBasePages {

    @Test(priority = 1)
    public void addContainer() throws Exception {
        pages.getPagesHelper().addPages("NEW CONTAINER", 2);
    }

    @Test(priority = 2)
    public void addBanner() throws Exception {
        pages.getBannerHelper().addImage( 2);
    }

    @Test(priority = 3)
    public void addBannerText() throws Exception {
        pages.getBannerHelper().addBannerText(2);
    }

    @Test(priority = 4)
    public void minBannerHeight() throws Exception {
        pages.getBannerHelper().moveBannerHeight(2);
    }

    @Test(priority = 5)
    public void addBannerButtonContent() throws Exception {
        pages.getHyperlinkHelper().insertContentHyperlink(2,"/new-container", "New Container - Marathon");
    }

    @Test(priority = 6)
    public void addBannerButtonFile() throws InterruptedException, FileNotFoundException {
        pages.getHyperlinkHelper().insertFileHyperlink(2);
    }

    @Test(priority = 7)
    public void addBannerButtonExternal() throws InterruptedException {
        pages.getHyperlinkHelper().insertExternalHyperlink( "Google",2);
    }

    @Test(priority = 8)
    public void addBannerOffButton() throws InterruptedException {
        pages.getHyperlinkHelper().insertNoneHyperlink(2);
    }

    @Test(priority = 9)
    public void deleteBannerText() throws Exception {
        pages.getBannerHelper().deleteBannerText(2);
    }

    @Test(priority = 10)
    public void deleteBanner() throws Exception {
        pages.getBannerHelper().deleteImage(2);
    }

    @Test(priority = 11)
    public void deleteContainer() throws Exception {
        pages.getPagesHelper().deletePages(2, "HOME");
    }
}

