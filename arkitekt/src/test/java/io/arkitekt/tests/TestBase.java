package io.arkitekt.tests;

import io.arkitekt.appmanager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

  Date date = new Date();
  SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");

  protected static final AppManager app = new AppManager(BrowserType.FIREFOX);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init("http://staging.arkitekt.io./");
  }

  @AfterSuite
  public void tearDown() throws Exception {
    app.stop();
  }

}
