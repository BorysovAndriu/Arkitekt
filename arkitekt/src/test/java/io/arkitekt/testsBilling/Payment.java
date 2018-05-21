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
    app.getLoginHelper().checkout("Andriu","4242-4242-4242-4242","123","12", "19");
    app.getNavHelperLeftPanel().stopFrame();
    app.getNavHelperLeftPanel().initListSite();
    app.getLoginHelper().logout();
  }

  @Test(priority = 2)
  public void changeBillingCycle() throws InterruptedException {
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelperLeftPanel().gotoSettingBilling();
    app.getNavHelperLeftPanel().changeCycle();
  }

  @Test(priority = 4)
  public void cancelSubscription() throws InterruptedException {
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelperLeftPanel().gotoSettingBilling();
    app.getNavHelperLeftPanel().cancelSubscribpition();
    app.getNavHelperLeftPanel().checking("SUBSCRIBE", By.id("billing_subscribe"));
  }
}
