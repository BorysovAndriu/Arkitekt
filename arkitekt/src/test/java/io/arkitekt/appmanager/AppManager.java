package io.arkitekt.appManager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppManager {

    private Properties properties;
    public WebDriver driver;
    Actions builder;

    public io.arkitekt.appManager.NavHelperLeftPanel navHelperLeftPanel;
    public io.arkitekt.appManager.LoginHelper loginHelper;
    public io.arkitekt.appManager.SiteEditHelper siteEditHelper;
    public io.arkitekt.appManager.NavHelperBuilder navHelperBuilder;
    private String browser;
    public io.arkitekt.appManager.BillingHelper billingHelper;
    private MailHelper mailHelper;

    public AppManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if ("".equals(properties.getProperty("selenium.server"))) {
            if (browser.equals(BrowserType.FIREFOX)) {
                driver = new FirefoxDriver();
            } else if (browser.equals(BrowserType.CHROME)) {
                driver = new ChromeDriver();
            } else if (browser.equals(BrowserType.EDGE)) {
                driver = new EdgeDriver();
            }
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.fromString(System.getProperty("platform", "win10")));
            driver = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
            //System.getProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
            /**
             if(System.getProperty("platform") == "linux") {
             if (browser == "firefox") {
             System.getProperty("webdriver.gecko.driver", "/usr/local/bin");
             } else if (browser == "chrome") {
             System.getProperty("webdriver.chrome.driver", "/usr/local/share");
             }
             } else {
             if (browser == "firefox") {
             System.getProperty("webdriver.gecko.driver", "C:\\Users\\Andrew\\workspace\\gekodriver\\gekodriver.exe");
             } else if (browser == "chrome") {
             System.getProperty("webdriver.chrome.driver", "c:\\Users\\Andrew\\workspace\\chromedriver\\chromedriver.exe");
             }
             }
             */
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(properties.getProperty("web.baseUrl"));
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

   /* public HttpSession newSession() {
        return new HttpSession(this);
    }
*/
    public MailHelper mail() {
        if(mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}

