package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteEditHelper {

  private WebDriver driver;

  public SiteEditHelper(WebDriver driver) {
    this.driver = driver;
  }

  public void createSite() {
    driver.findElement(By.linkText("Create New Site")).click();
    driver.findElement(By.xpath("//img[@alt='Marathon']")).click();
  }

  public void deleteSite() {
    driver.findElement(By.xpath("//div[@id='settings_site_general']/div/div[2]/div[5]/button")).click();
  }
}
