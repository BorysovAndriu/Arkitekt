package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class HelperBase {
  public WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  public void openSite(String url){
    driver.navigate().to(url);
  }

  public void type(String text, By locator) {
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
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

  public void checking(String text, By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    String existingText = driver.findElement(locator).getAttribute("value");
    assertEquals(text, existingText);
  }

  public void checkingText(String text, By locator) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 30);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    String existingText = driver.findElement(locator).getText();
    assertEquals(text, existingText);
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

  public String getIdPage(By locator) {
    String id = driver.findElement(locator).getAttribute("id");
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

    public void refresh() {
      driver.navigate().refresh();
    }

}
