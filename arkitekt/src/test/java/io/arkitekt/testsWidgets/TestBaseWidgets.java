package io.arkitekt.testsWidgets;

import io.arkitekt.appManager.operationWidgets.AppManagerWidgets;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBaseWidgets {

    protected static final AppManagerWidgets widgets = new AppManagerWidgets(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        widgets.init();
        widgets.getWidgetsHelper().openSite("http://staging.arkitekt.io/");
        widgets.driver.manage().addCookie(widgets.getPagesHelper().readeCookies());
        widgets.getPagesHelper().click(By.xpath("//a[@class='btn btn-link']"));
        widgets.getPagesHelper().click(By.cssSelector("#pages"));

        /**
         widgets.getWidgetsHelper().initListSite(true);
         int before = widgets.getWidgetsHelper().getCountSite();
         if (before == 1) {
         widgets.getWidgetsHelper().initListSite(false);
         } else {
         widgets.getWidgetsHelper().openFirstSite();
         }*/
    }

    @AfterMethod()
    public void restartTest() throws Exception {
        if (!widgets.getWidgetsHelper().isElementPresent(By.xpath("//div[@id='page_options']"))) {
            tearDown();
            setUpp();
            widgets.getPagesHelper().openSettingPages(1);
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        widgets.stop();
    }
}
