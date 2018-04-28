package io.arkitekt.tests;

import org.testng.annotations.Test;

public class SignIn extends TestBase {

  @Test
  public void testSignIn() throws Exception {
    app.getLoginHelper().login("andriu.test.post.1@gmail.com", "1111111111");
    app.getNavHelper().initListSite();
    app.getLoginHelper().logout();
    app.getNavHelper().logo();
  }
}
