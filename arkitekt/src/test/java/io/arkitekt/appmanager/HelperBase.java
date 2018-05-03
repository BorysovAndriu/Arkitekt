package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
  public WebDriver driver;

  public HelperBase(WebDriver driver) {
    this.driver = driver;
  }

  public void type(String text, By locator) {
    click(locator);
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);
  }

  public void click(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    driver.findElement(locator).click();
  }

  public void waitForButtonSeconds (By locator, int seconds) {
    WebDriverWait wait = new WebDriverWait(driver, seconds);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

  }

  public void gotoTab(){
    for (String l : driver.getWindowHandles()){
      driver.switchTo().window(l);
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
}
