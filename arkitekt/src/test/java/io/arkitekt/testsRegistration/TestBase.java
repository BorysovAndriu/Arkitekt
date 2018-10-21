package io.arkitekt.testsRegistration;

import io.arkitekt.appManager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected static final AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeMethod
    public void setUpp() throws Exception {
        app.init();
        //app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("andriu2018.10.04@gmail.com", "1111111111");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        app.stop();
    }

}
