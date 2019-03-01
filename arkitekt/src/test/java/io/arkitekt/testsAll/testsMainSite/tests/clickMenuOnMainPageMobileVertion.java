package io.arkitekt.testsAll.testsMainSite.tests;

import io.arkitekt.testsAll.testsMainSite.TestBaseMainSite;
import org.testng.annotations.Test;

import java.io.IOException;

public class clickMenuOnMainPageMobileVertion extends TestBaseMainSite {

    @Test
    public void clickMobileMenu() throws InterruptedException, IOException {
        mainSite.getMainSiteHelper().clickMenuOnMainPageMobile();
    }
}
