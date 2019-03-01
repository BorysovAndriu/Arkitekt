package io.arkitekt.testsAll.testsPages.Container;

import io.arkitekt.testsAll.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class SubpageContainerBanner extends TestBasePages {

    @Test(priority = 1)
    public void addContainer() throws Exception {
        pages.getPagesHelper().addPages("NEW CONTAINER", 2);
    }

    @Test(priority = 2)
    public void addSubpageContainer() throws Exception {
        pages.getPagesHelper().addSubPage(22);
    }

    @Test(priority = 3)
    public void addBanner() throws Exception {
        pages.getBannerHelper().addImage( 22);
    }

    @Test(priority = 4)
    public void addBannerText() throws Exception {
        pages.getBannerHelper().addBannerText(22);
    }

    @Test(priority = 5)
    public void minBannerHeight() throws Exception {
        pages.getBannerHelper().moveBannerHeight(22);
    }

    @Test(priority = 6)
    public void addBannerButtonContent() throws Exception {
        pages.getHyperlinkHelper().insertContentHyperlink(22,  "New Container - Marathon");
    }

    @Test(priority = 7)
    public void addBannerButtonFile() throws InterruptedException {
        pages.getHyperlinkHelper().insertFileHyperlink(22);
    }

    @Test(priority = 8)
    public void addBannerButtonExternal() throws InterruptedException {
        pages.getHyperlinkHelper().insertExternalHyperlink( "Google",22);
    }

    @Test(priority = 9)
    public void addBannerOffButton() throws InterruptedException {
        pages.getHyperlinkHelper().insertNoneHyperlink(22);
    }

    @Test(priority = 10)
    public void deleteBannerText() throws Exception {
        pages.getBannerHelper().deleteBannerText(22);
    }

    @Test(priority = 11)
    public void deleteBanner() throws Exception {
        pages.getBannerHelper().deleteImage(22);
    }

    @Test(priority = 12)
    public void deleteContainer() throws Exception {
        //pages.getPagesHelper().deletePages(22, "CONT");
        pages.getPagesHelper().deletePages(2, "HOME");
    }
}

