package io.arkitekt.testsRegistration;

import io.arkitekt.appmanager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBasePreview {

    protected static final AppManager app1 = new AppManager(BrowserType.CHROME);

    @BeforeMethod
    public void setUpp() throws Exception {
        app1.init();
        app1.getNavHelperLeftPanel().openSite("http://arkitekt.io/");

}

    @AfterMethod
    public void tearDown() throws Exception {
        app1.stop();
    }
}
