package io.arkitekt.testsPages.DropDown;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class SubpageDropDownBanner extends TestBasePages {

    @Test(priority = 1)
    public void addDropDown() throws Exception {
        pages.getPagesHelper().addPages( "NEW DROPDOWN", 3);
    }

    @Test(priority = 2)
    public void addSubDropDown() throws Exception {
        pages.getPagesHelper().addSubPage(33);
    }

    @Test(priority = 3)
    public void addBanner() throws Exception {
        pages.getBannerHelper().addImage( 33);
    }
    @Test(priority = 4)
    public void addBannerText() throws Exception {
        pages.getBannerHelper().addBannerText(33);
    }

    @Test(priority = 5)
    public void minBannerHeight() throws Exception {
        pages.getBannerHelper().moveBannerHeight(33);
    }

    @Test(priority = 6)
    public void addBannerButtonContent() throws Exception {
        pages.getHyperlinkHelper().insertContentHyperlink(33, "New Page - Marathon");
    }

    @Test(priority = 7)
    public void addBannerButtonFile() throws InterruptedException {
        pages.getHyperlinkHelper().insertFileHyperlink(33);
    }

    @Test(priority = 8)
    public void addBannerButtonExternal() throws InterruptedException {
        pages.getHyperlinkHelper().insertExternalHyperlink( "Google",33);
    }

    @Test(priority = 9)
    public void addBannerOffButton() throws InterruptedException {
        pages.getHyperlinkHelper().insertNoneHyperlink(33);
    }

    @Test(priority = 10)
    public void deleteBannerText() throws Exception {
        pages.getBannerHelper().deleteBannerText(33);
    }

    @Test(priority = 11)
    public void deleteBanner() throws Exception {
        pages.getBannerHelper().deleteImage(33);
    }

    @Test(priority = 12)
    public void deleteDropDown() throws Exception {
        //pages.getPagesHelper().deletePages(33, "NEW DROPDOWN");
        pages.getPagesHelper().deletePages(3, "HOME");
    }
}
