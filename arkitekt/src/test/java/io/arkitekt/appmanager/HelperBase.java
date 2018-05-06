package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

  public void click(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 150);
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    driver.findElement(locator).click();
  }

  public void waitForButtonSeconds (By locator, int seconds) {
    WebDriverWait wait = new WebDriverWait(driver, seconds);
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

  }

  public void gotoTab() throws InterruptedException {
    String firstTab = driver.getWindowHandle();
    click(By.linkText("Live preview"));

    Thread.sleep(5000);

    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());

    driver.switchTo().window(newTab.get(1));
    Thread.sleep(10000);
    assertEquals("Marathon", driver.getTitle());
  }

  public void gotoFrame(By locator){
    WebDriverWait wait = new WebDriverWait(driver, 100);
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    driver.switchTo().frame(driver.findElement(locator));
  }


  public boolean isElementPressent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
