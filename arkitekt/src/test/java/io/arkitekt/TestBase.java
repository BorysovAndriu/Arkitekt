package io.arkitekt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
  public WebDriver driver;

  @BeforeMethod
  public void setUp() throws Exception {
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

  @AfterMethod
  public void tearDown() throws Exception {
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
