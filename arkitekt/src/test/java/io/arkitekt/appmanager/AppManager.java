package io.arkitekt.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class AppManager {

    public WebDriver driver;
    Actions builder;

    public io.arkitekt.appManager.NavHelperLeftPanel navHelperLeftPanel;
    public io.arkitekt.appManager.LoginHelper loginHelper;
    public io.arkitekt.appManager.SiteEditHelper siteEditHelper;
    public io.arkitekt.appManager.NavHelperBuilder navHelperBuilder;
    private String browser;
    public io.arkitekt.appManager.BillingHelper billingHelper;

    public AppManager(String browser) {
        this.browser = browser;
    }

    public AppManager() {
    }

    public void init() {

        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        builder = new Actions(driver);

        loginHelper = new io.arkitekt.appManager.LoginHelper(driver);
        navHelperLeftPanel = new io.arkitekt.appManager.NavHelperLeftPanel(driver);
        siteEditHelper = new io.arkitekt.appManager.SiteEditHelper(driver);
        navHelperBuilder = new io.arkitekt.appManager.NavHelperBuilder(driver);
        billingHelper = new io.arkitekt.appManager.BillingHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public io.arkitekt.appManager.LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public io.arkitekt.appManager.NavHelperLeftPanel getNavHelperLeftPanel() {
        return navHelperLeftPanel;
    }

    public io.arkitekt.appManager.SiteEditHelper getSiteEditHelper() {
        return siteEditHelper;
    }

    public io.arkitekt.appManager.NavHelperBuilder getNavHelperBuilder() {
        return navHelperBuilder;
    }

    public io.arkitekt.appManager.BillingHelper getBillingHelper() {
        return billingHelper;
    }

}

