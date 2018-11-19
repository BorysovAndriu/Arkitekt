package io.arkitekt.testsPages;

import io.arkitekt.appManager.operationPages.AppManagerPages;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

public class TestBasePages {

    protected static final AppManagerPages pages = new AppManagerPages(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        pages.init();
        pages.getPagesHelper().openSite("http://preprod.arkitekt.io/");
        pages.driver.manage().addCookie(pages.getPagesHelper().readeCookies());
        pages.getPagesHelper().click(By.xpath("//a[@class='btn btn-link']"));
        /**
        pages.getPagesHelper().initListSite(true);
        int before = pages.getPagesHelper().getCountSite();
        if (before == 1) {
            pages.getPagesHelper().initListSite(false);
        } else {
            pages.getPagesHelper().openFirstSite();
        }
        */
        pages.getPagesHelper().click(By.cssSelector("#pages"));
    }

    @AfterMethod()
    public void restartTest() throws Exception {
        if(! pages.getPagesHelper().isElementDesplayed(By.xpath("//h5[text()='Primary Navigation']"))) {
            tearDown();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() {
        pages.stop();
    }
}
