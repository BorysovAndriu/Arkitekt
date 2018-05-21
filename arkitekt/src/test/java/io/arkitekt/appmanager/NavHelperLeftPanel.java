package io.arkitekt.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavHelperLeftPanel extends HelperBase{
  private WebDriver driver;

  public NavHelperLeftPanel(WebDriver driver) {
    super(driver);
  }

  public void logo() {
    click(By.xpath("//div[@id='content']/div/div/a"));
  }

  public void gotoGetStart() {
    click(By.xpath("//a[text()='Get started']"));
  }

  public void gotoMarathon(){
    click(By.xpath("//img[@alt='Marathon']"));
  }

  public void initListSite() {
    while(isElementPressent(By.cssSelector("#choose_template[aria-expanded=\"false\"]"))){
      click(By.cssSelector("#choose_template"));
    }
  }

  public void gotoSettingSiteGeneraInfo() {
    click(By.xpath("//div[@class='col-xs-12 user-box-list']/ul/li[5]/a"));
    click(By.xpath("//li//a[@href='#!/settings/site']"));
    click(By.xpath("//li//a[@href='#!/settings/site/general']"));
  }

  public void gotoSettingBilling() {
    click(By.xpath("//div[@class='col-xs-12 user-box-list']/ul/li[5]/a"));
    click(By.xpath("//li//a[@href='#!/settings/billing-info']"));
  }

  public void cancelSubscribpition() {
    click(By.xpath("//a[@href='#!/settings/billing-info/cancel-subscription']"));
    click(By.xpath("//input[@value='CONFIRM']"));
  }

  public void changeCycle() {
    click(By.xpath("//*[@id='settings_billing_info']//input"));
    click(By.xpath("//ul[@class='dropdown-content select-dropdown active']/li[2]/span"));
    click(By.xpath("//div[@id='settings_billing_info']//button[text()]"));
  }

  public void gobackBillingInfo() {
    click(By.xpath("//div[@id='settings_billing_info']//a[@href='#!/settings']"));
    click(By.xpath("//h4[text()='Settings']/parent::div/a"));

  }


}
