package io.arkitekt.testsAll.testsWidgets;

import io.arkitekt.mainWorker.operationWidgets.AppManagerWidgets;
import org.openqa.selenium.By;
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
        //widgets.getMainSiteHelper().navigationToPage("http://staging.arkitekt.io/");
        widgets.driver.manage().addCookie(widgets.getPagesHelper().readeCookies());
        widgets.getPagesHelper().click(By.xpath("//a[@class='btn btn-link']"));


        /**
         widgets.getMainSiteHelper().initListSite(true);
         int before = widgets.getMainSiteHelper().getCountSite();
         if (before == 1) {
         widgets.getMainSiteHelper().initListSite(false);
         } else {
         widgets.getMainSiteHelper().openFirstSite();
         }*/
    }

    @BeforeMethod
    public void openSettingPage(Method method) throws InterruptedException {
        String nameTest = method.getName();
        if (nameTest == "addPage"){
            widgets.getPagesHelper().click(By.cssSelector("#pages"));
        } else {
            widgets.getPagesHelper().click(By.cssSelector("#pages"));
            widgets.getPagesHelper().openSettingPages(1);
        }
    }

    @AfterMethod()
    public void restartTest() throws Exception {
        if (!widgets.getPagesHelper().isElementPresent(By.cssSelector("#page_options"))) {
            widgets.stop();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        widgets.stop();
    }
}
