package io.arkitekt.mainWorker.operationMainSite;

import io.arkitekt.mainWorker.operationsMainSelenium.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class MainSiteHelper extends HelperBase {
    public MainSiteHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(@class,'btn') and text()='Sign in']")
    public WebElement buttonSignIn;

    By burgerMobile = By.xpath("//button[contains(@class, 'navbar')]");
    By buttonCreateMyWebsite = By.xpath("//a[contains(@class, 'ripple-btn ripple')]");
    By buttonGetStarted = By.xpath("//*[contains(@class, 'get-started-btn')]");
    By buttonStartWithThisTheme = By.name("commit");
    By buttonSignInOnSignUp = By.id("switch_btn");
    By textHeaderSignUp = By.xpath("//*[contains(@class, 'sign-up-head')]");
    By textHeaderSignIn = By.xpath("//*[contains(@class, 'sign-head')]");
    By logoOnSignInPage = By.xpath("//*[contains(@class, 'logo-image center-block')]");

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



}
