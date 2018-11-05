package io.arkitekt.appManager.testsSite;

import io.arkitekt.appManager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class TestBase {

    protected static final AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeClass
    public void setUpp() throws Exception {
        app.init();
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("1111111111");

        Set cookies = app.driver.manage().getCookies();

        try {
        File file = new File("src/test/resources/cookies.csv");
        PrintWriter writer = new PrintWriter(file.getAbsoluteFile());
        writer.print(cookies);
        writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }

}
