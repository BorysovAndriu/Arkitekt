package io.arkitekt.testsRegistration;

import org.testng.annotations.Test;

public class SiteDelete extends TestBase {

  @Test
  public void testDeleteSite() throws Exception {
    app.getNavHelperLeftPanel().openSite("http://staging.arkitekt.io/");
    app.getLoginHelper().login("andriu02.05.18@gmail.com","1111111111" );
    app.getNavHelperLeftPanel().gotoSettingSiteGeneraInfo();
    app.getSiteEditHelper().deleteSite();
    app.getNavHelperLeftPanel().initListSite();
  }

}
