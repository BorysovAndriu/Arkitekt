package io.arkitekt.testsRegistration;

import io.arkitekt.appManager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    Date date = new Date();
  SimpleDateFormat format = new SimpleDateFormat("yyyy.mm.dd");

  protected static final AppManager app = new AppManager(BrowserType.CHROME);

  @BeforeMethod
  public void setUpp() throws Exception {
    app.init();
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com","1111111111" );
  }

  @AfterMethod
  public void tearDown() throws Exception {
    app.stop();
  }

}
