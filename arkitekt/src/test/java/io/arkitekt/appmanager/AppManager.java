package io.arkitekt.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class AppManager {

  WebDriver driver;
  Actions builder;

  private NavHelperLeftPanel navHelperLeftPanel;
  private LoginHelper loginHelper;
  private SiteEditHelper siteEditHelper;
  private NavHelperBuilder navHelperBuilder;
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

    driver.manage().window().maximize();

    builder = new Actions(driver);

    loginHelper = new LoginHelper(driver);
    navHelperLeftPanel = new NavHelperLeftPanel(driver);
    siteEditHelper = new SiteEditHelper(driver);
    navHelperBuilder = new NavHelperBuilder(driver);

  }

  public void stop() {
    driver.quit();
  }

  public LoginHelper getLoginHelper() {
    return loginHelper;
  }

  public NavHelperLeftPanel getNavHelperLeftPanel() {
    return navHelperLeftPanel;
  }

  public SiteEditHelper getSiteEditHelper() {
    return siteEditHelper;
  }

  public NavHelperBuilder getNavHelperBuilder() {
    return navHelperBuilder;
  }

}

