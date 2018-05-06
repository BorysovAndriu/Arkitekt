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
  }


  public void deleteSite() {
    click(By.xpath("//div[@id=\"settings_site_general\"]//button[@class='btn btn-default btn-raised btn-gray waves-effect waves-button']"));
  }

  public int getSiteCount() {
    return driver.findElements(By.xpath("//div[@id='sites_list']/div/ul/li")).size();
  }
}
