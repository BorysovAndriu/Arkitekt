package io.arkitekt.mainWorker;

import io.arkitekt.mainWorker.operationBilling.BillingHelper;
import io.arkitekt.mainWorker.operationMainSite.MainSiteHelper;
import io.arkitekt.mainWorker.operationMainSite.NavHelperBuilder;
import io.arkitekt.mainWorker.operationPages.PagesBackgroundHelper;
import io.arkitekt.mainWorker.operationPages.PagesBannerHelper;
import io.arkitekt.mainWorker.operationPages.PagesHelperBase;
import io.arkitekt.mainWorker.operationPages.PagesHyperlinkHelper;
import io.arkitekt.mainWorker.operationWidgets.BlogHelper;
import io.arkitekt.mainWorker.operationWidgets.MainSite;
import io.arkitekt.mainWorker.operationsAdminPanel.NavHelperLeftPanel;
import io.arkitekt.mainWorker.operationsAdminPanel.SiteEditHelper;
import io.arkitekt.mainWorker.operationsLogin.LoginHelper;
import io.arkitekt.mainWorker.operationsMail.MailHelper;
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

public class launcherApp {

    private Properties properties;
    public WebDriver driver;
    Actions builder;

    public MainSiteHelper mainSiteHelper;

    public BillingHelper billingHelper;

    private PagesHelperBase pagesHelper;
    private PagesBannerHelper bannerHelper;
    private PagesBackgroundHelper backgroundHelper;
    private PagesHyperlinkHelper hyperlinkHelper;

    private MainSite widgetsHelper;
    private BlogHelper blogHelper;

    public NavHelperLeftPanel navHelperLeftPanel;
    public LoginHelper loginHelper;
    public SiteEditHelper siteEditHelper;
    public NavHelperBuilder navHelperBuilder;


    private MailHelper mailHelper;
    private String browser;

    public launcherApp(String browser) {
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

        mainSiteHelper = new MainSiteHelper(driver);

        billingHelper = new BillingHelper(driver);

        pagesHelper = new PagesHelperBase(driver);
        bannerHelper = new PagesBannerHelper(driver);
        backgroundHelper = new PagesBackgroundHelper(driver);
        hyperlinkHelper = new PagesHyperlinkHelper(driver);

        widgetsHelper = new MainSite(driver);
        blogHelper = new BlogHelper(driver);

        loginHelper = new LoginHelper(driver);
        navHelperLeftPanel = new NavHelperLeftPanel(driver);
        siteEditHelper = new SiteEditHelper(driver);
        navHelperBuilder = new NavHelperBuilder(driver);

    }

    public void stop() {
        driver.quit();
    }

    public MainSiteHelper getMainSiteHelper() {
        return mainSiteHelper;
    }

    public BillingHelper getBillingHelper() {
        return billingHelper;
    }

    public PagesHelperBase getPagesHelper() {
        return pagesHelper;
    }
    public PagesBannerHelper getBannerHelper() {
        return bannerHelper;
    }
    public PagesBackgroundHelper getBackgroundHelper() {return backgroundHelper;}
    public PagesHyperlinkHelper getHyperlinkHelper() {return hyperlinkHelper;}

    public MainSite getWidgetsHelper() {
        return widgetsHelper;
    }
    public BlogHelper getBlogHelper() {return  blogHelper;}

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



   /* розробка
   public HttpSession newSession() {
        return new HttpSession(this);
    }

    public MailHelper mail() {
        if(mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }
    */

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}

