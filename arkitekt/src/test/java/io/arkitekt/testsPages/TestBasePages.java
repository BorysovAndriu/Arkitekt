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
        pages.getPagesHelper().openSite("http://staging.arkitekt.io/");
        pages.getPagesHelper().login("andriu2018.10.04@gmail.com","1111111111");
        pages.getPagesHelper().initListSite(true);
        int before = pages.getPagesHelper().getCountSite();
        if (before == 1) {
            pages.getPagesHelper().initListSite(false);
        } else {
            pages.getPagesHelper().openFirstSite();
        }
        pages.getPagesHelper().click(By.xpath("//li//a[@href='#!/pages']"));
    }

    @AfterMethod()
    public void restartTestt() throws Exception {
        if(! pages.getPagesHelper().isElementPressent(By.xpath("//h5[text()='Primary Navigation']"))) {
            pages.stop();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        pages.stop();
    }
}
