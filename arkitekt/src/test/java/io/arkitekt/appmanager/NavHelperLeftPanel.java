package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavHelperLeftPanel extends HelperBase{
  private WebDriver driver;

  public NavHelperLeftPanel(WebDriver driver) {
    super(driver);
  }

  public void gotoSettingSiteGeneraInfo() {
    click(By.xpath("//*[@id=\"settings_site\"]/div/div[2]/ul/li[1]/a"));
  }

  public void gotoSettingSite() {
    click(By.xpath("//div[2]/div[5]/div/div[2]/ul/li[2]/a"));
  }

  public void gotoSetting() {
    click(By.xpath("//div[1]/div/div/div[2]/ul/li[5]/a"));
  }

  public void initListSite() {
    click(By.xpath("//a[@id='choose_template']"));
  }

  public void logo() {
    click(By.xpath("//div[@id='content']/div/div/a"));
  }

  public void gotoGetStart() {
    click(By.xpath("//*[@id=\"content\"]/section[1]/div[4]/a"));
  }

  public void gotoMarathon(){
    click(By.xpath("//img[@alt='Marathon']"));
  }

}
