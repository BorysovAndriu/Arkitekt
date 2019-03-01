package io.arkitekt.testLogin;

import io.arkitekt.mainWorker.launcherApp;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBaseLogin {

    protected static final launcherApp app1 = new launcherApp(BrowserType.CHROME);

    @BeforeClass
    public void setUpp() throws Exception {
        app1.init();
    }

   /* @BeforeMethod
    public void startMailServer() {
        app1.mail().start();
    }

    @AfterMethod
    public void restart() throws Exception {
        app1.mail().stop();
        if (!app1.getNavHelperLeftPanel().isElementPresent(By.xpath("//a[text()='Get started']"))) {
            app1.stop();
            app1.init();
        }
    }*/

    @AfterClass
    public void tearDown() throws Exception {
        app1.stop();
    }
}
