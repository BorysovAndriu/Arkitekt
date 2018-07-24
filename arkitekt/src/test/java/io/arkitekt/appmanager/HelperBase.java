package io.arkitekt.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class HelperBase {
    public WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite(String url) {
        driver.navigate().to(url);
    }

    public void type(String text, By locator) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    public void typeN(String text, By locator) throws InterruptedException {
        click(locator);
        Thread.sleep(5000);
        driver.findElement(locator).sendKeys((Keys.ENTER), text);
    }

    public void clickA(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public String gotoTab() throws InterruptedException {
        String firstTab = driver.getWindowHandle();
        clickA(By.xpath("//a[@class='simple-btn ripple-btn']"));
        Thread.sleep(5000);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        return firstTab;
    }

    public void gotoFrame(By locator) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.switchTo().frame(driver.findElement(locator));
        Thread.sleep(10000);
    }

    public void stopFrame() throws InterruptedException {
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    public void closeTab() throws InterruptedException {
        driver.close();
        Thread.sleep(5000);
    }

    public void checking(String text, By locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String existingText = driver.findElement(locator).getAttribute(value);
        assertEquals(text, existingText);
    }

    public void checkingText(String text, By locator) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String existingText = driver.findElement(locator).getText();
        assertEquals(text, existingText);
    }

    public boolean isElementFound(String text, By locator, String value) {
        try {
            checking(text, locator, value);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isElementPressent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public String getId(By locator) {
        String id = driver.findElement(locator).getAttribute("id");
        id = id.replaceAll("[^0-9]", "");
        return id;
    }

    public String getIdPage(String text, By locator) {
        String id = driver.findElement(locator).getAttribute(text);
        return id;
    }

    public void hover(By locatorFind, By locatorClick) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorFind));
        new Actions(driver).
                moveToElement(driver.findElement(locatorFind)).build().perform();
        Thread.sleep(2000);
        click(locatorClick);
    }

    public void slider(By container, By slider, int x, int y) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
                (container));
        new Actions(driver).
                moveToElement(driver.findElement(container)).
                clickAndHold(driver.findElement(slider)).moveByOffset(x, y).release().build().perform();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void attachImage(By locator, String namepath) {
        File file = new File(namepath);
        driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void doubleClick(By locator) {
        new Actions(driver).doubleClick(driver.findElement(locator)).build().perform();
    }

    public By findPagesCards(int x){
        By locator = By.xpath("//div[@id=\"site_pages\"]/div[1]/div[1]");
        String idFirstPage = getId(locator);
        String idSubPage = getIdPage ("id",
                By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]",idFirstPage)));
        By subpage = By.xpath(String.format("//div[@id='%s']",idSubPage));

        if (x==2) {
            checking("container", locator, "data-type");
            By container = By.xpath(String.format("//div[@id='%s']/div[1]", idFirstPage));
            return container;
        }
        else if (x==22) {
            checking("page", subpage, "data-type");
            By subpageContainer = By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]", idFirstPage));
            return subpageContainer;
        }
        else if (x==1) {
            checking("page", locator, "data-type");
            By page = By.xpath(String.format("//div[@id='page-%s']", idFirstPage));
            return page;
        }
        else if (x==3) {
            checking("folder", locator, "data-type");
            By dropdown = By.xpath(String.format("//div[@id='page-%s']/div[1]", idFirstPage));
            return dropdown;
        }
        else if (x==33) {
            checking("page", subpage, "data-type");
            By subpageDropDown = By.xpath(String.format("//div[@class='page-subs ui-sortable' and @data-parent-id='%s']/div[1]", idFirstPage));
            return subpageDropDown;
        }
        else if (x==4) {
            checking("link", locator, "data-type");
            By link = By.xpath(String.format("//div[@id='page-%s']/div[1]", idFirstPage));
            return link;
        } else return locator;
    }

}

