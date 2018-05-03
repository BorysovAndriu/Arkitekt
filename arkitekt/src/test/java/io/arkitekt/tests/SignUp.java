package io.arkitekt.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class SignUp extends TestBase {

  @Test(enabled = false)
  public void testSignUp() {
    app.getNavHelper().click(By.linkText("Sign in"));
    app.getNavHelper().click(By.linkText("Sign up"));
    app.getNavHelper().gotoMarathon();
    app.getLoginHelper().registr("andriu","andriu"+format.format(date)+"@gmail.com", "1111111111");
    app.getNavHelper().initListSite();
  }
}
