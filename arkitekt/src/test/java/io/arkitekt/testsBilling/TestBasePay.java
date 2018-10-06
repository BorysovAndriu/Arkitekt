package io.arkitekt.testsBilling;

import io.arkitekt.appManager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBasePay {

    protected static final AppManager app = new AppManager(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        app.init();
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("andriu2018.10.04@gmail.com", "1111111111");
        app.getNavHelperLeftPanel().initListSite(true);
        int before = app.getNavHelperLeftPanel().getCountSite();
        if (before == 1) {
            app.getNavHelperLeftPanel().initListSite(false);
        } else {
            app.getNavHelperLeftPanel().openFirstSite();
        }
        app.getBillingHelper().gotoSettingBilling();
    }

    @AfterMethod()
    public void restartTest() throws Exception {
        if (!app.getBillingHelper().isElementPressent(By.xpath("//*[@id='settings_billing_info']//input"))) {
            app.stop();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        app.stop();
    }
}
