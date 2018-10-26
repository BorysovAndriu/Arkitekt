package io.arkitekt.testsPages.Page;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class PageBanner extends TestBasePages {

    @Test(priority = 1)
    public void addPage() throws Exception {
        pages.getPagesHelper().addPages("NEW PAGE", 1);
    }

    @Test(priority = 2)
    public void addBanner() throws Exception {
        pages.getBannerHelper().addImage(1);
    }

    @Test(priority = 3)
    public void addBannerText() throws Exception {
        pages.getBannerHelper().addBannerText(1);
    }

    @Test(priority = 4)
    public void minBannerHeight() throws Exception {
        pages.getBannerHelper().moveBannerHeight(1);
    }

    @Test(priority = 5)
    public void addBannerButtonContent() throws Exception {
        pages.getHyperlinkHelper().insertContentHyperlink(1, "New Page - Marathon");
    }

    @Test(priority = 6)
    public void addBannerButtonFile() throws InterruptedException, FileNotFoundException {
        pages.getHyperlinkHelper().insertFileHyperlink(1);
    }

    @Test(priority = 7)
    public void addBannerButtonExternal() throws InterruptedException {
        pages.getHyperlinkHelper().insertExternalHyperlink( "Google",1);
    }

    @Test(priority = 8)
    public void addBannerOffButton() throws InterruptedException {
        pages.getHyperlinkHelper().insertNoneHyperlink(1);
    }

    @Test(priority = 9)
    public void deleteBannerText() throws Exception {
        pages.getBannerHelper().deleteBannerText(1);
    }

    @Test(priority = 10)
    public void deleteBanner() throws Exception {
        pages.getBannerHelper().deleteImage(1);
    }

    @Test(priority = 11)
    public void deletePage() throws Exception {
        pages.getPagesHelper().deletePages(1, "HOME");
    }
}
