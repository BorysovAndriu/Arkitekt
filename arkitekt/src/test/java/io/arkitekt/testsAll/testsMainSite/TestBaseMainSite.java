package io.arkitekt.testsAll.testsMainSite;

import io.arkitekt.mainWorker.LauncherApp;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBaseMainSite {

    protected static final LauncherApp app = new LauncherApp(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        app.init();
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }
}
