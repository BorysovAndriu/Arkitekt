package io.arkitekt.testsBilling;

import io.arkitekt.testsRegistration.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Payment extends TestBase {

  @Test(priority = 1)
  public void paymentbyBuilder() throws InterruptedException {
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelperLeftPanel().click(By.xpath("//span[@class='subscription_toast']"));
    app.getNavHelperLeftPanel().gotoFrame(By.cssSelector("#new_subscription_iframe"));
    app.getLoginHelper().checkout("Andriu","4242-4242-4242-4242",
            "123","12", "19");
    app.getNavHelperLeftPanel().stopFrame();
    app.getNavHelperLeftPanel().gotoSettingBilling();
    app.getNavHelperLeftPanel().checking("Monthly",
            By.xpath("//*[@id='settings_billing_info']//input"));
    app.getNavHelperLeftPanel().gobackBillingInfo();
    app.getNavHelperLeftPanel().initListSite();
    app.getLoginHelper().logout();
  }

  @Test(priority = 2)
  public void changeBillingCycle() throws InterruptedException {
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelperLeftPanel().gotoSettingBilling();
    app.getNavHelperLeftPanel().changeCycle();
    app.getNavHelperLeftPanel().checking("Annual",
            By.xpath("//*[@id='settings_billing_info']//input"));
    app.getNavHelperLeftPanel().gobackBillingInfo();
    app.getNavHelperLeftPanel().initListSite();
    app.getLoginHelper().logout();
  }

  @Test(priority = 3)
  public void updateBillingCycle() throws InterruptedException {
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelperLeftPanel().gotoSettingBilling();
    app.getLoginHelper().clickA(By.xpath("//a[@class='settings-billing-link']"));
    app.getNavHelperBuilder().gotoFrame(By.xpath("//iframe[@class='subscribe_iframe']"));
    app.getLoginHelper().updatePaymentInfo("Boris", "5105-1051-0510-5100",
            "123", "12", "20");
    app.getNavHelperBuilder().stopFrame();
    app.getLoginHelper().checkingText("5100",
            By.xpath("//div[@class='settings-billing-card-number']"));
  }

  @Test(priority = 4)
  public void cancelSubscription() throws InterruptedException {
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelperLeftPanel().gotoSettingBilling();
    app.getNavHelperLeftPanel().cancelSubscribpition();
    app.getNavHelperLeftPanel().checkingText("Expired On:",
            By.xpath("//p[@class='help-block settings-billing-date']"));
  }

  @Test(priority = 5)
  public void repeatSubscription() throws InterruptedException {
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelperLeftPanel().gotoSettingBilling();
    app.getNavHelperLeftPanel().click(By.id("billing_subscribe"));
    app.getNavHelperLeftPanel().gotoFrame(By.cssSelector("#new_subscription_iframe"));
    app.getLoginHelper().click(By.xpath("//label[@for='subscription_price_id_2']"));
    app.getLoginHelper().checkout("Andriu","4242-4242-4242-4242",
            "123","12", "19");
    app.getNavHelperLeftPanel().stopFrame();
    app.getNavHelperLeftPanel().checking("Annual",
            By.xpath("//*[@id='settings_billing_info']//input"));
    app.getNavHelperLeftPanel().gobackBillingInfo();
    app.getNavHelperLeftPanel().initListSite();
    app.getLoginHelper().logout();
  }

}
