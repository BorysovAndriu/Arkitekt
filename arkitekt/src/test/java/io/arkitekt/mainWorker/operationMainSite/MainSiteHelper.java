package io.arkitekt.mainWorker.operationMainSite;

import io.arkitekt.mainWorker.operationsMainSelenium.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class MainSiteHelper extends HelperBase {

    By burgerMobile = By.xpath("//button[contains(@class, 'navbar')]");
    By burgerOnNavigation = By.xpath("//button[contains(@class,'menu-btn')]");
    By buttonCreateMyWebsite = By.xpath("//a[contains(@class, 'ripple-btn ripple')]");
    By buttonGetStarted = By.xpath("//*[contains(@class, 'get-started-btn')]");
    By buttonStartWithThisTheme = By.name("commit");
    By buttonSignInOnSignUp = By.id("switch_btn");
    By buttonDiscoverThemes = By.xpath("//a[contains(@class, 'themes-btn ripple-btn')]");
    By buttonLivePreview = By.xpath("//a[contains(@class, 'simple-btn ripple-btn')]");
    By textHeaderSignUp = By.xpath("//*[contains(@class, 'sign-up-head')]");
    By textHeaderSignIn = By.xpath("//*[contains(@class, 'sign-head')]");
    By logoOnSignInPage = By.xpath("//*[contains(@class, 'logo-image center-block')]");

    @FindBy (xpath = "(//div[contains(@class, 'navbar_links')]/ul)[1]/li")
    public List <WebElement> navigationLinks;

    //MainPage
    String textOnMainPageForVerify = "//*[text()='%s']";
    String linkOnMenuMainPageMobile = "//ul[contains(@class,'sidebar-list')]//a[text()='%s']";
    String linkOnMenuMainPage = "//a[contains(@class,'nav-link') and text()='%s']";
    String linksNameOnMainPage[] = {"Portfolio", "Business", "Blog", "Music", "Personal", "Overview"};
    String linksNameOnMainPageMobile[] = {"Portfolio", "Business", "Blog", "Music", "Personal", "Overview",
            "Themes", "Pricing"};
    String linksNameOnThemesPage[] = {"Portfolio", "Business", "Blog", "Music", "Personal", "All"};
    //Themes Page
    String linkOnMenuThemesPage = "//ul[contains(@class,'list-inline')]//a[text()='%s']";
    String nameThemes[] = {"Marine", "Marathon", "Marathon", "Hoodie", "Waves", "Serenade"};
    String nameThemesForVerify = "//img[@alt='%s']";
    //Links on Navbar
    @FindBy (xpath = "//div[@id='mobilebar']//ul/li")
    public List <WebElement> linksOnMobileNavBar;

    By mobilebar = By.id("mobilebar");

    By linksOnMenuNavbar = By.xpath("//div[@class='topnav_container']/ul/li");
    By openDropDown = By.xpath("//li[@class='dropdown open']");
    String linksOnMenuNavbar1 = "//div[@class='topnav_container']/ul/li[%s]";

    public MainSiteHelper(WebDriver driver) {
        super(driver);
    }

    public void clickMenuOnMainPage() throws InterruptedException, IOException {

        for (int i = 0; i < linksNameOnMainPage.length; i++) {
            String linkName = linksNameOnMainPage[i];
            click(By.xpath(String.format(linkOnMenuMainPage, linkName)));
            Thread.sleep(1000);
            String textOnPageForVerify = readToPropertiesFile("local", linkName);
            checkingText(textOnPageForVerify, By.xpath(String.format(textOnMainPageForVerify, textOnPageForVerify)));
        }
    }

    public void clickMenuOnMainPageMobile() throws InterruptedException, IOException {

        resizeWindow(1119, 800);

        for (int i = 0; i < linksNameOnMainPageMobile.length; i++) {
            click(burgerMobile);
            String linkName = linksNameOnMainPageMobile[i];
            click(By.xpath(String.format(linkOnMenuMainPageMobile, linkName)));
            Thread.sleep(1000);
            String textOnPageForVerify = readToPropertiesFile("local", linkName);
            checkingText(textOnPageForVerify, By.xpath(String.format(textOnMainPageForVerify, textOnPageForVerify)));
            previousPage();
        }
    }

    public void clickMenuOnThemesPage() throws InterruptedException {

        navigationToPage("themes");

        for (int i = 0; i < linksNameOnThemesPage.length; i++) {
            String linkName = linksNameOnThemesPage[i];
            click(By.xpath(String.format(linkOnMenuThemesPage, linkName)));
            Thread.sleep(1000);
            String themesName = nameThemes[i];
            checking(themesName, By.xpath(String.format(nameThemesForVerify, themesName)), "alt");
        }
    }

    public void createMyWebsite() throws InterruptedException {

        resizeWindow(0, 0);

        for (int i = 0; i < nameThemes.length; i++) {
            scrollPageToElement("scroll(0,700);");
            Thread.sleep(1000);
            click(buttonCreateMyWebsite);
            click(By.xpath(String.format(nameThemesForVerify, nameThemes[i])));
            click(buttonStartWithThisTheme);
            checkingText("Create My Website", textHeaderSignUp);
            click(buttonSignInOnSignUp);
            checkingText("Sign in with your Arkitekt account.", textHeaderSignIn);
            click(logoOnSignInPage);
        }
    }

    public void getStarted() throws InterruptedException {

        resizeWindow(600, 800);

        for (int i = 0; i < nameThemes.length; i++) {
            click(buttonGetStarted);
            click(By.xpath(String.format(nameThemesForVerify, nameThemes[i])));
            click(buttonStartWithThisTheme);
            checkingText("Create My Website", textHeaderSignUp);
            click(buttonSignInOnSignUp);
            checkingText("Sign in with your Arkitekt account.", textHeaderSignIn);
            click(logoOnSignInPage);
        }
    }

    public void openPreviewThemes() throws InterruptedException {

        click(buttonDiscoverThemes);

        for (int i = 0; i < nameThemes.length; i++) {
            click(By.xpath(String.format(nameThemesForVerify, nameThemes[i])));
            click(buttonLivePreview);
            //gotoTab();
            for (String winNew : driver.getWindowHandles()) {
                Thread.sleep(1000);
                driver.switchTo().window(winNew);
            }

            if (isElementDisplayed(burgerOnNavigation)) {

                if (isVisible(mobilebar)) {

                    for (int l = 0; l < linksOnMobileNavBar.size(); l++) {
                        linksOnMobileNavBar.get(l).click();

                        if (isElementDisplayed(burgerOnNavigation)) {

                        } else if (isElementPresent(openDropDown)) {
                            //перевіряєм чи відкритий дропдаун на навбарі
                            List<WebElement> linksDropDown = driver.findElements(By.xpath("//li[@class='dropdown open']/ul/li"));
                            linksDropDown.get(0).click();
                            click(burgerOnNavigation);
                            click(By.xpath("(//li[@class='dropdown active'])[2]"));
                            for (int d = 1; d < linksDropDown.size(); d++) {
                                click(By.xpath("//li[@class='dropdown active open']/ul/li[" + d + "]/a"));
                                Thread.sleep(1000);
                                click(burgerOnNavigation);
                                click(By.xpath("(//li[@class='dropdown active'])[2]"));
                            }
                        }
                    }
                } else if (isElementDisplayed(linksOnMenuNavbar)) {
                    click(burgerOnNavigation);
                    List<WebElement> links = driver.findElements(linksOnMenuNavbar);
                    for (int l = 1; l < links.size() + 1; l++) {
                        Thread.sleep(1000);
                        click(By.xpath(String.format(linksOnMenuNavbar1, l)));

                        //перевіряєм чи відкритий навбар
                        if (isElementDisplayed(burgerOnNavigation)) {

                        } else if (isElementPresent(openDropDown)) {
                            //перевіряєм чи відкритий дропдаун на навбарі
                            List<WebElement> linksDropDown = driver.findElements(By.xpath("//li[@class='dropdown open']/ul/li"));
                            linksDropDown.get(0).click();
                            click(burgerOnNavigation);
                            click(By.xpath("(//li[@class='dropdown active'])[2]"));
                            for (int d = 1; d < linksDropDown.size(); d++) {
                                click(By.xpath("//li[@class='dropdown active open']/ul/li[" + d + "]/a"));
                                Thread.sleep(1000);
                                click(burgerOnNavigation);
                                click(By.xpath("(//li[@class='dropdown active'])[2]"));
                            }
                        }
                    }
                }
            } else {
                for (int l = 0; l < navigationLinks.size(); l++) {
                    navigationLinks.get(l).click();
                }
            }
            closeTab();
            previousPage();
        }

    }
}
