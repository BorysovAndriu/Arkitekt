package io.arkitekt.testPreviewSite;

import io.arkitekt.appManager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBasePreview {

    protected static final AppManager app1 = new AppManager(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        app1.init();
        //app1.getNavHelperLeftPanel().openSite("http://preprod.arkitekt.io/");
    }

    @AfterClass
    public void tearDown() throws Exception {
        app1.stop();
    }
}
