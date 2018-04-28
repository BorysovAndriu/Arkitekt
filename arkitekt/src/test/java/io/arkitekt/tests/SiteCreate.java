package io.arkitekt.tests;

import org.testng.annotations.Test;

public class SiteCreate extends TestBase {

  @Test
  public void testCreateSite() throws Exception {
    app.login("andriu.test.post.1@gmail.com","1111111111" );
    app.initListSite();
    app.createSite();
  }

}

