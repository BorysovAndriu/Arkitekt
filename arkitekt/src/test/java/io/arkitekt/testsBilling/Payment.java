package io.arkitekt.testsBilling;

import io.arkitekt.testsRegistration.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Payment extends TestBase {

  @Test
  public void paymentWithoutBuilder () {
    app.getNavHelper().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelper().click(By.xpath("//span[@class='subscription_toast']"));
    app.getNavHelper().gotoFrame(By.cssSelector("#new_subscription_iframe"));
    app.getNavHelper().type("Andriu", By.xpath("//*[@id=\"payment-form\"]/div[2]/div[2]/label/input"));


  }
}
