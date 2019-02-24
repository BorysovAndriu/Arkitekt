package io.arkitekt.testsSite;

import io.arkitekt.appManager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static final AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeClass
    public void setUpp() throws Exception {
        app.init();
        //app.getNavHelperLeftPanel().navigationToPage("http://staging.arkitekt.io/");
        app.getNavHelperLeftPanel().login("1111111111");
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }

}
