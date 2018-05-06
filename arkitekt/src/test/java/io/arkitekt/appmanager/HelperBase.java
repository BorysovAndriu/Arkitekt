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
    WebDriverWait wait = new WebDriverWait(driver, 120);
    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    driver.findElement(locator).click();
  }

   public void gotoTab() throws InterruptedException {
    String firstTab = driver.getWindowHandle();
    click(By.xpath("//a[@class='simple-btn ripple-btn']"));

    Thread.sleep(5000);

    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());

    driver.switchTo().window(newTab.get(1));
    Thread.sleep(10000);
    assertEquals("Marathon", driver.getTitle());
  }

  public void gotoFrame(By locator) throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 100);
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    driver.switchTo().frame(driver.findElement(locator));

  }

  public void stopFrame(){
    driver.switchTo().defaultContent();
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
