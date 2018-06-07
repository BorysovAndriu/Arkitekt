package io.arkitekt.testsPages;

import io.arkitekt.appmanager.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBasePages {

    protected static final AppManager app = new AppManager(BrowserType.CHROME);
    //public static String subdomain;


    @BeforeClass
    public void setUpp() throws Exception {
        app.init();
        app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
        app.getLoginHelper().login("andriu02.05.18@gmail.com","1111111111" );
        //subdomain = app.getNavHelperLeftPanel().getIdPage("textContent",
                //By.xpath("//span[@class='pull-left user-subdomain']"));
        app.getPagesHelper().click(By.xpath("//li//a[@href='#!/pages']"));
        //return subdomain;
    }

    @AfterMethod()
    public void restartTest() throws Exception {
        if(! app.getPagesHelper().isElementPressent(By.xpath("//h5[text()='Primary Navigation']"))) {
            tearDown();
            setUpp();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        app.stop();
    }
}
