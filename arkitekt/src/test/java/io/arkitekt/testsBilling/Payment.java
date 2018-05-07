package io.arkitekt.testsBilling;

import io.arkitekt.testsRegistration.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Payment extends TestBase {

  @Test
  public void paymentWithoutBuilder () throws InterruptedException {
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelperLeftPanel().click(By.xpath("//span[@class='subscription_toast']"));
    app.getNavHelperLeftPanel().gotoFrame(By.cssSelector("#new_subscription_iframe"));
    app.getLoginHelper().checkout("Andriu","4242-4242-4242-4242","123","12", "19");
    app.getNavHelperLeftPanel().stopFrame();
  }
}
