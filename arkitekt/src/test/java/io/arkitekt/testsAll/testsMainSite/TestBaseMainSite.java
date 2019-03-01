package io.arkitekt.testsAll.testsMainSite;

import io.arkitekt.mainWorker.operationMainSite.MainSite;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestBaseMainSite {

    protected static final MainSite mainSite = new MainSite(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        mainSite.init();
    }

    @AfterMethod
    public void openMainPage() throws IOException {
        mainSite.getMainSiteHelper().openPageUrl(
                mainSite.getMainSiteHelper().readToPropertiesFile("local", "web.baseUrl"));
    }

    @AfterClass
    public void tearDown() {
        mainSite.stop();
    }
}
