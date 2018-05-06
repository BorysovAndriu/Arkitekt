package io.arkitekt.testsRegistration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SignUp extends TestBase {

  @Test(enabled = false)
  public void testSignUp() {
    app.getNavHelper().openSite("http://staging.arkitekt.io/");
    app.getNavHelper().click(By.linkText("Sign in"));
    app.getNavHelper().click(By.linkText("Sign up"));
    app.getNavHelper().gotoMarathon();
    app.getLoginHelper().registr("andriu","andriu"+format.format(date)+"@gmail.com", "1111111111");
    app.getNavHelper().initListSite();
  }
}
