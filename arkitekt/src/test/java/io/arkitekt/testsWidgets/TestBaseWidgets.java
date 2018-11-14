package io.arkitekt.testsWidgets;

import io.arkitekt.appManager.operationWidgets.AppManagerWidgets;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBaseWidgets {

    protected static final AppManagerWidgets widgets = new AppManagerWidgets(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        widgets.init();
        widgets.getWidgetsHelper().openSite("http://staging.arkitekt.io/");
        widgets.driver.manage().addCookie(widgets.getPagesHelper().readeCookies());
        widgets.getPagesHelper().click(By.xpath("//a[@class='btn btn-link']"));
        //widgets.getPagesHelper().click(By.cssSelector("#pages"));

        /**
         widgets.getWidgetsHelper().initListSite(true);
         int before = widgets.getWidgetsHelper().getCountSite();
         if (before == 1) {
         widgets.getWidgetsHelper().initListSite(false);
         } else {
         widgets.getWidgetsHelper().openFirstSite();
         }*/
    }

    @BeforeMethod
    public void howTest(Method method) throws InterruptedException {
        String nameTest = method.getName();
        if (nameTest == "addPage") {
            widgets.getPagesHelper().click(By.cssSelector("#pages"));
        } else if (nameTest == "addBlog") {
            widgets.getPagesHelper().gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
            if (!widgets.getPagesHelper().isElementPresent(By.cssSelector(".sb5-empty-text"))) {
                try {
                    widgets.getPagesHelper().stopFrame();
                    widgets.getPagesHelper().click(By.cssSelector("#pages"));
                    widgets.getPagesHelper().openSettingPages(1);
                } catch (NoSuchElementException ex) {
                    widgets.getPagesHelper().addPages("NEW PAGE", 1);
                }
            } else {
                widgets.getPagesHelper().stopFrame();
            }
        } else {
            widgets.getPagesHelper().gotoFrame(By.xpath("//iframe[@class='block-iframe']"));
            if (!widgets.getPagesHelper().isElementPresent(By.xpath("//div[@class='blog-block row']"))) {
                widgets.getPagesHelper().stopFrame();
                widgets.getPagesHelper().click(By.cssSelector("#pages"));
                widgets.getPagesHelper().openSettingPages(1);
            } else {
                widgets.getPagesHelper().stopFrame();
            }
        }
    }

    @AfterMethod()
    public void restartTest() throws Exception {
        if (!widgets.getPagesHelper().isElementPresent(By.xpath("//iframe[@class='block-iframe']"))) {
            widgets.stop();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        widgets.stop();
    }
}
