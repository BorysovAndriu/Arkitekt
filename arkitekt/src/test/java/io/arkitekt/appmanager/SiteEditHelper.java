package io.arkitekt.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SiteEditHelper extends HelperBase{

  private WebDriver driver;

  public SiteEditHelper(WebDriver driver) {
    super(driver);
  }

  public void createSite() throws InterruptedException {
    click(By.xpath("//*[@id=\"sites_list\"]/div/ul/li[1]/div/a"));
  }


  public void deleteSite() throws InterruptedException {
    click(By.xpath("//*[@id=\"settings_site_general\"]/div/div[2]/div[5]/button"));
    Thread.sleep(10000);
  }

  public int getSiteCount() {
    return driver.findElements(By.xpath("//div[@id='sites_list']/div/ul/li")).size();
  }
}
