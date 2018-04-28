package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {

  WebDriver driver;

  private NavHelper navHelper;
  private LoginHelper loginHelper;
  private SiteEditHelper siteEditHelper;

  public void init() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    loginHelper = new LoginHelper(driver);
    navHelper = new NavHelper(driver);
    siteEditHelper = new SiteEditHelper(driver);
    driver.get("http://staging.arkitekt.io./");
  }

  public void stop() {
    driver.quit();
  }

  public LoginHelper getLoginHelper() {
    return loginHelper;
  }

  public NavHelper getNavHelper() {
    return navHelper;
  }

  public SiteEditHelper getSiteEditHelper() {
    return siteEditHelper;
  }
}

