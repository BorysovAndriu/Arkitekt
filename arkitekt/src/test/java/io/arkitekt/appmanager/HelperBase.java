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
  public Actions builder;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  public void openSite(String url){
    driver.navigate().to(url);
  }

  public void type(String text, By locator) {
    clickA(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void clickA(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 120);
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    driver.findElement(locator).click();
  }

  public void click(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 120);
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
    WebDriverWait wait = new WebDriverWait(driver, 100);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    driver.switchTo().frame(driver.findElement(locator));
  }

  public void stopFrame() throws InterruptedException {
    driver.switchTo().defaultContent();
    Thread.sleep(5000);
  }

  public void closeTab() throws InterruptedException {
    driver.close();
    Thread.sleep(5000);
  }

  public void checking(String text, By locator) throws InterruptedException {
    Thread.sleep(10000);
    String existingText = driver.findElement(locator).getAttribute("value");
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

    public void hover(By locatorFind, By locatorClick) throws InterruptedException {

      WebElement preview = driver.findElement(locatorFind);
      new Actions(driver).
              moveToElement(preview).
              perform();

      Thread.sleep(10000);
      driver.findElement(locatorClick).click();
    }
}
