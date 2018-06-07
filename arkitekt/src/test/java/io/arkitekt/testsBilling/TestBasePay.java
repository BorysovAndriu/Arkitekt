package io.arkitekt.testsBilling;

import io.arkitekt.appmanager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestBasePay {

    protected static final AppManager app = new AppManager(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        app.init();
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("andriu02.05.18@gmail.com","1111111111" );
        //String subdonaim = app.getNavHelperLeftPanel().getIdPage("textContent",
               // By.xpath("//span[@class='pull-left user-subdomain']"));
        app.getBillingHelper().gotoSettingBilling();
    }

    @AfterMethod()
    public void restartTest() throws Exception {
        if(app.getBillingHelper().isElementPressent(By.xpath("//*[@id='settings_billing_info']//input"))) {
            return;
        }
        else {
            tearDown();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        app.stop();

    }
}