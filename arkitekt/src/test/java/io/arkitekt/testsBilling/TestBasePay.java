package io.arkitekt.testsBilling;

import io.arkitekt.appManager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBasePay {

    protected static final AppManager app = new AppManager(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        app.init();
        //app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        //app.getLoginHelper().login("1111111111");

        if (!app.getSiteEditHelper().isElementPresent(By.cssSelector("#choose_template"))) {
            app.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));
            app.getNavHelperLeftPanel().initListSite(true);
            int oneSitemustBe = app.getNavHelperLeftPanel().getCountSite();
            app.getNavHelperLeftPanel().initListSite(false);
            Assert.assertEquals(oneSitemustBe, 1);
        } else {
            if (app.getSiteEditHelper().isElementPresent(By.xpath("//div[@class='main-block' and @data-billing-plan='trial']"))
                    || app.getSiteEditHelper().isElementPresent(By.xpath("//div[@class='main-block' and @data-billing-plan='unsubscribed']"))) {
                app.getBillingHelper().gotoSettingBilling();
            } else if (app.getSiteEditHelper().isElementPresent(By.xpath("//div[@class='main-block' and @data-billing-plan='expired']"))) {
                app.getBillingHelper().gotoSettingBillingExpired();
            } else if (app.getSiteEditHelper().isElementPresent(By.xpath("//div[@class='main-block' and @data-billing-plan='subscribed']"))) {
                app.getNavHelperLeftPanel().initListSite(true);
                int before = app.getBillingHelper().getCountSite();
                if (before == 1) {
                    app.getNavHelperLeftPanel().initListSite(false);
                    app.getBillingHelper().gotoSettingBilling();
                    app.getBillingHelper().cancelSubscribpition();
                    app.getNavHelperLeftPanel().checkingText("Expired On:",
                            By.xpath("//p[@class='help-block settings-billing-date']"));
                }
            }
        }
    }

    @AfterMethod()
    public void restartTest() throws Exception {
        if (!app.getBillingHelper().isElementPresent(By.xpath("//*[@id='settings_billing_info']//h4[text()='Billing Info']"))) {
            app.stop();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        app.stop();
    }
}
