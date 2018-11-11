package io.arkitekt.testsSite;

import io.arkitekt.appManager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static final AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeClass
    public void setUpp() throws Exception {
        app.init();
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.driver.manage().addCookie(app.getLoginHelper().readeCookies());
        app.getNavHelperLeftPanel().click(By.xpath("//a[@class='btn btn-link']"));
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }

}
