package io.arkitekt.testsRegistration;

import io.arkitekt.appmanager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

  Date date = new Date();
  SimpleDateFormat format = new SimpleDateFormat("yyyy.mm.dd");

  protected static final AppManager app = new AppManager(BrowserType.CHROME);


  @AfterTest
  public void setUpp() throws Exception {
    app.init();
  }

  @AfterTest
  public void tearDown() throws Exception {
    app.stop();
  }

}
