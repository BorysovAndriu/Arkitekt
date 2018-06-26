package io.arkitekt.testsPages.Page;

import io.arkitekt.testsPages.TestBasePages;
import org.testng.annotations.Test;

public class PageBanner extends TestBasePages {

    @Test(priority = 1)
    public void addBanner() throws Exception {
        app.getBannerHelper().addImage();
    }

    @Test(priority = 2)
    public void addBannerText() throws Exception {
        app.getBannerHelper().addBannerText();
    }

    @Test(priority = 3)
    public void bannerHeight() throws Exception {
        app.getBannerHelper().moveBannerHeight();
    }

    @Test(priority = 4)
    public void contentButton() throws Exception {
        app.getBannerHelper().insertHyperlink("Content link");
    }

    @Test(priority = 3)
    public void deleteBannerText() throws Exception {
        app.getBannerHelper().deleteBannerText();
    }

    @Test(priority = 4)
    public void deleteBanner() throws Exception {
        app.getBannerHelper().deleteImage();
    }


}
