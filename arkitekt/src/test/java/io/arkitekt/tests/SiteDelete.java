package io.arkitekt.tests;

import org.testng.annotations.Test;

public class SiteDelete extends TestBase {

  @Test
  public void testDeleteSite() throws Exception {
    app.getLoginHelper().login("andriu.test.post.1@gmail.com","1111111111" );
    app.getNavHelper().gotoSetting();
    app.getNavHelper().gotoSettingSite();
    app.getNavHelper().gotoSettingSiteGeneraInfo();
    app.getSiteEditHelper().deleteSite();
  }

}
