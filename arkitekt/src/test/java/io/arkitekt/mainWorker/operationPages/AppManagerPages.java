package io.arkitekt.mainWorker.operationPages;

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

public class AppManagerPages{

    private final Properties properties;
    private String browser;
    public WebDriver driver;
    Actions builder;

    private PagesHelperBase pagesHelper;
    private PagesBannerHelper bannerHelper;
    private PagesBackgroundHelper backgroundHelper;
    private PagesHyperlinkHelper hyperlinkHelper;

    public AppManagerPages(String browser) {
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

        pagesHelper = new PagesHelperBase(driver);
        bannerHelper = new PagesBannerHelper(driver);
        backgroundHelper = new PagesBackgroundHelper(driver);
        hyperlinkHelper = new PagesHyperlinkHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public PagesHelperBase getPagesHelper() {
        return pagesHelper;
    }
    public PagesBannerHelper getBannerHelper() {
        return bannerHelper;
    }
    public PagesBackgroundHelper getBackgroundHelper() {return backgroundHelper;}
    public PagesHyperlinkHelper getHyperlinkHelper() {return hyperlinkHelper;}

}

