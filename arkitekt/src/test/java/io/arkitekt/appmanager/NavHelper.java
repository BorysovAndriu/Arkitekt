package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavHelper extends HelperBase{
  private WebDriver driver;

  public NavHelper(WebDriver driver) {
    super(driver);
  }

  public void gotoSettingSiteGeneraInfo() {
    click(By.linkText("General Info"));
  }

  public void gotoSettingSite() {
    click(By.linkText("Site"));
  }

  public void gotoSetting() {
    click(By.linkText("Settings"));
  }

  public void initListSite() {
    click(By.id("choose_template"));
  }

  public void logo() {
    click(By.xpath("//div[@id='content']/div/div/a"));
  }

  public void gotoGetStart() {
    click(By.linkText("Get started"));
  }

  public void gotoMarathon(){
    click(By.xpath("//img[@alt='Marathon']"));
    click(By.name("commit"));
  }

  public void gotoLivePreview() {
    click(By.linkText("Live preview"));
  }
}
