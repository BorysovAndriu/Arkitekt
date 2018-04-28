package io.arkitekt;

import org.testng.annotations.Test;

public class SignIn extends TestBase{

  @Test
  public void testSignIn() throws Exception {
    login("andriu.test.post.1@gmail.com", "1111111111");
    initListSite();
    logout();
    logo();
  }
}
