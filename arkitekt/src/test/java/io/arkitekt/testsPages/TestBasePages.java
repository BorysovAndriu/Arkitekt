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
        pages.getLoginHelper().login("andriu2018.10.04@gmail.com","1111111111");
        pages.getPagesHelper().click(By.xpath("//li//a[@href='#!/pages']"));
    }

    @AfterMethod()
    public void restartTestt() throws Exception {
        if(! pages.getPagesHelper().isElementPressent(By.xpath("//h5[text()='Primary Navigation']"))) {
            tearDown();
            pages.init();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        pages.stop();
    }
}
