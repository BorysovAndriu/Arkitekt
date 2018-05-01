package io.arkitekt.tests;

import io.arkitekt.appmanager.AppManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

  Date date = new Date();
  SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");

  protected final AppManager app = new AppManager(BrowserType.FIREFOX);

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() throws Exception {
    app.stop();
  }

}
