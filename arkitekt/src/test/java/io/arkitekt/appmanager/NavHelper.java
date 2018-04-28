package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavHelper {
  private WebDriver driver;

  public NavHelper(WebDriver driver) {
    this.driver = driver;
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

  public void initListSite() {
    driver.findElement(By.id("choose_template")).click();
  }

  public void logo() {
    driver.findElement(By.xpath("//div[@id='content']/div/div/a")).click();
  }
}
