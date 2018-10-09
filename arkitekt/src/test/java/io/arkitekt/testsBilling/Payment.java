package io.arkitekt.testsBilling;

import io.arkitekt.appManager.BillingData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Payment extends TestBasePay {

  @Test()
  public void createSite() throws InterruptedException {
    if (!app.getSiteEditHelper().isElementPressent(By.cssSelector("#choose_template"))) {
      app.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));
      app.getNavHelperLeftPanel().click(By.name("commit"));
      app.getNavHelperLeftPanel().initListSite(true);
      int after = app.getNavHelperLeftPanel().getCountSite();
      Assert.assertEquals(after, 1);
    } else {
      app.getNavHelperLeftPanel().initListSite(true);
      int before = app.getNavHelperLeftPanel().getCountSite();
      app.getSiteEditHelper().createSite();
      app.getNavHelperLeftPanel().gotoThemes(By.xpath("//img[@alt='Marathon']"));
      app.getNavHelperLeftPanel().click(By.name("commit"));
      app.getNavHelperLeftPanel().initListSite(true);
      int after = app.getNavHelperLeftPanel().getCountSite();
      app.getNavHelperLeftPanel().initListSite(false);
      Assert.assertEquals(after, before + 1);
    }
  }

  @Test(priority = 1)
  public void subscription() throws InterruptedException {
    app.getBillingHelper().gotoSubscribpition();
    app.getBillingHelper().fillCheckout(new BillingData("Andriu","4242-4242-4242-4242",
            "123","12", "19"), true);
    app.getBillingHelper().checkingBillingCycle("Monthly");
  }

  @Test(priority = 2)
  public void changeBillingCycle() throws InterruptedException {
    app.getBillingHelper().changeCycle();
    app.getBillingHelper().checkingBillingCycle("Annual");
  }

  @Test(priority = 3)
  public void updateBillingCycle() throws InterruptedException {
    app.getBillingHelper().fillCheckout(new BillingData("Boris", "5105-1051-0510-5100",
            "123", "12", "20"), false);
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
    app.getBillingHelper().fillCheckout(new BillingData("Andriu","4242-4242-4242-4242",
            "123","12", "19"), true);
    app.getBillingHelper().checkingBillingCycle("Annual");
  }

}
