package io.arkitekt.testsAll.testsRegistration;

import io.arkitekt.mainWorker.LauncherApp;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBaseRegistration {

    protected static final LauncherApp app1 = new LauncherApp(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        app1.init();
        //app1.getNavHelperLeftPanel().navigationToPage("http://staging.arkitekt.io/");
    }

    @AfterClass
    public void tearDown() throws Exception {
        app1.stop();
    }
}
