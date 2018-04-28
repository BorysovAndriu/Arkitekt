package io.arkitekt.tests;

import org.testng.annotations.Test;

public class SiteCreate extends TestBase {

  @Test
  public void testCreateSite() throws Exception {
    app.getLoginHelper().login("andriu.test.post.1@gmail.com","1111111111" );
    app.getNavHelper().initListSite();
    app.getSiteEditHelper().createSite();
    app.getNavHelper().gotoMarathon();
  }

}

