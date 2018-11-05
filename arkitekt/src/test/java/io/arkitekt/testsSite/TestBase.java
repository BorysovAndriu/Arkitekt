package io.arkitekt.testsSite;

import io.arkitekt.appManager.AppManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.*;
import java.util.Set;

public class TestBase {

    protected static final AppManager app = new AppManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeClass
    public void setUpp() throws Exception {
        app.init();
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("1111111111");

        File file = new File("src/test/resources/cookies.csv");
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bf = new BufferedWriter(writer);
            for(Cookie ck : app.driver.manage().getCookies()) {
                bf.write((ck.getName()+";"
                +ck.getValue()+";"
                +ck.getDomain()+";"
                +ck.getPath()+";"
                +ck.getExpiry()+";"
                +ck.isSecure()));
                bf.newLine();
            }
            bf.flush();
            bf.close();
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
