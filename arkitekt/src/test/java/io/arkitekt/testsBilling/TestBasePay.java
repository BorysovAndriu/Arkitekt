package io.arkitekt.testsBilling;

import io.arkitekt.mainWorker.launcherApp;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBasePay {

    protected static final launcherApp app = new launcherApp(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        app.init();
        //app.getNavHelperLeftPanel().navigationToPage("http://staging.arkitekt.io/");
        app.driver.manage().addCookie(app.getBillingHelper().readeCookies());
        app.getBillingHelper().click(By.xpath("//a[@class='btn btn-link']"));

        if (!app.getSiteEditHelper().isElementPresent(By.cssSelector("#choose_template"))) {
            app.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));
            app.getNavHelperLeftPanel().initListSite(true);
            int oneSitemustBe = app.getNavHelperLeftPanel().getCountSite();
            app.getNavHelperLeftPanel().initListSite(false);
            Assert.assertEquals(oneSitemustBe, 1);
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
