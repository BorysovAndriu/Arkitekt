package io.arkitekt.testsAll.testsMainSite;

import io.arkitekt.mainWorker.operationMainSite.MainSite;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBaseMainSite {

    protected static final MainSite mainSite = new MainSite(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        mainSite.init();
    }

    @AfterClass
    public void tearDown() {
        mainSite.stop();
    }
}
