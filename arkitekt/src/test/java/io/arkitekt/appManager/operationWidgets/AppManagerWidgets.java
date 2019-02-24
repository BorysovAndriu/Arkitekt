package io.arkitekt.appManager.operationWidgets;

import io.arkitekt.appManager.operationPages.PagesHelperBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AppManagerWidgets{

    private String browser;
    public WebDriver driver;
    Actions builder;
    private final Properties properties;

    private MainSite widgetsHelper;
    private PagesHelperBase pagesHelper;
    private BlogHelper blogHelper;

    public AppManagerWidgets(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(properties.getProperty("web.baseUrl"));
        driver.manage().window().maximize();

        builder = new Actions(driver);

        widgetsHelper = new MainSite(driver);
        pagesHelper = new PagesHelperBase(driver);
        blogHelper = new BlogHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public MainSite getWidgetsHelper() {
        return widgetsHelper;
    }
    public PagesHelperBase getPagesHelper() {return  pagesHelper;}
    public BlogHelper getBlogHelper() {return  blogHelper;}

}

