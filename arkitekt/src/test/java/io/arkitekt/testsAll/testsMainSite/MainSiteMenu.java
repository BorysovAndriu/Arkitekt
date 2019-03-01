package io.arkitekt.testsAll.testsMainSite;

import org.testng.annotations.Test;

import java.io.IOException;

public class MainSiteMenu extends TestBaseMainSite{

    @Test(priority = 1)
    public void clickMenu() throws InterruptedException, IOException {
        mainSite.getMainSiteHelper().clickMenuOnMainPage();
    }

    @Test(priority = 2)
    public void clickMobileMenu() throws InterruptedException, IOException {
        mainSite.getMainSiteHelper().clickMenuOnMainPageMobile();
    }

    @Test(priority = 3)
    public void clickMenuOnThemesPage() throws InterruptedException, IOException {
        mainSite.getMainSiteHelper().clickMenuOnThemesPage();
    }

    @Test(priority = 4)
    public void chooseWebSite() throws InterruptedException {
        mainSite.getMainSiteHelper().createMyWebsite();
    }

    @Test(priority = 5)
    public void getStarted() throws InterruptedException {
        mainSite.getMainSiteHelper().getStarted();
    }

}
