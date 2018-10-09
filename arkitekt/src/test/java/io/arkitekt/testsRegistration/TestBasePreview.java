package io.arkitekt.testsRegistration;

import io.arkitekt.appManager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestBasePreview {

    protected static final AppManager app1 = new AppManager(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        app1.init();
        app1.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    }

    @AfterMethod
    public void restart() throws Exception {
        if (!app1.getNavHelperLeftPanel().isElementPressent(By.xpath("//a[text()='Get started']"))) {
            app1.stop();
            app1.init();
            app1.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        app1.stop();
    }
}
