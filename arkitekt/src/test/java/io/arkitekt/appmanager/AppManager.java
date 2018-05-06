package io.arkitekt.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AppManager {

  WebDriver driver;

  private NavHelper navHelper;
  private LoginHelper loginHelper;
  private SiteEditHelper siteEditHelper;
  private String browser;

  public AppManager(String browser) {
    this.browser = browser;
  }

  public void init() {
    if (browser.equals(BrowserType.FIREFOX)) {
      driver = new FirefoxDriver();
    } else if(browser.equals(BrowserType.CHROME)) {
      driver = new ChromeDriver();
    } else if (browser.equals(BrowserType.EDGE)) {
      driver = new EdgeDriver();
    }

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    loginHelper = new LoginHelper(driver);
    navHelper = new NavHelper(driver);
    siteEditHelper = new SiteEditHelper(driver);
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

