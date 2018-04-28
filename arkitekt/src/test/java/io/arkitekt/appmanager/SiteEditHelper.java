package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteEditHelper extends HelperBase{

  private WebDriver driver;

  public SiteEditHelper(WebDriver driver) {
    super(driver);
  }

  public void createSite() {
    click(By.linkText("Create New Site"));
    click(By.xpath("//img[@alt='Marathon']"));
  }

  public void deleteSite() {
    click(By.xpath("//div[@id='settings_site_general']/div/div[2]/div[5]/button"));
  }
}
