package io.arkitekt.testsRegistration;

import org.testng.annotations.Test;

public class SignIn extends TestBase {

  @Test
  public void testSignIn()  {
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com", "1111111111");
    app.getNavHelperLeftPanel().initListSite();
    app.getLoginHelper().logout();
    app.getNavHelperLeftPanel().logo();

  }

}
