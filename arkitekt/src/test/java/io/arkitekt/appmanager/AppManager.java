package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
  public WebDriver driver;

  public void init() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://staging.arkitekt.io./");
  }

  public void login(String email, String password) {
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("user_email")).clear();
    driver.findElement(By.id("user_email")).sendKeys(email);
    driver.findElement(By.id("user_password")).click();
    driver.findElement(By.id("user_password")).clear();
    driver.findElement(By.id("user_password")).sendKeys(password);
    driver.findElement(By.name("commit")).click();
  }

  public void initListSite() {
    driver.findElement(By.id("choose_template")).click();
  }

  public void logout() {
    driver.findElement(By.name("commit")).click();
  }

  public void logo() {
    driver.findElement(By.xpath("//div[@id='content']/div/div/a")).click();
  }

  public void stop() {
    driver.quit();
  }

  public void createSite() {
    driver.findElement(By.linkText("Create New Site")).click();
    driver.findElement(By.xpath("//img[@alt='Marathon']")).click();
    driver.findElement(By.name("commit")).click();
    driver.findElement(By.linkText("Site")).click();
    }

  public void deleteSite() {
    driver.findElement(By.xpath("//div[@id='settings_site_general']/div/div[2]/div[5]/button")).click();
  }

  public void gotoSettingSiteGeneraInfo() {
    driver.findElement(By.linkText("General Info")).click();
  }

  public void gotoSettingSite() {
    driver.findElement(By.linkText("Site")).click();
  }

  public void gotoSetting() {
    driver.findElement(By.linkText("Settings")).click();
  }
}
