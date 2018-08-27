package io.arkitekt.testsPages;

import io.arkitekt.appManager.operationPages.AppManagerPages;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBasePages {

    protected static final AppManagerPages pages = new AppManagerPages(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        pages.init();
        pages.getPagesHelper().openSite("http://staging.arkitekt.io/");
        pages.getPagesHelper().login("andriu02.05.18@gmail.com","1111111111" );
        pages.getPagesHelper().click(By.xpath("//li//a[@href='#!/pages']"));
    }

    @AfterMethod()
    public void restartTest() throws Exception {
        if(! pages.getPagesHelper().isElementPressent(By.xpath("//h5[text()='Primary Navigation']"))) {
            tearDown();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        pages.stop();
    }
}
