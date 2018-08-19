package io.arkitekt.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavHelperLeftPanel extends HelperBase{
  private WebDriver driver;

  public NavHelperLeftPanel(WebDriver driver) {
    super(driver);
  }

  public void logo() throws InterruptedException {
    click(By.xpath("//div[@id='content']/div/div/a"));
  }

  public void gotoGetStart() throws InterruptedException {
    click(By.xpath("//a[text()='Get started']"));
  }

  public void gotoMarathon() throws InterruptedException {
    click(By.xpath("//img[@alt='Marathon']"));
  }

  public void initListSite() throws InterruptedException {
    while(isElementPressent(By.cssSelector("#choose_template[aria-expanded=\"false\"]"))){
      click(By.cssSelector("#choose_template"));
    }
  }

  public void gotoSettingSiteGeneraInfo() throws InterruptedException {
    click(By.xpath("//div[@class='col-xs-12 user-box-list']/ul/li[5]/a"));
    click(By.xpath("//li//a[@href='#!/settings/site/general']"));
  }


}
