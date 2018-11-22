package io.arkitekt.testsWidgets;

import io.arkitekt.appManager.operationWidgets.AppManagerWidgets;
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
        //widgets.getWidgetsHelper().openSite("http://staging.arkitekt.io/");
        widgets.driver.manage().addCookie(widgets.getPagesHelper().readeCookies());
        widgets.getPagesHelper().click(By.xpath("//a[@class='btn btn-link']"));

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
    public void openSettingPage(Method method) throws InterruptedException {
        String nameTest = method.getName();

        if(nameTest == "addPage" || nameTest =="deletePage") {
            widgets.getPagesHelper().click(By.cssSelector("#pages"));
        } else {
            if (widgets.getPagesHelper().isElementDesplayed(By.xpath("//h5[text()='Primary Navigation']"))) {
                widgets.getPagesHelper().openSettingPages(1);
            } else if (widgets.getPagesHelper().isElementDesplayed(By.xpath("//div[@class='user-name']"))) {
                widgets.getPagesHelper().click(By.cssSelector("#pages"));
                widgets.getPagesHelper().openSettingPages(1);
            }
        }
    }

    @AfterMethod()
    public void restartTest() throws Exception {
        if (!widgets.getPagesHelper().isElementDesplayed(By.cssSelector("#page_options"))) {
            widgets.stop();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        widgets.stop();
    }
}
