package io.arkitekt.testsBilling;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Payment extends TestBasePay {

  @Test(priority = 1)
  public void subscription() throws InterruptedException {
    app.getBillingHelper().gotoSubscribpition();
    app.getBillingHelper().checkout("Andriu","4242-4242-4242-4242",
            "123","12", "19");
    app.getNavHelperLeftPanel().checking("Monthly",
            By.xpath("//*[@id='settings_billing_info']//input"), "value");
  }

  @Test(priority = 2)
  public void changeBillingCycle() throws InterruptedException {
    app.getBillingHelper().changeCycle();
    app.getNavHelperLeftPanel().checking("Annual",
            By.xpath("//*[@id='settings_billing_info']//input"), "value");
  }

  @Test(priority = 3)
  public void updateBillingCycle() throws InterruptedException {
    app.getBillingHelper().updatePaymentInfo("Boris", "5105-1051-0510-5100",
            "123", "12", "20");
    app.getLoginHelper().checkingText("5100",
            By.xpath("//div[@class='settings-billing-card-number']"));
  }

  @Test(priority = 4)
  public void cancelSubscription() throws InterruptedException {
    app.getBillingHelper().cancelSubscribpition();
    app.getNavHelperLeftPanel().checkingText("Expired On:",
            By.xpath("//p[@class='help-block settings-billing-date']"));
  }

  @Test(priority = 5)
  public void repeatSubscription() throws InterruptedException {
    app.getBillingHelper().chooseSubscribtionPrice();
    app.getBillingHelper().checkout("Andriu","4242-4242-4242-4242",
            "123","12", "19");
    app.getNavHelperLeftPanel().checking("Annual",
            By.xpath("//*[@id='settings_billing_info']//input"), "value");
  }

}
