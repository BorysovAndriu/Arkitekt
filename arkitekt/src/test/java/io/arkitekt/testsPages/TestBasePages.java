package io.arkitekt.testsPages;

import io.arkitekt.appManager.operationPages.AppManagerPages;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBasePages {

    protected static final AppManagerPages pages = new AppManagerPages(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        pages.init();
        //pages.getPagesHelper().openSite("http://preprod.arkitekt.io/");
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

    @BeforeMethod
    public void restart(Method method) throws Exception {
        if (!pages.getPagesHelper().
                isElementPresent(By.xpath("//div[@class='left-block-item-inner pages active-menu']"))) {
            tearDown();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() {
        pages.stop();
    }
}
