package io.arkitekt;

import org.testng.annotations.Test;

public class SiteDelete extends TestBase{

  @Test
  public void testDeleteSite() throws Exception {
    login("andriu.test.post.1@gmail.com","1111111111" );
    gotoSetting();
    gotoSettingSite();
    gotoSettingSiteGeneraInfo();
    deleteSite();
  }

}
