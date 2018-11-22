package io.arkitekt.appManager.operationWidgets;

import io.arkitekt.appManager.operationPages.PagesHelperBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class AppManagerWidgets{

    private String browser;
    public WebDriver driver;
    Actions builder;

    private WidgetsHelperBase widgetsHelper;
    private PagesHelperBase pagesHelper;
    private BlogHelper blogHelper;

    public AppManagerWidgets(String browser) {
        this.browser = browser;
    }

    public void init() {

        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.EDGE)) {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://preprod.arkitekt.io/");

        builder = new Actions(driver);

        widgetsHelper = new WidgetsHelperBase(driver);
        pagesHelper = new PagesHelperBase(driver);
        blogHelper = new BlogHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public WidgetsHelperBase getWidgetsHelper() {
        return widgetsHelper;
    }
    public PagesHelperBase getPagesHelper() {return  pagesHelper;}
    public BlogHelper getBlogHelper() {return  blogHelper;}

}

